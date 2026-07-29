import 'package:flutter/rendering.dart';
import 'package:flutter/widgets.dart' as w;
import 'package:flutter/material.dart' as m;
import 'package:flutter/cupertino.dart' as c;
import 'subwidgets.dart' as s;
import 'sub_animated_state.dart' as sas;
import 'animation_controller_methods.dart' as acm;
import 'sub_animated_state_methods.dart' as sasm;

w.Widget? widget;
// w.StatefulWidget? statefulWidget;
w.TextStyle? textStyle;
w.Text? text;
w.InlineSpan? inlineSpan;
w.TextSpan? textSpan;
w.RichText? richText;
w.Center? center;
w.Column? column;
w.Row? row;
w.IconData? iconData;
w.Icon? icon;
w.BuildContext? buildContext;
w.Color? color;
w.Transform? transform;
w.Opacity? opacity;
w.Stack? stack;
w.BoxConstraints? boxConstraints;
w.Container? container;
RenderObject? renderObject;
w.RenderBox? renderBox;
StackParentData? stackParentData;
FlexParentData? flexParentData;
w.Positioned? positioned;
w.BoxDecoration? boxDecoration;
w.Radius? radius;
w.BorderRadius? borderRadius;
w.BoxShadow? boxShadow;
w.Padding? padding;
w.EdgeInsets? edgeInsets;
w.BorderSide? borderSide;
w.Border? border;
w.RoundedRectangleBorder? roundedRectangleBorder;
w.TickerProvider? tickerProvider;
w.AnimationController? animationController;
w.AnimatedBuilder? animatedBuilder;
w.Offset? offset;
w.Curve? curve;
w.Cubic? cubic;
w.ThreePointCubic? threePointCubic;
w.ElasticOutCurve? elasticOutCurve;
w.ElasticInCurve? elasticInCurve;
w.ElasticInOutCurve? elasticInOutCurve;
w.Curves? curves;
w.CurvedAnimation? curvedAnimation;
w.SizedBox? sizedBox;
w.Alignment? alignment;
w.AlignmentDirectional? alignmentDirectional;
w.MouseRegion? mouseRegion;
w.FontWeight? fontWeight;
Duration? duration;
w.Expanded? expanded;
w.SafeArea? safeArea;
w.MatrixTransition? matrixTransition;
w.RotationTransition? rotationTransition;
w.FadeTransition? fadeTransition;
w.ScaleTransition? scaleTransition;
w.Align? align;
w.AspectRatio? aspectRatio;
w.ClipOval? clipOval;
w.ClipRRect? clipRRect;
w.ClipRect? clipRect;
w.ColoredBox? coloredBox;
w.ConstrainedBox? constrainedBox;
w.DecoratedBox? decoratedBox;
w.FittedBox? fittedBox;
w.FractionallySizedBox? fractionallySizedBox;
w.IntrinsicHeight? intrinsicHeight;
w.IntrinsicWidth? intrinsicWidth;
w.LimitedBox? limitedBox;
w.Placeholder? placeholder;
w.Spacer? spacer;
w.Visibility? visibility;
w.RotatedBox? rotatedBox;
w.Baseline? baseline;
w.OverflowBox? overflowBox;
w.AnimatedContainer? animatedContainer;
w.AnimatedOpacity? animatedOpacity;
w.AnimatedPadding? animatedPadding;
w.AnimatedAlign? animatedAlign;
w.ListView? listView;
w.GridView? gridView;
w.PageView? pageView;
w.Flex? flex;

w.AnimatedSize? animatedSize;
w.AnimatedScale? animatedScale;
w.AnimatedRotation? animatedRotation;
w.AnimatedSlide? animatedSlide;
w.AnimatedCrossFade? animatedCrossFade;

w.SlideTransition? slideTransition;
w.SizeTransition? sizeTransition;

w.IndexedStack? indexedStack;
w.Flexible? flexible;

w.InteractiveViewer? interactiveViewer;

w.Draggable? draggable;
w.DragTarget? dragTarget;
// TweenAnimationBuilder skipped: requires Tween<T> (unsupported abstract).
// Emits Java shell but no factory — advertises unusable widget. Add once
// Tween<T> marshaling lands.

w.Hero? hero;

w.AnimatedSwitcher? animatedSwitcher;

// Abstract dart:ui types + widgets that need them. The abstract classes emit as
// interfaces + their factory ctors give concrete instances (blur, mode, matrix).
w.ImageFilter? imageFilter;
w.ColorFilter? colorFilter;
w.BackdropFilter? backdropFilter;
w.ColorFiltered? colorFiltered;
w.ImageFiltered? imageFiltered;
// Dismissible skipped: constructor requires `Key` (unsupported required type),
// no factory emitted — advertising it in coverage would lie about capability.

// w.FontWeight? fontWeight; constants accessing privates

