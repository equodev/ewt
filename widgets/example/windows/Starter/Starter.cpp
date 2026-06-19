#include <windows.h>
// rpcndr.h (pulled in by windows.h) defines 'small' as 'char', which
// conflicts with the generated factory member name in factories.h.
#ifdef small
#undef small
#endif

#include <flutter/dart_project.h>
#include <flutter/flutter_view_controller.h>

#include <memory>
#include <string>

#include "common.h"

// Provided by widgets.dll
extern "C" void setBuildWidgetTree(buildWidgetTreeFn fn);

#define STARTER_EXPORT __declspec(dllexport)

// Address anchor for GetModuleHandleExW self-location
extern "C" STARTER_EXPORT void EWT_Starter_AddressAnchor() {}

// Returns the directory containing Starter.dll, or empty string on failure.
static std::wstring GetDllDir() {
  HMODULE hModule = nullptr;
  if (!GetModuleHandleExW(
          GET_MODULE_HANDLE_EX_FLAG_FROM_ADDRESS |
          GET_MODULE_HANDLE_EX_FLAG_UNCHANGED_REFCOUNT,
          reinterpret_cast<LPCWSTR>(&EWT_Starter_AddressAnchor),
          &hModule)) {
    return L"";
  }
  wchar_t path[MAX_PATH];
  DWORD len = GetModuleFileNameW(hModule, path, MAX_PATH);
  if (len == 0 || len == MAX_PATH) return L"";
  wchar_t* last_sep = wcsrchr(path, L'\\');
  if (last_sep) *last_sep = L'\0';
  return std::wstring(path);
}

static std::unique_ptr<flutter::FlutterViewController> g_flutter_controller;

static LRESULT CALLBACK WndProc(HWND hwnd, UINT message,
                                 WPARAM wparam, LPARAM lparam) {
  if (g_flutter_controller) {
    auto result = g_flutter_controller->HandleTopLevelWindowProc(
        hwnd, message, wparam, lparam);
    if (result) {
      return *result;
    }
  }
  switch (message) {
    case WM_SIZE: {
      if (g_flutter_controller && g_flutter_controller->view()) {
        RECT rect;
        GetClientRect(hwnd, &rect);
        MoveWindow(g_flutter_controller->view()->GetNativeWindow(),
                   rect.left, rect.top,
                   rect.right - rect.left,
                   rect.bottom - rect.top, TRUE);
      }
      return 0;
    }
    case WM_ACTIVATE:
      if (g_flutter_controller && g_flutter_controller->view()) {
        SetFocus(g_flutter_controller->view()->GetNativeWindow());
      }
      return 0;
    case WM_FONTCHANGE:
      if (g_flutter_controller && g_flutter_controller->engine()) {
        g_flutter_controller->engine()->ReloadSystemFonts();
      }
      break;
    case WM_DESTROY:
      PostQuitMessage(0);
      return 0;
  }
  return DefWindowProc(hwnd, message, wparam, lparam);
}

extern "C" STARTER_EXPORT
int startApp(buildWidgetTreeFn buildWidgetTree) {
  setBuildWidgetTree(buildWidgetTree);

  ::CoInitializeEx(nullptr, COINIT_APARTMENTTHREADED);

  // Primary: locate data dir relative to this DLL.
  // JAR layout: lib/Starter.dll  →  ../data/ (flutter_assets, icudtl.dat)
  std::wstring dll_dir = GetDllDir();
  std::wstring raw_data = dll_dir.empty() ? L"data" : dll_dir + L"\\..\\data";
  wchar_t canonical[MAX_PATH];
  DWORD n = GetFullPathNameW(raw_data.c_str(), MAX_PATH, canonical, nullptr);
  std::wstring data_dir = (n > 0 && n < MAX_PATH) ? std::wstring(canonical) : raw_data;

  // Secondary: EWT_HOME overrides for development builds.
  wchar_t ewt_home[MAX_PATH] = {};
  if (GetEnvironmentVariableW(L"EWT_HOME", ewt_home, MAX_PATH) > 0) {
    data_dir = std::wstring(ewt_home) +
               L"\\widgets\\example\\build\\windows\\x64\\runner\\Release\\data";
  }

  flutter::DartProject project(data_dir);

  static bool class_registered = false;
  if (!class_registered) {
    WNDCLASS wc = {};
    wc.lpfnWndProc   = WndProc;
    wc.hInstance     = GetModuleHandle(nullptr);
    wc.lpszClassName = L"EWT_FLUTTER_WINDOW";
    wc.hCursor       = LoadCursor(nullptr, IDC_ARROW);
    wc.hbrBackground = reinterpret_cast<HBRUSH>(COLOR_WINDOW + 1);
    RegisterClass(&wc);
    class_registered = true;
  }

  HWND hwnd = CreateWindowEx(
      0,
      L"EWT_FLUTTER_WINDOW",
      L"EWT App",
      WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, CW_USEDEFAULT,
      1280, 720,
      nullptr, nullptr,
      GetModuleHandle(nullptr),
      nullptr);

  if (!hwnd) {
    ::CoUninitialize();
    return 1;
  }

  RECT frame;
  GetClientRect(hwnd, &frame);
  g_flutter_controller = std::make_unique<flutter::FlutterViewController>(
      frame.right - frame.left, frame.bottom - frame.top, project);

  if (!g_flutter_controller->engine() || !g_flutter_controller->view()) {
    g_flutter_controller = nullptr;
    DestroyWindow(hwnd);
    ::CoUninitialize();
    return 1;
  }

  SetParent(g_flutter_controller->view()->GetNativeWindow(), hwnd);
  MoveWindow(g_flutter_controller->view()->GetNativeWindow(),
             frame.left, frame.top,
             frame.right - frame.left, frame.bottom - frame.top, TRUE);

  // Show the window only after Flutter renders its first frame to avoid flicker.
  g_flutter_controller->engine()->SetNextFrameCallback([&]() {
    ShowWindow(hwnd, SW_SHOWNORMAL);
  });
  g_flutter_controller->ForceRedraw();

  MSG msg;
  while (::GetMessage(&msg, nullptr, 0, 0)) {
    ::TranslateMessage(&msg);
    ::DispatchMessage(&msg);
  }

  g_flutter_controller = nullptr;
  ::CoUninitialize();
  return static_cast<int>(msg.wParam);
}
