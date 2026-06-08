#include <windows.h>
#include <flutter/dart_project.h>
#include <flutter/flutter_view_controller.h>

#include <memory>
#include <string>

#include "common.h"

// Provided by widgets.dll
extern "C" void setBuildWidgetTree(buildWidgetTreeFn fn);

#define STARTER_EXPORT __declspec(dllexport)

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

  // Resolve the data directory from EWT_HOME, falling back to "data" (relative
  // to the current working directory) so the standard Flutter runner still works.
  std::wstring data_dir = L"data";
  const wchar_t* ewt_home = _wgetenv(L"EWT_HOME");
  if (ewt_home && ewt_home[0] != L'\0') {
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