m.Durations? durations;
m.ColorScheme? colorScheme;
m.TextTheme? textTheme;
m.VisualDensity? visualDensity;
m.ThemeData? themeData;
m.MaterialAccentColor? materialAccentColor;
m.MaterialColor? materialColor;
m.Colors? colors;
m.Material? material;
m.IconButton? iconButton;
m.AppBar? appBar;
m.Scaffold? scaffold;
m.MaterialApp? materialApp;
m.FloatingActionButton? floatingActionButton;
m.Icons? icons;
m.Theme? theme;
m.ElevatedButton? elevatedButton;
m.OutlinedButton? outlinedButton;
m.TextButton? textButton;
m.NavigatorState? navigatorState;
m.Navigator? navigator;
m.AlertDialog? alertDialog;
m.InputDecoration? inputDecoration;
m.TextField? textField;
m.TextDecoration? textDecoration;
m.Divider? divider;
m.FilledButton? filledButton;
m.OutlineInputBorder? outlineInputBorder;
m.SnackBarAction? snackBarAction;
m.SnackBar? snackBar;
m.ScaffoldMessenger? scaffoldMessenger;
m.Card? card;
m.Chip? chip;
w.GestureDetector? gestureDetector;
m.ListTile? listTile;
w.Wrap? wrap;
w.SingleChildScrollView? singleChildScrollView;
m.CircularProgressIndicator? circularProgressIndicator;
m.LinearProgressIndicator? linearProgressIndicator;
m.Checkbox? checkbox;
m.Switch? aSwitch;
m.Slider? slider;
m.Drawer? drawer;
m.Tooltip? tooltip;
m.Tab? tab;
m.TabBar? tabBar;
m.TabBarView? tabBarView;
m.DefaultTabController? defaultTabController;
m.CheckboxListTile? checkboxListTile;
m.SwitchListTile? switchListTile;
m.Badge? badge;

m.DataTable? dataTable;
m.DataColumn? dataColumn;
m.DataRow? dataRow;
m.DataCell? dataCell;
m.DropdownMenuEntry? dropdownMenuEntry;
m.Radio? radio;
m.RadioListTile? radioListTile;
m.ExpansionTile? expansionTile;
m.ExpansionPanel? expansionPanel;
m.ExpansionPanelList? expansionPanelList;
m.ExpansionPanelRadio? expansionPanelRadio;
m.NavigationRail? navigationRail;
m.NavigationRailDestination? navigationRailDestination;
m.NavigationBar? navigationBar;
m.NavigationDestination? navigationDestination;
m.NavigationDrawer? navigationDrawer;
m.NavigationDrawerDestination? navigationDrawerDestination;
m.PopupMenuButton? popupMenuButton;
m.PopupMenuItem? popupMenuItem;
m.PopupMenuDivider? popupMenuDivider;
m.CheckedPopupMenuItem? checkedPopupMenuItem;
m.CircleAvatar? circleAvatar;
m.Scrollbar? scrollbar;

m.MenuBar? menuBar;
m.MenuAnchor? menuAnchor;
m.SubmenuButton? submenuButton;
m.MenuItemButton? menuItemButton;
m.CheckboxMenuButton? checkboxMenuButton;
m.RadioMenuButton? radioMenuButton;

DateTime? dateTime;
m.TimeOfDay? timeOfDay;
m.DatePickerDialog? datePickerDialog;
m.CalendarDatePicker? calendarDatePicker;
m.TimePickerDialog? timePickerDialog;
m.DateRangePickerDialog? dateRangePickerDialog;
m.YearPicker? yearPicker;
m.InputDatePickerFormField? inputDatePickerFormField;

m.SearchBar? searchBar;

c.CupertinoApp? cupertinoApp;
c.CupertinoPageScaffold? cupertinoPageScaffold;
c.CupertinoNavigationBar? cupertinoNavigationBar;
c.CupertinoSliverNavigationBar? cupertinoSliverNavigationBar;
c.CupertinoTabView? cupertinoTabView;
c.CupertinoButton? cupertinoButton;
c.CupertinoSwitch? cupertinoSwitch;
c.CupertinoSlider? cupertinoSlider;
c.CupertinoSearchTextField? cupertinoSearchTextField;
c.CupertinoActivityIndicator? cupertinoActivityIndicator;
c.CupertinoListSection? cupertinoListSection;
c.CupertinoListTile? cupertinoListTile;
c.CupertinoListTileChevron? cupertinoListTileChevron;
c.CupertinoFormSection? cupertinoFormSection;
c.CupertinoFormRow? cupertinoFormRow;
c.CupertinoPicker? cupertinoPicker;
c.CupertinoAlertDialog? cupertinoAlertDialog;
c.CupertinoActionSheet? cupertinoActionSheet;
c.CupertinoDialogAction? cupertinoDialogAction;
c.CupertinoActionSheetAction? cupertinoActionSheetAction;
c.CupertinoIcons? cupertinoIcons;
c.CupertinoTextField? cupertinoTextField;
c.CupertinoCheckbox? cupertinoCheckbox;
// CupertinoScrollbar skipped: references private constants (defaultRadius/defaultRadiusWhileDragging)
c.CupertinoExpansionTile? cupertinoExpansionTile;
// CupertinoDatePicker skipped: getColumnWidth requires list-of-string marshaling not yet supported; no widget constructor in C factories
c.CupertinoTimerPicker? cupertinoTimerPicker;
c.CupertinoNavigationBarBackButton? cupertinoNavigationBarBackButton;
c.CupertinoTabBar? cupertinoTabBar;
c.CupertinoTabScaffold? cupertinoTabScaffold;
// CupertinoSliverRefreshControl skipped: RefreshCallback name collision between cupertino and material
c.CupertinoContextMenu? cupertinoContextMenu;
c.CupertinoContextMenuAction? cupertinoContextMenuAction;
w.BottomNavigationBarItem? bottomNavigationBarItem;

s.SubState? subState;
s.SubStatefulWidget? subStatefulWidget;
s.SubStatelessWidget? subStatelessWidget;
sas.SubAnimatedState? subAnimatedState;

acm.AnimationControllerMethods? animationControllerMethods;
sasm.SubAnimatedStateMethods? subAnimatedStateMethods;

const showDialog = m.showDialog;
const showDatePicker = m.showDatePicker;
const showTimePicker = m.showTimePicker;
const showDateRangePicker = m.showDateRangePicker;

void main() {
  //print('I am an index with the widgets to generate');
}
