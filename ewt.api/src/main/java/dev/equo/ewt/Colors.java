package dev.equo.ewt;
import java.util.*;
public interface Colors extends NativeObj, ColorsI {
  public static Color transparent() {
    return Color.color(0x00000000).build();
  }
  public static Color black() {
    return Color.color(0xFF000000).build();
  }
  public static Color black87() {
    return Color.color(0xDD000000).build();
  }
  public static Color black54() {
    return Color.color(0x8A000000).build();
  }
  public static Color black45() {
    return Color.color(0x73000000).build();
  }
  public static Color black38() {
    return Color.color(0x61000000).build();
  }
  public static Color black26() {
    return Color.color(0x42000000).build();
  }
  public static Color black12() {
    return Color.color(0x1F000000).build();
  }
  public static Color white() {
    return Color.color(0xFFFFFFFF).build();
  }
  public static Color white70() {
    return Color.color(0xB3FFFFFF).build();
  }
  public static Color white60() {
    return Color.color(0x99FFFFFF).build();
  }
  public static Color white54() {
    return Color.color(0x8AFFFFFF).build();
  }
  public static Color white38() {
    return Color.color(0x62FFFFFF).build();
  }
  public static Color white30() {
    return Color.color(0x4DFFFFFF).build();
  }
  public static Color white24() {
    return Color.color(0x3DFFFFFF).build();
  }
  public static Color white12() {
    return Color.color(0x1FFFFFFF).build();
  }
  public static Color white10() {
    return Color.color(0x1AFFFFFF).build();
  }
  public static MaterialColor red() {
    return MaterialColor.materialColor(_redPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFFEBEE).build()), Map.entry(100, Color.color(0xFFFFCDD2).build()), Map.entry(200, Color.color(0xFFEF9A9A).build()), Map.entry(300, Color.color(0xFFE57373).build()), Map.entry(400, Color.color(0xFFEF5350).build()), Map.entry(500, Color.color(_redPrimaryValue()).build()), Map.entry(600, Color.color(0xFFE53935).build()), Map.entry(700, Color.color(0xFFD32F2F).build()), Map.entry(800, Color.color(0xFFC62828).build()), Map.entry(900, Color.color(0xFFB71C1C).build()))).build();
  }
  private static int _redPrimaryValue() {
    return 0xFFF44336;
  }
  public static MaterialAccentColor redAccent() {
    return MaterialAccentColor.materialAccentColor(_redAccentValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFF8A80).build()), Map.entry(200, Color.color(_redAccentValue()).build()), Map.entry(400, Color.color(0xFFFF1744).build()), Map.entry(700, Color.color(0xFFD50000).build()))).build();
  }
  private static int _redAccentValue() {
    return 0xFFFF5252;
  }
  public static MaterialColor pink() {
    return MaterialColor.materialColor(_pinkPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFCE4EC).build()), Map.entry(100, Color.color(0xFFF8BBD0).build()), Map.entry(200, Color.color(0xFFF48FB1).build()), Map.entry(300, Color.color(0xFFF06292).build()), Map.entry(400, Color.color(0xFFEC407A).build()), Map.entry(500, Color.color(_pinkPrimaryValue()).build()), Map.entry(600, Color.color(0xFFD81B60).build()), Map.entry(700, Color.color(0xFFC2185B).build()), Map.entry(800, Color.color(0xFFAD1457).build()), Map.entry(900, Color.color(0xFF880E4F).build()))).build();
  }
  private static int _pinkPrimaryValue() {
    return 0xFFE91E63;
  }
  public static MaterialAccentColor pinkAccent() {
    return MaterialAccentColor.materialAccentColor(_pinkAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFF80AB).build()), Map.entry(200, Color.color(_pinkAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFF50057).build()), Map.entry(700, Color.color(0xFFC51162).build()))).build();
  }
  private static int _pinkAccentPrimaryValue() {
    return 0xFFFF4081;
  }
  public static MaterialColor purple() {
    return MaterialColor.materialColor(_purplePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFF3E5F5).build()), Map.entry(100, Color.color(0xFFE1BEE7).build()), Map.entry(200, Color.color(0xFFCE93D8).build()), Map.entry(300, Color.color(0xFFBA68C8).build()), Map.entry(400, Color.color(0xFFAB47BC).build()), Map.entry(500, Color.color(_purplePrimaryValue()).build()), Map.entry(600, Color.color(0xFF8E24AA).build()), Map.entry(700, Color.color(0xFF7B1FA2).build()), Map.entry(800, Color.color(0xFF6A1B9A).build()), Map.entry(900, Color.color(0xFF4A148C).build()))).build();
  }
  private static int _purplePrimaryValue() {
    return 0xFF9C27B0;
  }
  public static MaterialAccentColor purpleAccent() {
    return MaterialAccentColor.materialAccentColor(_purpleAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFEA80FC).build()), Map.entry(200, Color.color(_purpleAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFD500F9).build()), Map.entry(700, Color.color(0xFFAA00FF).build()))).build();
  }
  private static int _purpleAccentPrimaryValue() {
    return 0xFFE040FB;
  }
  public static MaterialColor deepPurple() {
    return MaterialColor.materialColor(_deepPurplePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFEDE7F6).build()), Map.entry(100, Color.color(0xFFD1C4E9).build()), Map.entry(200, Color.color(0xFFB39DDB).build()), Map.entry(300, Color.color(0xFF9575CD).build()), Map.entry(400, Color.color(0xFF7E57C2).build()), Map.entry(500, Color.color(_deepPurplePrimaryValue()).build()), Map.entry(600, Color.color(0xFF5E35B1).build()), Map.entry(700, Color.color(0xFF512DA8).build()), Map.entry(800, Color.color(0xFF4527A0).build()), Map.entry(900, Color.color(0xFF311B92).build()))).build();
  }
  private static int _deepPurplePrimaryValue() {
    return 0xFF673AB7;
  }
  public static MaterialAccentColor deepPurpleAccent() {
    return MaterialAccentColor.materialAccentColor(_deepPurpleAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFB388FF).build()), Map.entry(200, Color.color(_deepPurpleAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF651FFF).build()), Map.entry(700, Color.color(0xFF6200EA).build()))).build();
  }
  private static int _deepPurpleAccentPrimaryValue() {
    return 0xFF7C4DFF;
  }
  public static MaterialColor indigo() {
    return MaterialColor.materialColor(_indigoPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE8EAF6).build()), Map.entry(100, Color.color(0xFFC5CAE9).build()), Map.entry(200, Color.color(0xFF9FA8DA).build()), Map.entry(300, Color.color(0xFF7986CB).build()), Map.entry(400, Color.color(0xFF5C6BC0).build()), Map.entry(500, Color.color(_indigoPrimaryValue()).build()), Map.entry(600, Color.color(0xFF3949AB).build()), Map.entry(700, Color.color(0xFF303F9F).build()), Map.entry(800, Color.color(0xFF283593).build()), Map.entry(900, Color.color(0xFF1A237E).build()))).build();
  }
  private static int _indigoPrimaryValue() {
    return 0xFF3F51B5;
  }
  public static MaterialAccentColor indigoAccent() {
    return MaterialAccentColor.materialAccentColor(_indigoAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFF8C9EFF).build()), Map.entry(200, Color.color(_indigoAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF3D5AFE).build()), Map.entry(700, Color.color(0xFF304FFE).build()))).build();
  }
  private static int _indigoAccentPrimaryValue() {
    return 0xFF536DFE;
  }
  public static MaterialColor blue() {
    return MaterialColor.materialColor(_bluePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE3F2FD).build()), Map.entry(100, Color.color(0xFFBBDEFB).build()), Map.entry(200, Color.color(0xFF90CAF9).build()), Map.entry(300, Color.color(0xFF64B5F6).build()), Map.entry(400, Color.color(0xFF42A5F5).build()), Map.entry(500, Color.color(_bluePrimaryValue()).build()), Map.entry(600, Color.color(0xFF1E88E5).build()), Map.entry(700, Color.color(0xFF1976D2).build()), Map.entry(800, Color.color(0xFF1565C0).build()), Map.entry(900, Color.color(0xFF0D47A1).build()))).build();
  }
  private static int _bluePrimaryValue() {
    return 0xFF2196F3;
  }
  public static MaterialAccentColor blueAccent() {
    return MaterialAccentColor.materialAccentColor(_blueAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFF82B1FF).build()), Map.entry(200, Color.color(_blueAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF2979FF).build()), Map.entry(700, Color.color(0xFF2962FF).build()))).build();
  }
  private static int _blueAccentPrimaryValue() {
    return 0xFF448AFF;
  }
  public static MaterialColor lightBlue() {
    return MaterialColor.materialColor(_lightBluePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE1F5FE).build()), Map.entry(100, Color.color(0xFFB3E5FC).build()), Map.entry(200, Color.color(0xFF81D4FA).build()), Map.entry(300, Color.color(0xFF4FC3F7).build()), Map.entry(400, Color.color(0xFF29B6F6).build()), Map.entry(500, Color.color(_lightBluePrimaryValue()).build()), Map.entry(600, Color.color(0xFF039BE5).build()), Map.entry(700, Color.color(0xFF0288D1).build()), Map.entry(800, Color.color(0xFF0277BD).build()), Map.entry(900, Color.color(0xFF01579B).build()))).build();
  }
  private static int _lightBluePrimaryValue() {
    return 0xFF03A9F4;
  }
  public static MaterialAccentColor lightBlueAccent() {
    return MaterialAccentColor.materialAccentColor(_lightBlueAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFF80D8FF).build()), Map.entry(200, Color.color(_lightBlueAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF00B0FF).build()), Map.entry(700, Color.color(0xFF0091EA).build()))).build();
  }
  private static int _lightBlueAccentPrimaryValue() {
    return 0xFF40C4FF;
  }
  public static MaterialColor cyan() {
    return MaterialColor.materialColor(_cyanPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE0F7FA).build()), Map.entry(100, Color.color(0xFFB2EBF2).build()), Map.entry(200, Color.color(0xFF80DEEA).build()), Map.entry(300, Color.color(0xFF4DD0E1).build()), Map.entry(400, Color.color(0xFF26C6DA).build()), Map.entry(500, Color.color(_cyanPrimaryValue()).build()), Map.entry(600, Color.color(0xFF00ACC1).build()), Map.entry(700, Color.color(0xFF0097A7).build()), Map.entry(800, Color.color(0xFF00838F).build()), Map.entry(900, Color.color(0xFF006064).build()))).build();
  }
  private static int _cyanPrimaryValue() {
    return 0xFF00BCD4;
  }
  public static MaterialAccentColor cyanAccent() {
    return MaterialAccentColor.materialAccentColor(_cyanAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFF84FFFF).build()), Map.entry(200, Color.color(_cyanAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF00E5FF).build()), Map.entry(700, Color.color(0xFF00B8D4).build()))).build();
  }
  private static int _cyanAccentPrimaryValue() {
    return 0xFF18FFFF;
  }
  public static MaterialColor teal() {
    return MaterialColor.materialColor(_tealPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE0F2F1).build()), Map.entry(100, Color.color(0xFFB2DFDB).build()), Map.entry(200, Color.color(0xFF80CBC4).build()), Map.entry(300, Color.color(0xFF4DB6AC).build()), Map.entry(400, Color.color(0xFF26A69A).build()), Map.entry(500, Color.color(_tealPrimaryValue()).build()), Map.entry(600, Color.color(0xFF00897B).build()), Map.entry(700, Color.color(0xFF00796B).build()), Map.entry(800, Color.color(0xFF00695C).build()), Map.entry(900, Color.color(0xFF004D40).build()))).build();
  }
  private static int _tealPrimaryValue() {
    return 0xFF009688;
  }
  public static MaterialAccentColor tealAccent() {
    return MaterialAccentColor.materialAccentColor(_tealAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFA7FFEB).build()), Map.entry(200, Color.color(_tealAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF1DE9B6).build()), Map.entry(700, Color.color(0xFF00BFA5).build()))).build();
  }
  private static int _tealAccentPrimaryValue() {
    return 0xFF64FFDA;
  }
  public static MaterialColor green() {
    return MaterialColor.materialColor(_greenPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFE8F5E9).build()), Map.entry(100, Color.color(0xFFC8E6C9).build()), Map.entry(200, Color.color(0xFFA5D6A7).build()), Map.entry(300, Color.color(0xFF81C784).build()), Map.entry(400, Color.color(0xFF66BB6A).build()), Map.entry(500, Color.color(_greenPrimaryValue()).build()), Map.entry(600, Color.color(0xFF43A047).build()), Map.entry(700, Color.color(0xFF388E3C).build()), Map.entry(800, Color.color(0xFF2E7D32).build()), Map.entry(900, Color.color(0xFF1B5E20).build()))).build();
  }
  private static int _greenPrimaryValue() {
    return 0xFF4CAF50;
  }
  public static MaterialAccentColor greenAccent() {
    return MaterialAccentColor.materialAccentColor(_greenAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFB9F6CA).build()), Map.entry(200, Color.color(_greenAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF00E676).build()), Map.entry(700, Color.color(0xFF00C853).build()))).build();
  }
  private static int _greenAccentPrimaryValue() {
    return 0xFF69F0AE;
  }
  public static MaterialColor lightGreen() {
    return MaterialColor.materialColor(_lightGreenPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFF1F8E9).build()), Map.entry(100, Color.color(0xFFDCEDC8).build()), Map.entry(200, Color.color(0xFFC5E1A5).build()), Map.entry(300, Color.color(0xFFAED581).build()), Map.entry(400, Color.color(0xFF9CCC65).build()), Map.entry(500, Color.color(_lightGreenPrimaryValue()).build()), Map.entry(600, Color.color(0xFF7CB342).build()), Map.entry(700, Color.color(0xFF689F38).build()), Map.entry(800, Color.color(0xFF558B2F).build()), Map.entry(900, Color.color(0xFF33691E).build()))).build();
  }
  private static int _lightGreenPrimaryValue() {
    return 0xFF8BC34A;
  }
  public static MaterialAccentColor lightGreenAccent() {
    return MaterialAccentColor.materialAccentColor(_lightGreenAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFCCFF90).build()), Map.entry(200, Color.color(_lightGreenAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFF76FF03).build()), Map.entry(700, Color.color(0xFF64DD17).build()))).build();
  }
  private static int _lightGreenAccentPrimaryValue() {
    return 0xFFB2FF59;
  }
  public static MaterialColor lime() {
    return MaterialColor.materialColor(_limePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFF9FBE7).build()), Map.entry(100, Color.color(0xFFF0F4C3).build()), Map.entry(200, Color.color(0xFFE6EE9C).build()), Map.entry(300, Color.color(0xFFDCE775).build()), Map.entry(400, Color.color(0xFFD4E157).build()), Map.entry(500, Color.color(_limePrimaryValue()).build()), Map.entry(600, Color.color(0xFFC0CA33).build()), Map.entry(700, Color.color(0xFFAFB42B).build()), Map.entry(800, Color.color(0xFF9E9D24).build()), Map.entry(900, Color.color(0xFF827717).build()))).build();
  }
  private static int _limePrimaryValue() {
    return 0xFFCDDC39;
  }
  public static MaterialAccentColor limeAccent() {
    return MaterialAccentColor.materialAccentColor(_limeAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFF4FF81).build()), Map.entry(200, Color.color(_limeAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFC6FF00).build()), Map.entry(700, Color.color(0xFFAEEA00).build()))).build();
  }
  private static int _limeAccentPrimaryValue() {
    return 0xFFEEFF41;
  }
  public static MaterialColor yellow() {
    return MaterialColor.materialColor(_yellowPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFFFDE7).build()), Map.entry(100, Color.color(0xFFFFF9C4).build()), Map.entry(200, Color.color(0xFFFFF59D).build()), Map.entry(300, Color.color(0xFFFFF176).build()), Map.entry(400, Color.color(0xFFFFEE58).build()), Map.entry(500, Color.color(_yellowPrimaryValue()).build()), Map.entry(600, Color.color(0xFFFDD835).build()), Map.entry(700, Color.color(0xFFFBC02D).build()), Map.entry(800, Color.color(0xFFF9A825).build()), Map.entry(900, Color.color(0xFFF57F17).build()))).build();
  }
  private static int _yellowPrimaryValue() {
    return 0xFFFFEB3B;
  }
  public static MaterialAccentColor yellowAccent() {
    return MaterialAccentColor.materialAccentColor(_yellowAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFFFF8D).build()), Map.entry(200, Color.color(_yellowAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFFFEA00).build()), Map.entry(700, Color.color(0xFFFFD600).build()))).build();
  }
  private static int _yellowAccentPrimaryValue() {
    return 0xFFFFFF00;
  }
  public static MaterialColor amber() {
    return MaterialColor.materialColor(_amberPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFFF8E1).build()), Map.entry(100, Color.color(0xFFFFECB3).build()), Map.entry(200, Color.color(0xFFFFE082).build()), Map.entry(300, Color.color(0xFFFFD54F).build()), Map.entry(400, Color.color(0xFFFFCA28).build()), Map.entry(500, Color.color(_amberPrimaryValue()).build()), Map.entry(600, Color.color(0xFFFFB300).build()), Map.entry(700, Color.color(0xFFFFA000).build()), Map.entry(800, Color.color(0xFFFF8F00).build()), Map.entry(900, Color.color(0xFFFF6F00).build()))).build();
  }
  private static int _amberPrimaryValue() {
    return 0xFFFFC107;
  }
  public static MaterialAccentColor amberAccent() {
    return MaterialAccentColor.materialAccentColor(_amberAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFFE57F).build()), Map.entry(200, Color.color(_amberAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFFFC400).build()), Map.entry(700, Color.color(0xFFFFAB00).build()))).build();
  }
  private static int _amberAccentPrimaryValue() {
    return 0xFFFFD740;
  }
  public static MaterialColor orange() {
    return MaterialColor.materialColor(_orangePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFFF3E0).build()), Map.entry(100, Color.color(0xFFFFE0B2).build()), Map.entry(200, Color.color(0xFFFFCC80).build()), Map.entry(300, Color.color(0xFFFFB74D).build()), Map.entry(400, Color.color(0xFFFFA726).build()), Map.entry(500, Color.color(_orangePrimaryValue()).build()), Map.entry(600, Color.color(0xFFFB8C00).build()), Map.entry(700, Color.color(0xFFF57C00).build()), Map.entry(800, Color.color(0xFFEF6C00).build()), Map.entry(900, Color.color(0xFFE65100).build()))).build();
  }
  private static int _orangePrimaryValue() {
    return 0xFFFF9800;
  }
  public static MaterialAccentColor orangeAccent() {
    return MaterialAccentColor.materialAccentColor(_orangeAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFFD180).build()), Map.entry(200, Color.color(_orangeAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFFF9100).build()), Map.entry(700, Color.color(0xFFFF6D00).build()))).build();
  }
  private static int _orangeAccentPrimaryValue() {
    return 0xFFFFAB40;
  }
  public static MaterialColor deepOrange() {
    return MaterialColor.materialColor(_deepOrangePrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFBE9E7).build()), Map.entry(100, Color.color(0xFFFFCCBC).build()), Map.entry(200, Color.color(0xFFFFAB91).build()), Map.entry(300, Color.color(0xFFFF8A65).build()), Map.entry(400, Color.color(0xFFFF7043).build()), Map.entry(500, Color.color(_deepOrangePrimaryValue()).build()), Map.entry(600, Color.color(0xFFF4511E).build()), Map.entry(700, Color.color(0xFFE64A19).build()), Map.entry(800, Color.color(0xFFD84315).build()), Map.entry(900, Color.color(0xFFBF360C).build()))).build();
  }
  private static int _deepOrangePrimaryValue() {
    return 0xFFFF5722;
  }
  public static MaterialAccentColor deepOrangeAccent() {
    return MaterialAccentColor.materialAccentColor(_deepOrangeAccentPrimaryValue(), Map.ofEntries(Map.entry(100, Color.color(0xFFFF9E80).build()), Map.entry(200, Color.color(_deepOrangeAccentPrimaryValue()).build()), Map.entry(400, Color.color(0xFFFF3D00).build()), Map.entry(700, Color.color(0xFFDD2C00).build()))).build();
  }
  private static int _deepOrangeAccentPrimaryValue() {
    return 0xFFFF6E40;
  }
  public static MaterialColor brown() {
    return MaterialColor.materialColor(_brownPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFEFEBE9).build()), Map.entry(100, Color.color(0xFFD7CCC8).build()), Map.entry(200, Color.color(0xFFBCAAA4).build()), Map.entry(300, Color.color(0xFFA1887F).build()), Map.entry(400, Color.color(0xFF8D6E63).build()), Map.entry(500, Color.color(_brownPrimaryValue()).build()), Map.entry(600, Color.color(0xFF6D4C41).build()), Map.entry(700, Color.color(0xFF5D4037).build()), Map.entry(800, Color.color(0xFF4E342E).build()), Map.entry(900, Color.color(0xFF3E2723).build()))).build();
  }
  private static int _brownPrimaryValue() {
    return 0xFF795548;
  }
  public static MaterialColor grey() {
    return MaterialColor.materialColor(_greyPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFFAFAFA).build()), Map.entry(100, Color.color(0xFFF5F5F5).build()), Map.entry(200, Color.color(0xFFEEEEEE).build()), Map.entry(300, Color.color(0xFFE0E0E0).build()), Map.entry(350, Color.color(0xFFD6D6D6).build()), Map.entry(400, Color.color(0xFFBDBDBD).build()), Map.entry(500, Color.color(_greyPrimaryValue()).build()), Map.entry(600, Color.color(0xFF757575).build()), Map.entry(700, Color.color(0xFF616161).build()), Map.entry(800, Color.color(0xFF424242).build()), Map.entry(850, Color.color(0xFF303030).build()), Map.entry(900, Color.color(0xFF212121).build()))).build();
  }
  private static int _greyPrimaryValue() {
    return 0xFF9E9E9E;
  }
  public static MaterialColor blueGrey() {
    return MaterialColor.materialColor(_blueGreyPrimaryValue(), Map.ofEntries(Map.entry(50, Color.color(0xFFECEFF1).build()), Map.entry(100, Color.color(0xFFCFD8DC).build()), Map.entry(200, Color.color(0xFFB0BEC5).build()), Map.entry(300, Color.color(0xFF90A4AE).build()), Map.entry(400, Color.color(0xFF78909C).build()), Map.entry(500, Color.color(_blueGreyPrimaryValue()).build()), Map.entry(600, Color.color(0xFF546E7A).build()), Map.entry(700, Color.color(0xFF455A64).build()), Map.entry(800, Color.color(0xFF37474F).build()), Map.entry(900, Color.color(0xFF263238).build()))).build();
  }
  private static int _blueGreyPrimaryValue() {
    return 0xFF607D8B;
  }
  public static List<MaterialColor> primaries() {
    return List.of(red(), pink(), purple(), deepPurple(), indigo(), blue(), lightBlue(), cyan(), teal(), green(), lightGreen(), lime(), yellow(), amber(), orange(), deepOrange(), brown(), blueGrey());
  }
  public static List<MaterialAccentColor> accents() {
    return List.of(redAccent(), pinkAccent(), purpleAccent(), deepPurpleAccent(), indigoAccent(), blueAccent(), lightBlueAccent(), cyanAccent(), tealAccent(), greenAccent(), lightGreenAccent(), limeAccent(), yellowAccent(), amberAccent(), orangeAccent(), deepOrangeAccent());
  }
  @Override
  default Colors build() {
    return this;
  }
}
