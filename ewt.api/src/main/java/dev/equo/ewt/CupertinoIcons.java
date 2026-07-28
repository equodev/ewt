package dev.equo.ewt;
import java.util.*;
public abstract class CupertinoIcons extends NativeObj.Base implements CupertinoIconsI {
  protected CupertinoIcons() {}
  CupertinoIcons(int id) {
    this.id = id;
  }
  public static String iconFont() {
    return "CupertinoIcons";
  }
  public static String iconFontPackage() {
    return "cupertino_icons";
  }
  public static IconData left_chevron() {
    return IconData.iconData(0xf3d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).matchTextDirection(true).build();
  }
  public static IconData right_chevron() {
    return IconData.iconData(0xf3d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).matchTextDirection(true).build();
  }
  public static IconData share() {
    return IconData.iconData(0xf4ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData share_solid() {
    return IconData.iconData(0xf4cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData book() {
    return IconData.iconData(0xf3e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData book_solid() {
    return IconData.iconData(0xf3e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bookmark() {
    return IconData.iconData(0xf3e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bookmark_solid() {
    return IconData.iconData(0xf3ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData info() {
    return IconData.iconData(0xf44c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData reply() {
    return IconData.iconData(0xf4c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData conversation_bubble() {
    return IconData.iconData(0xf3fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData profile_circled() {
    return IconData.iconData(0xf419).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_circled() {
    return IconData.iconData(0xf48a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_circled() {
    return IconData.iconData(0xf463).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag() {
    return IconData.iconData(0xf42c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData search() {
    return IconData.iconData(0xf4a5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData check_mark() {
    return IconData.iconData(0xf3fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData check_mark_circled() {
    return IconData.iconData(0xf3fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData check_mark_circled_solid() {
    return IconData.iconData(0xf3ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle() {
    return IconData.iconData(0xf401).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_filled() {
    return IconData.iconData(0xf400).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData back() {
    return IconData.iconData(0xf3cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).matchTextDirection(true).build();
  }
  public static IconData forward() {
    return IconData.iconData(0xf3d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).matchTextDirection(true).build();
  }
  public static IconData home() {
    return IconData.iconData(0xf447).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shopping_cart() {
    return IconData.iconData(0xf3f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis() {
    return IconData.iconData(0xf46a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone() {
    return IconData.iconData(0xf4b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_solid() {
    return IconData.iconData(0xf4b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData down_arrow() {
    return IconData.iconData(0xf35d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData up_arrow() {
    return IconData.iconData(0xf366).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_charging() {
    return IconData.iconData(0xf111).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_empty() {
    return IconData.iconData(0xf112).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_full() {
    return IconData.iconData(0xf113).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_75_percent() {
    return IconData.iconData(0xf114).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_25_percent() {
    return IconData.iconData(0xf115).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bluetooth() {
    return IconData.iconData(0xf116).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData restart() {
    return IconData.iconData(0xf21c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData reply_all() {
    return IconData.iconData(0xf21d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData reply_thick_solid() {
    return IconData.iconData(0xf21e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData share_up() {
    return IconData.iconData(0xf220).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shuffle() {
    return IconData.iconData(0xf4a9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shuffle_medium() {
    return IconData.iconData(0xf4a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shuffle_thick() {
    return IconData.iconData(0xf221).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo_camera() {
    return IconData.iconData(0xf3f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo_camera_solid() {
    return IconData.iconData(0xf3f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData video_camera() {
    return IconData.iconData(0xf4cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData video_camera_solid() {
    return IconData.iconData(0xf4cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData switch_camera() {
    return IconData.iconData(0xf49e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData switch_camera_solid() {
    return IconData.iconData(0xf49f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData collections() {
    return IconData.iconData(0xf3c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData collections_solid() {
    return IconData.iconData(0xf3ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder() {
    return IconData.iconData(0xf434).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_solid() {
    return IconData.iconData(0xf435).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_open() {
    return IconData.iconData(0xf38a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete() {
    return IconData.iconData(0xf4c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_solid() {
    return IconData.iconData(0xf4c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_simple() {
    return IconData.iconData(0xf37f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pen() {
    return IconData.iconData(0xf2bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil() {
    return IconData.iconData(0xf37e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData create() {
    return IconData.iconData(0xf417).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData create_solid() {
    return IconData.iconData(0xf417).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh() {
    return IconData.iconData(0xf49a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh_circled() {
    return IconData.iconData(0xf49b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh_circled_solid() {
    return IconData.iconData(0xf49c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh_thin() {
    return IconData.iconData(0xf49d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh_thick() {
    return IconData.iconData(0xf3a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData refresh_bold() {
    return IconData.iconData(0xf21c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear_thick() {
    return IconData.iconData(0xf2d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear_thick_circled() {
    return IconData.iconData(0xf36e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear() {
    return IconData.iconData(0xf404).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear_circled() {
    return IconData.iconData(0xf405).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear_circled_solid() {
    return IconData.iconData(0xf406).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData add() {
    return IconData.iconData(0xf489).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData add_circled() {
    return IconData.iconData(0xf48a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData add_circled_solid() {
    return IconData.iconData(0xf48b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gear() {
    return IconData.iconData(0xf43c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gear_solid() {
    return IconData.iconData(0xf43d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gear_big() {
    return IconData.iconData(0xf2f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData settings() {
    return IconData.iconData(0xf411).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData settings_solid() {
    return IconData.iconData(0xf412).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_note() {
    return IconData.iconData(0xf46b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData double_music_note() {
    return IconData.iconData(0xf46c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_arrow() {
    return IconData.iconData(0xf487).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_arrow_solid() {
    return IconData.iconData(0xf488).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause() {
    return IconData.iconData(0xf477).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_solid() {
    return IconData.iconData(0xf478).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData loop() {
    return IconData.iconData(0xf449).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData loop_thick() {
    return IconData.iconData(0xf44a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData volume_down() {
    return IconData.iconData(0xf3b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData volume_mute() {
    return IconData.iconData(0xf3b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData volume_off() {
    return IconData.iconData(0xf3b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData volume_up() {
    return IconData.iconData(0xf3ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData fullscreen() {
    return IconData.iconData(0xf386).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData fullscreen_exit() {
    return IconData.iconData(0xf37d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_off() {
    return IconData.iconData(0xf45f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic() {
    return IconData.iconData(0xf460).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_solid() {
    return IconData.iconData(0xf461).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clock() {
    return IconData.iconData(0xf4be).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clock_solid() {
    return IconData.iconData(0xf4bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData time() {
    return IconData.iconData(0xf402).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData time_solid() {
    return IconData.iconData(0xf403).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData padlock() {
    return IconData.iconData(0xf4c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData padlock_solid() {
    return IconData.iconData(0xf4c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eye() {
    return IconData.iconData(0xf424).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eye_solid() {
    return IconData.iconData(0xf425).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person() {
    return IconData.iconData(0xf47d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_solid() {
    return IconData.iconData(0xf47e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_add() {
    return IconData.iconData(0xf47f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_add_solid() {
    return IconData.iconData(0xf480).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData group() {
    return IconData.iconData(0xf47b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData group_solid() {
    return IconData.iconData(0xf47c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mail() {
    return IconData.iconData(0xf422).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mail_solid() {
    return IconData.iconData(0xf423).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location() {
    return IconData.iconData(0xf6ee).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_solid() {
    return IconData.iconData(0xf456).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tag() {
    return IconData.iconData(0xf48c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tag_solid() {
    return IconData.iconData(0xf48d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tags() {
    return IconData.iconData(0xf48e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tags_solid() {
    return IconData.iconData(0xf48f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bus() {
    return IconData.iconData(0xf36d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData car() {
    return IconData.iconData(0xf36f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData car_detailed() {
    return IconData.iconData(0xf2c1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData train_style_one() {
    return IconData.iconData(0xf3af).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData train_style_two() {
    return IconData.iconData(0xf3b4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paw() {
    return IconData.iconData(0xf479).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paw_solid() {
    return IconData.iconData(0xf47a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData game_controller() {
    return IconData.iconData(0xf43a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData game_controller_solid() {
    return IconData.iconData(0xf43b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lab_flask() {
    return IconData.iconData(0xf430).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lab_flask_solid() {
    return IconData.iconData(0xf431).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart() {
    return IconData.iconData(0xf442).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_solid() {
    return IconData.iconData(0xf443).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell() {
    return IconData.iconData(0xf3e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_solid() {
    return IconData.iconData(0xf3e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData news() {
    return IconData.iconData(0xf471).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData news_solid() {
    return IconData.iconData(0xf472).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData brightness() {
    return IconData.iconData(0xf4B6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData brightness_solid() {
    return IconData.iconData(0xf4B7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData airplane() {
    return IconData.iconData(0xf4d4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData alarm() {
    return IconData.iconData(0xf4d5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData alarm_fill() {
    return IconData.iconData(0xf4d6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData alt() {
    return IconData.iconData(0xf4d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ant() {
    return IconData.iconData(0xf4d8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ant_circle() {
    return IconData.iconData(0xf4d9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ant_circle_fill() {
    return IconData.iconData(0xf4da).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ant_fill() {
    return IconData.iconData(0xf4db).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData antenna_radiowaves_left_right() {
    return IconData.iconData(0xf4dc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData app() {
    return IconData.iconData(0xf4dd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData app_badge() {
    return IconData.iconData(0xf4de).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData app_badge_fill() {
    return IconData.iconData(0xf4df).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData app_fill() {
    return IconData.iconData(0xf4e0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData archivebox() {
    return IconData.iconData(0xf4e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData archivebox_fill() {
    return IconData.iconData(0xf4e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_2_circlepath() {
    return IconData.iconData(0xf4e3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_2_circlepath_circle() {
    return IconData.iconData(0xf4e4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_2_circlepath_circle_fill() {
    return IconData.iconData(0xf4e5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_2_squarepath() {
    return IconData.iconData(0xf4e6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_3_trianglepath() {
    return IconData.iconData(0xf4e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_branch() {
    return IconData.iconData(0xf4e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_clockwise() {
    return IconData.iconData(0xf49a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_clockwise_circle() {
    return IconData.iconData(0xf49b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_clockwise_circle_fill() {
    return IconData.iconData(0xf49c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_counterclockwise() {
    return IconData.iconData(0xf21c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_counterclockwise_circle() {
    return IconData.iconData(0xf4e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_counterclockwise_circle_fill() {
    return IconData.iconData(0xf4ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down() {
    return IconData.iconData(0xf35d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_circle() {
    return IconData.iconData(0xf4eb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_circle_fill() {
    return IconData.iconData(0xf4ec).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_doc() {
    return IconData.iconData(0xf4ed).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_doc_fill() {
    return IconData.iconData(0xf4ee).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_left() {
    return IconData.iconData(0xf4ef).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_left_circle() {
    return IconData.iconData(0xf4f0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_left_circle_fill() {
    return IconData.iconData(0xf4f1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_left_square() {
    return IconData.iconData(0xf4f2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_left_square_fill() {
    return IconData.iconData(0xf4f3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right() {
    return IconData.iconData(0xf4f4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right_arrow_up_left() {
    return IconData.iconData(0xf37d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right_circle() {
    return IconData.iconData(0xf4f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right_circle_fill() {
    return IconData.iconData(0xf4f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right_square() {
    return IconData.iconData(0xf4f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_right_square_fill() {
    return IconData.iconData(0xf4f8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_square() {
    return IconData.iconData(0xf4f9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_square_fill() {
    return IconData.iconData(0xf4fa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_to_line() {
    return IconData.iconData(0xf4fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_down_to_line_alt() {
    return IconData.iconData(0xf4fc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left() {
    return IconData.iconData(0xf4fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_circle() {
    return IconData.iconData(0xf4fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_circle_fill() {
    return IconData.iconData(0xf4ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_right() {
    return IconData.iconData(0xf500).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_right_circle() {
    return IconData.iconData(0xf501).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_right_circle_fill() {
    return IconData.iconData(0xf502).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_right_square() {
    return IconData.iconData(0xf503).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_right_square_fill() {
    return IconData.iconData(0xf504).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_square() {
    return IconData.iconData(0xf505).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_square_fill() {
    return IconData.iconData(0xf506).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_to_line() {
    return IconData.iconData(0xf507).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_left_to_line_alt() {
    return IconData.iconData(0xf508).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_merge() {
    return IconData.iconData(0xf509).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right() {
    return IconData.iconData(0xf50a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_arrow_left() {
    return IconData.iconData(0xf50b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_arrow_left_circle() {
    return IconData.iconData(0xf50c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_arrow_left_circle_fill() {
    return IconData.iconData(0xf50d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_arrow_left_square() {
    return IconData.iconData(0xf50e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_arrow_left_square_fill() {
    return IconData.iconData(0xf50f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_circle() {
    return IconData.iconData(0xf510).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_circle_fill() {
    return IconData.iconData(0xf511).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_square() {
    return IconData.iconData(0xf512).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_square_fill() {
    return IconData.iconData(0xf513).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_to_line() {
    return IconData.iconData(0xf514).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_right_to_line_alt() {
    return IconData.iconData(0xf515).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_swap() {
    return IconData.iconData(0xf516).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_down_left() {
    return IconData.iconData(0xf517).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_down_right() {
    return IconData.iconData(0xf518).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_left_down() {
    return IconData.iconData(0xf519).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_left_up() {
    return IconData.iconData(0xf51a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_right_down() {
    return IconData.iconData(0xf51b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_right_up() {
    return IconData.iconData(0xf51c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_up_left() {
    return IconData.iconData(0xf51d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_turn_up_right() {
    return IconData.iconData(0xf51e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up() {
    return IconData.iconData(0xf366).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_arrow_down() {
    return IconData.iconData(0xf51f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_arrow_down_circle() {
    return IconData.iconData(0xf520).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_arrow_down_circle_fill() {
    return IconData.iconData(0xf521).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_arrow_down_square() {
    return IconData.iconData(0xf522).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_arrow_down_square_fill() {
    return IconData.iconData(0xf523).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_bin() {
    return IconData.iconData(0xf524).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_bin_fill() {
    return IconData.iconData(0xf525).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_circle() {
    return IconData.iconData(0xf526).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_circle_fill() {
    return IconData.iconData(0xf527).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_doc() {
    return IconData.iconData(0xf528).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_doc_fill() {
    return IconData.iconData(0xf529).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_down() {
    return IconData.iconData(0xf52a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_down_circle() {
    return IconData.iconData(0xf52b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_down_circle_fill() {
    return IconData.iconData(0xf52c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_down_square() {
    return IconData.iconData(0xf52d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_down_square_fill() {
    return IconData.iconData(0xf52e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left() {
    return IconData.iconData(0xf52f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left_arrow_down_right() {
    return IconData.iconData(0xf386).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left_circle() {
    return IconData.iconData(0xf530).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left_circle_fill() {
    return IconData.iconData(0xf531).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left_square() {
    return IconData.iconData(0xf532).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_left_square_fill() {
    return IconData.iconData(0xf533).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right() {
    return IconData.iconData(0xf534).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_circle() {
    return IconData.iconData(0xf535).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_circle_fill() {
    return IconData.iconData(0xf536).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_diamond() {
    return IconData.iconData(0xf537).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_diamond_fill() {
    return IconData.iconData(0xf538).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_square() {
    return IconData.iconData(0xf539).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_right_square_fill() {
    return IconData.iconData(0xf53a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_square() {
    return IconData.iconData(0xf53b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_square_fill() {
    return IconData.iconData(0xf53c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_to_line() {
    return IconData.iconData(0xf53d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_up_to_line_alt() {
    return IconData.iconData(0xf53e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_down() {
    return IconData.iconData(0xf53f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_down_circle() {
    return IconData.iconData(0xf540).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_down_circle_fill() {
    return IconData.iconData(0xf541).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_down_square() {
    return IconData.iconData(0xf542).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_down_square_fill() {
    return IconData.iconData(0xf543).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_left() {
    return IconData.iconData(0xf544).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_left_circle() {
    return IconData.iconData(0xf545).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_left_circle_fill() {
    return IconData.iconData(0xf546).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_left_square() {
    return IconData.iconData(0xf547).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_left_square_fill() {
    return IconData.iconData(0xf548).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_right() {
    return IconData.iconData(0xf549).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_right_circle() {
    return IconData.iconData(0xf54a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_right_circle_fill() {
    return IconData.iconData(0xf54b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_right_square() {
    return IconData.iconData(0xf54c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_right_square_fill() {
    return IconData.iconData(0xf54d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_up() {
    return IconData.iconData(0xf54e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_up_circle() {
    return IconData.iconData(0xf54f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_up_circle_fill() {
    return IconData.iconData(0xf550).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_up_square() {
    return IconData.iconData(0xf551).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrow_uturn_up_square_fill() {
    return IconData.iconData(0xf552).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left() {
    return IconData.iconData(0xf4c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left_2() {
    return IconData.iconData(0xf21d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left_2_fill() {
    return IconData.iconData(0xf21e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left_circle() {
    return IconData.iconData(0xf553).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left_circle_fill() {
    return IconData.iconData(0xf554).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_left_fill() {
    return IconData.iconData(0xf555).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_right() {
    return IconData.iconData(0xf556).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_right_circle() {
    return IconData.iconData(0xf557).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_right_circle_fill() {
    return IconData.iconData(0xf558).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowshape_turn_up_right_fill() {
    return IconData.iconData(0xf559).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down() {
    return IconData.iconData(0xf55a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down_circle() {
    return IconData.iconData(0xf55b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down_circle_fill() {
    return IconData.iconData(0xf55c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down_fill() {
    return IconData.iconData(0xf55d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down_square() {
    return IconData.iconData(0xf55e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_down_square_fill() {
    return IconData.iconData(0xf55f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left() {
    return IconData.iconData(0xf560).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left_circle() {
    return IconData.iconData(0xf561).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left_circle_fill() {
    return IconData.iconData(0xf562).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left_fill() {
    return IconData.iconData(0xf563).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left_square() {
    return IconData.iconData(0xf564).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_left_square_fill() {
    return IconData.iconData(0xf565).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right() {
    return IconData.iconData(0xf566).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right_circle() {
    return IconData.iconData(0xf567).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right_circle_fill() {
    return IconData.iconData(0xf568).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right_fill() {
    return IconData.iconData(0xf569).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right_square() {
    return IconData.iconData(0xf56a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_right_square_fill() {
    return IconData.iconData(0xf56b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up() {
    return IconData.iconData(0xf56c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up_circle() {
    return IconData.iconData(0xf56d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up_circle_fill() {
    return IconData.iconData(0xf56e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up_fill() {
    return IconData.iconData(0xf56f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up_square() {
    return IconData.iconData(0xf570).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData arrowtriangle_up_square_fill() {
    return IconData.iconData(0xf571).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData asterisk_circle() {
    return IconData.iconData(0xf572).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData asterisk_circle_fill() {
    return IconData.iconData(0xf573).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData at() {
    return IconData.iconData(0xf574).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData at_badge_minus() {
    return IconData.iconData(0xf575).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData at_badge_plus() {
    return IconData.iconData(0xf576).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData at_circle() {
    return IconData.iconData(0xf8af).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData at_circle_fill() {
    return IconData.iconData(0xf8b0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward() {
    return IconData.iconData(0xf577).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward_end() {
    return IconData.iconData(0xf578).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward_end_alt() {
    return IconData.iconData(0xf579).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward_end_alt_fill() {
    return IconData.iconData(0xf57a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward_end_fill() {
    return IconData.iconData(0xf57b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData backward_fill() {
    return IconData.iconData(0xf57c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData badge_plus_radiowaves_right() {
    return IconData.iconData(0xf57d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag() {
    return IconData.iconData(0xf57e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag_badge_minus() {
    return IconData.iconData(0xf57f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag_badge_plus() {
    return IconData.iconData(0xf580).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag_fill() {
    return IconData.iconData(0xf581).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag_fill_badge_minus() {
    return IconData.iconData(0xf582).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bag_fill_badge_plus() {
    return IconData.iconData(0xf583).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bandage() {
    return IconData.iconData(0xf584).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bandage_fill() {
    return IconData.iconData(0xf585).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData barcode() {
    return IconData.iconData(0xf586).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData barcode_viewfinder() {
    return IconData.iconData(0xf587).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bars() {
    return IconData.iconData(0xf8b1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_0() {
    return IconData.iconData(0xf112).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_100() {
    return IconData.iconData(0xf113).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData battery_25() {
    return IconData.iconData(0xf115).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bed_double() {
    return IconData.iconData(0xf588).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bed_double_fill() {
    return IconData.iconData(0xf589).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_circle() {
    return IconData.iconData(0xf58a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_circle_fill() {
    return IconData.iconData(0xf58b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_fill() {
    return IconData.iconData(0xf3e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_slash() {
    return IconData.iconData(0xf58c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bell_slash_fill() {
    return IconData.iconData(0xf58d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bin_xmark() {
    return IconData.iconData(0xf58e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bin_xmark_fill() {
    return IconData.iconData(0xf58f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bitcoin() {
    return IconData.iconData(0xf8b2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bitcoin_circle() {
    return IconData.iconData(0xf8b3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bitcoin_circle_fill() {
    return IconData.iconData(0xf8b4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bold() {
    return IconData.iconData(0xf590).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bold_italic_underline() {
    return IconData.iconData(0xf591).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bold_underline() {
    return IconData.iconData(0xf592).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt() {
    return IconData.iconData(0xf593).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_badge_a() {
    return IconData.iconData(0xf594).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_badge_a_fill() {
    return IconData.iconData(0xf595).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_circle() {
    return IconData.iconData(0xf596).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_circle_fill() {
    return IconData.iconData(0xf597).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_fill() {
    return IconData.iconData(0xf598).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_horizontal() {
    return IconData.iconData(0xf599).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_horizontal_circle() {
    return IconData.iconData(0xf59a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_horizontal_circle_fill() {
    return IconData.iconData(0xf59b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_horizontal_fill() {
    return IconData.iconData(0xf59c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_slash() {
    return IconData.iconData(0xf59d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bolt_slash_fill() {
    return IconData.iconData(0xf59e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData book_circle() {
    return IconData.iconData(0xf59f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData book_circle_fill() {
    return IconData.iconData(0xf5a0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData book_fill() {
    return IconData.iconData(0xf3e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bookmark_fill() {
    return IconData.iconData(0xf3ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData briefcase() {
    return IconData.iconData(0xf5a1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData briefcase_fill() {
    return IconData.iconData(0xf5a2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_left() {
    return IconData.iconData(0xf5a3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_left_bubble_right() {
    return IconData.iconData(0xf5a4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_left_bubble_right_fill() {
    return IconData.iconData(0xf5a5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_left_fill() {
    return IconData.iconData(0xf5a6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_middle_bottom() {
    return IconData.iconData(0xf5a7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_middle_bottom_fill() {
    return IconData.iconData(0xf5a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_middle_top() {
    return IconData.iconData(0xf5a9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_middle_top_fill() {
    return IconData.iconData(0xf5aa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_right() {
    return IconData.iconData(0xf5ab).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData bubble_right_fill() {
    return IconData.iconData(0xf5ac).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData building_2_fill() {
    return IconData.iconData(0xf8b5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData burn() {
    return IconData.iconData(0xf5ad).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData burst() {
    return IconData.iconData(0xf5ae).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData burst_fill() {
    return IconData.iconData(0xf5af).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar() {
    return IconData.iconData(0xf5b0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar_badge_minus() {
    return IconData.iconData(0xf5b1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar_badge_plus() {
    return IconData.iconData(0xf5b2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar_circle() {
    return IconData.iconData(0xf5b3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar_circle_fill() {
    return IconData.iconData(0xf5b4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData calendar_today() {
    return IconData.iconData(0xf8b6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera() {
    return IconData.iconData(0xf3f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_circle() {
    return IconData.iconData(0xf5b5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_circle_fill() {
    return IconData.iconData(0xf5b6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_fill() {
    return IconData.iconData(0xf3f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_on_rectangle() {
    return IconData.iconData(0xf5b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_on_rectangle_fill() {
    return IconData.iconData(0xf5b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_rotate() {
    return IconData.iconData(0xf49e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_rotate_fill() {
    return IconData.iconData(0xf49f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData camera_viewfinder() {
    return IconData.iconData(0xf5b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData capslock() {
    return IconData.iconData(0xf5ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData capslock_fill() {
    return IconData.iconData(0xf5bb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData capsule() {
    return IconData.iconData(0xf5bc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData capsule_fill() {
    return IconData.iconData(0xf5bd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData captions_bubble() {
    return IconData.iconData(0xf5be).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData captions_bubble_fill() {
    return IconData.iconData(0xf5bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData car_fill() {
    return IconData.iconData(0xf36f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart() {
    return IconData.iconData(0xf3f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart_badge_minus() {
    return IconData.iconData(0xf5c0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart_badge_plus() {
    return IconData.iconData(0xf5c1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart_fill() {
    return IconData.iconData(0xf5c2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart_fill_badge_minus() {
    return IconData.iconData(0xf5c3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cart_fill_badge_plus() {
    return IconData.iconData(0xf5c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar() {
    return IconData.iconData(0xf5c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_alt_fill() {
    return IconData.iconData(0xf8b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_circle() {
    return IconData.iconData(0xf8b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_circle_fill() {
    return IconData.iconData(0xf8b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_fill() {
    return IconData.iconData(0xf5c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_square() {
    return IconData.iconData(0xf8ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_bar_square_fill() {
    return IconData.iconData(0xf8bb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_pie() {
    return IconData.iconData(0xf5c7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chart_pie_fill() {
    return IconData.iconData(0xf5c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble() {
    return IconData.iconData(0xf3fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble_2() {
    return IconData.iconData(0xf8bc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble_2_fill() {
    return IconData.iconData(0xf8bd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble_fill() {
    return IconData.iconData(0xf8be).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble_text() {
    return IconData.iconData(0xf8bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chat_bubble_text_fill() {
    return IconData.iconData(0xf8c0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark() {
    return IconData.iconData(0xf3fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_alt() {
    return IconData.iconData(0xf8c1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_alt_circle() {
    return IconData.iconData(0xf8c2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_alt_circle_fill() {
    return IconData.iconData(0xf8c3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_circle() {
    return IconData.iconData(0xf3fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_circle_fill() {
    return IconData.iconData(0xf3ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_rectangle() {
    return IconData.iconData(0xf5c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_rectangle_fill() {
    return IconData.iconData(0xf5ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_seal() {
    return IconData.iconData(0xf5cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_seal_fill() {
    return IconData.iconData(0xf5cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_shield() {
    return IconData.iconData(0xf5cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_shield_fill() {
    return IconData.iconData(0xf5ce).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_square() {
    return IconData.iconData(0xf5cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData checkmark_square_fill() {
    return IconData.iconData(0xf5d0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_back() {
    return IconData.iconData(0xf3cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_compact_down() {
    return IconData.iconData(0xf5d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_compact_left() {
    return IconData.iconData(0xf5d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_compact_right() {
    return IconData.iconData(0xf5d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_compact_up() {
    return IconData.iconData(0xf5d4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_down() {
    return IconData.iconData(0xf5d5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_down_circle() {
    return IconData.iconData(0xf5d6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_down_circle_fill() {
    return IconData.iconData(0xf5d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_down_square() {
    return IconData.iconData(0xf5d8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_down_square_fill() {
    return IconData.iconData(0xf5d9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_forward() {
    return IconData.iconData(0xf3d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left() {
    return IconData.iconData(0xf3d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_2() {
    return IconData.iconData(0xf5da).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_circle() {
    return IconData.iconData(0xf5db).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_circle_fill() {
    return IconData.iconData(0xf5dc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_slash_chevron_right() {
    return IconData.iconData(0xf5dd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_square() {
    return IconData.iconData(0xf5de).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_left_square_fill() {
    return IconData.iconData(0xf5df).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right() {
    return IconData.iconData(0xf3d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right_2() {
    return IconData.iconData(0xf5e0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right_circle() {
    return IconData.iconData(0xf5e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right_circle_fill() {
    return IconData.iconData(0xf5e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right_square() {
    return IconData.iconData(0xf5e3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_right_square_fill() {
    return IconData.iconData(0xf5e4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up() {
    return IconData.iconData(0xf5e5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up_chevron_down() {
    return IconData.iconData(0xf5e6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up_circle() {
    return IconData.iconData(0xf5e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up_circle_fill() {
    return IconData.iconData(0xf5e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up_square() {
    return IconData.iconData(0xf5e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData chevron_up_square_fill() {
    return IconData.iconData(0xf5ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_bottomthird_split() {
    return IconData.iconData(0xf5eb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_fill() {
    return IconData.iconData(0xf400).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_grid_3x3() {
    return IconData.iconData(0xf5ec).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_grid_3x3_fill() {
    return IconData.iconData(0xf5ed).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_grid_hex() {
    return IconData.iconData(0xf5ee).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_grid_hex_fill() {
    return IconData.iconData(0xf5ef).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_lefthalf_fill() {
    return IconData.iconData(0xf5f0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData circle_righthalf_fill() {
    return IconData.iconData(0xf5f1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clear_fill() {
    return IconData.iconData(0xf5f3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData clock_fill() {
    return IconData.iconData(0xf403).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud() {
    return IconData.iconData(0xf5f4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_bolt() {
    return IconData.iconData(0xf5f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_bolt_fill() {
    return IconData.iconData(0xf5f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_bolt_rain() {
    return IconData.iconData(0xf5f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_bolt_rain_fill() {
    return IconData.iconData(0xf5f8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_download() {
    return IconData.iconData(0xf8c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_download_fill() {
    return IconData.iconData(0xf8c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_drizzle() {
    return IconData.iconData(0xf5f9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_drizzle_fill() {
    return IconData.iconData(0xf5fa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_fill() {
    return IconData.iconData(0xf5fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_fog() {
    return IconData.iconData(0xf5fc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_fog_fill() {
    return IconData.iconData(0xf5fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_hail() {
    return IconData.iconData(0xf5fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_hail_fill() {
    return IconData.iconData(0xf5ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_heavyrain() {
    return IconData.iconData(0xf600).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_heavyrain_fill() {
    return IconData.iconData(0xf601).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon() {
    return IconData.iconData(0xf602).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon_bolt() {
    return IconData.iconData(0xf603).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon_bolt_fill() {
    return IconData.iconData(0xf604).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon_fill() {
    return IconData.iconData(0xf605).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon_rain() {
    return IconData.iconData(0xf606).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_moon_rain_fill() {
    return IconData.iconData(0xf607).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_rain() {
    return IconData.iconData(0xf608).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_rain_fill() {
    return IconData.iconData(0xf609).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sleet() {
    return IconData.iconData(0xf60a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sleet_fill() {
    return IconData.iconData(0xf60b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_snow() {
    return IconData.iconData(0xf60c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_snow_fill() {
    return IconData.iconData(0xf60d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun() {
    return IconData.iconData(0xf60e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun_bolt() {
    return IconData.iconData(0xf60f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun_bolt_fill() {
    return IconData.iconData(0xf610).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun_fill() {
    return IconData.iconData(0xf611).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun_rain() {
    return IconData.iconData(0xf612).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_sun_rain_fill() {
    return IconData.iconData(0xf613).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_upload() {
    return IconData.iconData(0xf8c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cloud_upload_fill() {
    return IconData.iconData(0xf8c7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData color_filter() {
    return IconData.iconData(0xf8c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData color_filter_fill() {
    return IconData.iconData(0xf8c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData command() {
    return IconData.iconData(0xf614).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData compass() {
    return IconData.iconData(0xf8ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData compass_fill() {
    return IconData.iconData(0xf8cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData control() {
    return IconData.iconData(0xf615).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData creditcard() {
    return IconData.iconData(0xf616).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData creditcard_fill() {
    return IconData.iconData(0xf617).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData crop() {
    return IconData.iconData(0xf618).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData crop_rotate() {
    return IconData.iconData(0xf619).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cube() {
    return IconData.iconData(0xf61a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cube_box() {
    return IconData.iconData(0xf61b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cube_box_fill() {
    return IconData.iconData(0xf61c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cube_fill() {
    return IconData.iconData(0xf61d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData cursor_rays() {
    return IconData.iconData(0xf61e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData decrease_indent() {
    return IconData.iconData(0xf61f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData decrease_quotelevel() {
    return IconData.iconData(0xf620).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_left() {
    return IconData.iconData(0xf621).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_left_fill() {
    return IconData.iconData(0xf622).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_right() {
    return IconData.iconData(0xf623).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData delete_right_fill() {
    return IconData.iconData(0xf624).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData desktopcomputer() {
    return IconData.iconData(0xf625).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData device_desktop() {
    return IconData.iconData(0xf8cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData device_laptop() {
    return IconData.iconData(0xf8cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData device_phone_landscape() {
    return IconData.iconData(0xf8ce).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData device_phone_portrait() {
    return IconData.iconData(0xf8cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dial() {
    return IconData.iconData(0xf626).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dial_fill() {
    return IconData.iconData(0xf627).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData divide() {
    return IconData.iconData(0xf628).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData divide_circle() {
    return IconData.iconData(0xf629).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData divide_circle_fill() {
    return IconData.iconData(0xf62a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData divide_square() {
    return IconData.iconData(0xf62b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData divide_square_fill() {
    return IconData.iconData(0xf62c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc() {
    return IconData.iconData(0xf62d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_append() {
    return IconData.iconData(0xf62e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_chart() {
    return IconData.iconData(0xf8d0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_chart_fill() {
    return IconData.iconData(0xf8d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_checkmark() {
    return IconData.iconData(0xf8d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_checkmark_fill() {
    return IconData.iconData(0xf8d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_circle() {
    return IconData.iconData(0xf62f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_circle_fill() {
    return IconData.iconData(0xf630).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_fill() {
    return IconData.iconData(0xf631).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_on_clipboard() {
    return IconData.iconData(0xf632).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_on_clipboard_fill() {
    return IconData.iconData(0xf633).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_on_doc() {
    return IconData.iconData(0xf634).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_on_doc_fill() {
    return IconData.iconData(0xf635).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_person() {
    return IconData.iconData(0xf8d4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_person_fill() {
    return IconData.iconData(0xf8d5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_plaintext() {
    return IconData.iconData(0xf636).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_richtext() {
    return IconData.iconData(0xf637).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_text() {
    return IconData.iconData(0xf638).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_text_fill() {
    return IconData.iconData(0xf639).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_text_search() {
    return IconData.iconData(0xf63a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData doc_text_viewfinder() {
    return IconData.iconData(0xf63b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dot_radiowaves_left_right() {
    return IconData.iconData(0xf63c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dot_radiowaves_right() {
    return IconData.iconData(0xf63d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dot_square() {
    return IconData.iconData(0xf63e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData dot_square_fill() {
    return IconData.iconData(0xf63f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData download_circle() {
    return IconData.iconData(0xf8d6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData download_circle_fill() {
    return IconData.iconData(0xf8d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData drop() {
    return IconData.iconData(0xf8d8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData drop_fill() {
    return IconData.iconData(0xf8d9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData drop_triangle() {
    return IconData.iconData(0xf640).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData drop_triangle_fill() {
    return IconData.iconData(0xf641).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ear() {
    return IconData.iconData(0xf642).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eject() {
    return IconData.iconData(0xf643).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eject_fill() {
    return IconData.iconData(0xf644).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipses_bubble() {
    return IconData.iconData(0xf645).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipses_bubble_fill() {
    return IconData.iconData(0xf646).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis_circle() {
    return IconData.iconData(0xf647).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis_circle_fill() {
    return IconData.iconData(0xf648).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis_vertical() {
    return IconData.iconData(0xf8da).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis_vertical_circle() {
    return IconData.iconData(0xf8db).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ellipsis_vertical_circle_fill() {
    return IconData.iconData(0xf8dc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope() {
    return IconData.iconData(0xf422).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_badge() {
    return IconData.iconData(0xf649).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_badge_fill() {
    return IconData.iconData(0xf64a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_circle() {
    return IconData.iconData(0xf64b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_circle_fill() {
    return IconData.iconData(0xf64c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_fill() {
    return IconData.iconData(0xf423).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_open() {
    return IconData.iconData(0xf64d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData envelope_open_fill() {
    return IconData.iconData(0xf64e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData equal() {
    return IconData.iconData(0xf64f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData equal_circle() {
    return IconData.iconData(0xf650).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData equal_circle_fill() {
    return IconData.iconData(0xf651).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData equal_square() {
    return IconData.iconData(0xf652).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData equal_square_fill() {
    return IconData.iconData(0xf653).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData escape() {
    return IconData.iconData(0xf654).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark() {
    return IconData.iconData(0xf655).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_bubble() {
    return IconData.iconData(0xf656).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_bubble_fill() {
    return IconData.iconData(0xf657).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_circle() {
    return IconData.iconData(0xf658).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_circle_fill() {
    return IconData.iconData(0xf659).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_octagon() {
    return IconData.iconData(0xf65a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_octagon_fill() {
    return IconData.iconData(0xf65b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_shield() {
    return IconData.iconData(0xf65c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_shield_fill() {
    return IconData.iconData(0xf65d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_square() {
    return IconData.iconData(0xf65e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_square_fill() {
    return IconData.iconData(0xf65f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_triangle() {
    return IconData.iconData(0xf660).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData exclamationmark_triangle_fill() {
    return IconData.iconData(0xf661).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eye_fill() {
    return IconData.iconData(0xf425).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eye_slash() {
    return IconData.iconData(0xf662).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eye_slash_fill() {
    return IconData.iconData(0xf663).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eyedropper() {
    return IconData.iconData(0xf664).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eyedropper_full() {
    return IconData.iconData(0xf665).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eyedropper_halffull() {
    return IconData.iconData(0xf666).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData eyeglasses() {
    return IconData.iconData(0xf667).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData f_cursive() {
    return IconData.iconData(0xf668).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData f_cursive_circle() {
    return IconData.iconData(0xf669).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData f_cursive_circle_fill() {
    return IconData.iconData(0xf66a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData film() {
    return IconData.iconData(0xf66b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData film_fill() {
    return IconData.iconData(0xf66c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag_circle() {
    return IconData.iconData(0xf66d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag_circle_fill() {
    return IconData.iconData(0xf66e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag_fill() {
    return IconData.iconData(0xf66f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag_slash() {
    return IconData.iconData(0xf670).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flag_slash_fill() {
    return IconData.iconData(0xf671).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flame() {
    return IconData.iconData(0xf672).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flame_fill() {
    return IconData.iconData(0xf673).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData floppy_disk() {
    return IconData.iconData(0xf8dd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flowchart() {
    return IconData.iconData(0xf674).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData flowchart_fill() {
    return IconData.iconData(0xf675).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_badge_minus() {
    return IconData.iconData(0xf676).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_badge_person_crop() {
    return IconData.iconData(0xf677).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_badge_plus() {
    return IconData.iconData(0xf678).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_circle() {
    return IconData.iconData(0xf679).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_circle_fill() {
    return IconData.iconData(0xf67a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_fill() {
    return IconData.iconData(0xf435).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_fill_badge_minus() {
    return IconData.iconData(0xf67b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_fill_badge_person_crop() {
    return IconData.iconData(0xf67c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData folder_fill_badge_plus() {
    return IconData.iconData(0xf67d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData forward_end() {
    return IconData.iconData(0xf67f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData forward_end_alt() {
    return IconData.iconData(0xf680).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData forward_end_alt_fill() {
    return IconData.iconData(0xf681).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData forward_end_fill() {
    return IconData.iconData(0xf682).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData forward_fill() {
    return IconData.iconData(0xf683).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData function() {
    return IconData.iconData(0xf684).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData fx() {
    return IconData.iconData(0xf685).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gamecontroller() {
    return IconData.iconData(0xf43a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gamecontroller_alt_fill() {
    return IconData.iconData(0xf8de).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gamecontroller_fill() {
    return IconData.iconData(0xf43b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gauge() {
    return IconData.iconData(0xf686).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gauge_badge_minus() {
    return IconData.iconData(0xf687).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gauge_badge_plus() {
    return IconData.iconData(0xf688).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gear_alt() {
    return IconData.iconData(0xf43c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gear_alt_fill() {
    return IconData.iconData(0xf43d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gift() {
    return IconData.iconData(0xf689).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gift_alt() {
    return IconData.iconData(0xf68a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gift_alt_fill() {
    return IconData.iconData(0xf68b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gift_fill() {
    return IconData.iconData(0xf68c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData globe() {
    return IconData.iconData(0xf68d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward() {
    return IconData.iconData(0xf68e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_10() {
    return IconData.iconData(0xf68f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_15() {
    return IconData.iconData(0xf690).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_30() {
    return IconData.iconData(0xf691).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_45() {
    return IconData.iconData(0xf692).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_60() {
    return IconData.iconData(0xf693).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_75() {
    return IconData.iconData(0xf694).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_90() {
    return IconData.iconData(0xf695).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData gobackward_minus() {
    return IconData.iconData(0xf696).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward() {
    return IconData.iconData(0xf697).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_10() {
    return IconData.iconData(0xf698).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_15() {
    return IconData.iconData(0xf699).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_30() {
    return IconData.iconData(0xf69a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_45() {
    return IconData.iconData(0xf69b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_60() {
    return IconData.iconData(0xf69c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_75() {
    return IconData.iconData(0xf69d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_90() {
    return IconData.iconData(0xf69e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData goforward_plus() {
    return IconData.iconData(0xf69f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData graph_circle() {
    return IconData.iconData(0xf8df).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData graph_circle_fill() {
    return IconData.iconData(0xf8e0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData graph_square() {
    return IconData.iconData(0xf8e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData graph_square_fill() {
    return IconData.iconData(0xf8e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData greaterthan() {
    return IconData.iconData(0xf6a0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData greaterthan_circle() {
    return IconData.iconData(0xf6a1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData greaterthan_circle_fill() {
    return IconData.iconData(0xf6a2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData greaterthan_square() {
    return IconData.iconData(0xf6a3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData greaterthan_square_fill() {
    return IconData.iconData(0xf6a4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData grid() {
    return IconData.iconData(0xf6a5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData grid_circle() {
    return IconData.iconData(0xf6a6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData grid_circle_fill() {
    return IconData.iconData(0xf6a7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData guitars() {
    return IconData.iconData(0xf6a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hammer() {
    return IconData.iconData(0xf6a9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hammer_fill() {
    return IconData.iconData(0xf6aa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_draw() {
    return IconData.iconData(0xf6ab).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_draw_fill() {
    return IconData.iconData(0xf6ac).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_point_left() {
    return IconData.iconData(0xf6ad).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_point_left_fill() {
    return IconData.iconData(0xf6ae).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_point_right() {
    return IconData.iconData(0xf6af).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_point_right_fill() {
    return IconData.iconData(0xf6b0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_raised() {
    return IconData.iconData(0xf6b1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_raised_fill() {
    return IconData.iconData(0xf6b2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_raised_slash() {
    return IconData.iconData(0xf6b3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_raised_slash_fill() {
    return IconData.iconData(0xf6b4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_thumbsdown() {
    return IconData.iconData(0xf6b5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_thumbsdown_fill() {
    return IconData.iconData(0xf6b6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_thumbsup() {
    return IconData.iconData(0xf6b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hand_thumbsup_fill() {
    return IconData.iconData(0xf6b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hare() {
    return IconData.iconData(0xf6b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hare_fill() {
    return IconData.iconData(0xf6ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData headphones() {
    return IconData.iconData(0xf6bb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_circle() {
    return IconData.iconData(0xf6bc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_circle_fill() {
    return IconData.iconData(0xf6bd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_fill() {
    return IconData.iconData(0xf443).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_slash() {
    return IconData.iconData(0xf6be).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_slash_circle() {
    return IconData.iconData(0xf6bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_slash_circle_fill() {
    return IconData.iconData(0xf6c0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData heart_slash_fill() {
    return IconData.iconData(0xf6c1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData helm() {
    return IconData.iconData(0xf6c2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hexagon() {
    return IconData.iconData(0xf6c3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hexagon_fill() {
    return IconData.iconData(0xf6c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hifispeaker() {
    return IconData.iconData(0xf6c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hifispeaker_fill() {
    return IconData.iconData(0xf6c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hourglass() {
    return IconData.iconData(0xf6c7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hourglass_bottomhalf_fill() {
    return IconData.iconData(0xf6c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hourglass_tophalf_fill() {
    return IconData.iconData(0xf6c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData house() {
    return IconData.iconData(0xf447).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData house_alt() {
    return IconData.iconData(0xf8e3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData house_alt_fill() {
    return IconData.iconData(0xf8e4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData house_fill() {
    return IconData.iconData(0xf6ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData hurricane() {
    return IconData.iconData(0xf6cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData increase_indent() {
    return IconData.iconData(0xf6cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData increase_quotelevel() {
    return IconData.iconData(0xf6cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData infinite() {
    return IconData.iconData(0xf449).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData info_circle() {
    return IconData.iconData(0xf44c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData info_circle_fill() {
    return IconData.iconData(0xf6cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData italic() {
    return IconData.iconData(0xf6d0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData keyboard() {
    return IconData.iconData(0xf6d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData keyboard_chevron_compact_down() {
    return IconData.iconData(0xf6d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData largecircle_fill_circle() {
    return IconData.iconData(0xf6d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lasso() {
    return IconData.iconData(0xf6d4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData layers() {
    return IconData.iconData(0xf8e5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData layers_alt() {
    return IconData.iconData(0xf8e6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData layers_alt_fill() {
    return IconData.iconData(0xf8e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData layers_fill() {
    return IconData.iconData(0xf8e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData leaf_arrow_circlepath() {
    return IconData.iconData(0xf6d5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lessthan() {
    return IconData.iconData(0xf6d6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lessthan_circle() {
    return IconData.iconData(0xf6d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lessthan_circle_fill() {
    return IconData.iconData(0xf6d8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lessthan_square() {
    return IconData.iconData(0xf6d9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lessthan_square_fill() {
    return IconData.iconData(0xf6da).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData light_max() {
    return IconData.iconData(0xf6db).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData light_min() {
    return IconData.iconData(0xf6dc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lightbulb() {
    return IconData.iconData(0xf6dd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lightbulb_fill() {
    return IconData.iconData(0xf6de).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lightbulb_slash() {
    return IconData.iconData(0xf6df).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lightbulb_slash_fill() {
    return IconData.iconData(0xf6e0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData line_horizontal_3() {
    return IconData.iconData(0xf6e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData line_horizontal_3_decrease() {
    return IconData.iconData(0xf6e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData line_horizontal_3_decrease_circle() {
    return IconData.iconData(0xf6e3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData line_horizontal_3_decrease_circle_fill() {
    return IconData.iconData(0xf6e4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData link() {
    return IconData.iconData(0xf6e5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData link_circle() {
    return IconData.iconData(0xf6e6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData link_circle_fill() {
    return IconData.iconData(0xf6e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_bullet() {
    return IconData.iconData(0xf6e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_bullet_below_rectangle() {
    return IconData.iconData(0xf6e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_bullet_indent() {
    return IconData.iconData(0xf6ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_dash() {
    return IconData.iconData(0xf6eb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_number() {
    return IconData.iconData(0xf6ec).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData list_number_rtl() {
    return IconData.iconData(0xf6ed).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_circle() {
    return IconData.iconData(0xf6ef).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_circle_fill() {
    return IconData.iconData(0xf6f0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_fill() {
    return IconData.iconData(0xf6f1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_north() {
    return IconData.iconData(0xf6f2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_north_fill() {
    return IconData.iconData(0xf6f3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_north_line() {
    return IconData.iconData(0xf6f4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_north_line_fill() {
    return IconData.iconData(0xf6f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_slash() {
    return IconData.iconData(0xf6f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData location_slash_fill() {
    return IconData.iconData(0xf6f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock() {
    return IconData.iconData(0xf4c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_circle() {
    return IconData.iconData(0xf6f8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_circle_fill() {
    return IconData.iconData(0xf6f9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_fill() {
    return IconData.iconData(0xf4c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_open() {
    return IconData.iconData(0xf6fa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_open_fill() {
    return IconData.iconData(0xf6fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_rotation() {
    return IconData.iconData(0xf6fc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_rotation_open() {
    return IconData.iconData(0xf6fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_shield() {
    return IconData.iconData(0xf6fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_shield_fill() {
    return IconData.iconData(0xf6ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_slash() {
    return IconData.iconData(0xf700).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData lock_slash_fill() {
    return IconData.iconData(0xf701).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData macwindow() {
    return IconData.iconData(0xf702).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData map() {
    return IconData.iconData(0xf703).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData map_fill() {
    return IconData.iconData(0xf704).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData map_pin() {
    return IconData.iconData(0xf705).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData map_pin_ellipse() {
    return IconData.iconData(0xf706).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData map_pin_slash() {
    return IconData.iconData(0xf707).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData memories() {
    return IconData.iconData(0xf708).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData memories_badge_minus() {
    return IconData.iconData(0xf709).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData memories_badge_plus() {
    return IconData.iconData(0xf70a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData metronome() {
    return IconData.iconData(0xf70b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_circle() {
    return IconData.iconData(0xf70c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_circle_fill() {
    return IconData.iconData(0xf70d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_fill() {
    return IconData.iconData(0xf461).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_slash() {
    return IconData.iconData(0xf45f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData mic_slash_fill() {
    return IconData.iconData(0xf70e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus() {
    return IconData.iconData(0xf70f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_circle() {
    return IconData.iconData(0xf463).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_circle_fill() {
    return IconData.iconData(0xf710).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_rectangle() {
    return IconData.iconData(0xf711).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_rectangle_fill() {
    return IconData.iconData(0xf712).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_slash_plus() {
    return IconData.iconData(0xf713).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_square() {
    return IconData.iconData(0xf714).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData minus_square_fill() {
    return IconData.iconData(0xf715).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_dollar() {
    return IconData.iconData(0xf8e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_dollar_circle() {
    return IconData.iconData(0xf8ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_dollar_circle_fill() {
    return IconData.iconData(0xf8eb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_euro() {
    return IconData.iconData(0xf8ec).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_euro_circle() {
    return IconData.iconData(0xf8ed).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_euro_circle_fill() {
    return IconData.iconData(0xf8ee).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_pound() {
    return IconData.iconData(0xf8ef).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_pound_circle() {
    return IconData.iconData(0xf8f0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_pound_circle_fill() {
    return IconData.iconData(0xf8f1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_rubl() {
    return IconData.iconData(0xf8f2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_rubl_circle() {
    return IconData.iconData(0xf8f3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_rubl_circle_fill() {
    return IconData.iconData(0xf8f4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_yen() {
    return IconData.iconData(0xf8f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_yen_circle() {
    return IconData.iconData(0xf8f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData money_yen_circle_fill() {
    return IconData.iconData(0xf8f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon() {
    return IconData.iconData(0xf716).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_circle() {
    return IconData.iconData(0xf717).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_circle_fill() {
    return IconData.iconData(0xf718).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_fill() {
    return IconData.iconData(0xf719).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_stars() {
    return IconData.iconData(0xf71a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_stars_fill() {
    return IconData.iconData(0xf71b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_zzz() {
    return IconData.iconData(0xf71c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData moon_zzz_fill() {
    return IconData.iconData(0xf71d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData move() {
    return IconData.iconData(0xf8f8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData multiply() {
    return IconData.iconData(0xf71e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData multiply_circle() {
    return IconData.iconData(0xf71f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData multiply_circle_fill() {
    return IconData.iconData(0xf720).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData multiply_square() {
    return IconData.iconData(0xf721).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData multiply_square_fill() {
    return IconData.iconData(0xf722).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_albums() {
    return IconData.iconData(0xf8f9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_albums_fill() {
    return IconData.iconData(0xf8fa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_house() {
    return IconData.iconData(0xf723).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_house_fill() {
    return IconData.iconData(0xf724).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_mic() {
    return IconData.iconData(0xf725).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_note_2() {
    return IconData.iconData(0xf46c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData music_note_list() {
    return IconData.iconData(0xf726).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData nosign() {
    return IconData.iconData(0xf727).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData number() {
    return IconData.iconData(0xf728).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData number_circle() {
    return IconData.iconData(0xf729).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData number_circle_fill() {
    return IconData.iconData(0xf72a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData number_square() {
    return IconData.iconData(0xf72b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData number_square_fill() {
    return IconData.iconData(0xf72c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData option() {
    return IconData.iconData(0xf72d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paintbrush() {
    return IconData.iconData(0xf72e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paintbrush_fill() {
    return IconData.iconData(0xf72f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pano() {
    return IconData.iconData(0xf730).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pano_fill() {
    return IconData.iconData(0xf731).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paperclip() {
    return IconData.iconData(0xf732).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paperplane() {
    return IconData.iconData(0xf733).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paperplane_fill() {
    return IconData.iconData(0xf734).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData paragraph() {
    return IconData.iconData(0xf735).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_circle() {
    return IconData.iconData(0xf736).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_circle_fill() {
    return IconData.iconData(0xf737).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_fill() {
    return IconData.iconData(0xf478).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_rectangle() {
    return IconData.iconData(0xf738).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pause_rectangle_fill() {
    return IconData.iconData(0xf739).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil_circle() {
    return IconData.iconData(0xf73a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil_circle_fill() {
    return IconData.iconData(0xf73b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil_ellipsis_rectangle() {
    return IconData.iconData(0xf73c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil_outline() {
    return IconData.iconData(0xf73d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pencil_slash() {
    return IconData.iconData(0xf73e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData percent() {
    return IconData.iconData(0xf73f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_2() {
    return IconData.iconData(0xf740).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_2_alt() {
    return IconData.iconData(0xf8fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_2_fill() {
    return IconData.iconData(0xf741).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_2_square_stack() {
    return IconData.iconData(0xf742).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_2_square_stack_fill() {
    return IconData.iconData(0xf743).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_3() {
    return IconData.iconData(0xf47b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_3_fill() {
    return IconData.iconData(0xf47c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_alt() {
    return IconData.iconData(0xf8fc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_alt_circle() {
    return IconData.iconData(0xf8fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_alt_circle_fill() {
    return IconData.iconData(0xf8fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_badge_minus() {
    return IconData.iconData(0xf744).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_badge_minus_fill() {
    return IconData.iconData(0xf745).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_badge_plus() {
    return IconData.iconData(0xf47f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_badge_plus_fill() {
    return IconData.iconData(0xf480).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_circle() {
    return IconData.iconData(0xf746).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_circle_fill() {
    return IconData.iconData(0xf747).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle() {
    return IconData.iconData(0xf419).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_badge_checkmark() {
    return IconData.iconData(0xf748).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_badge_exclam() {
    return IconData.iconData(0xf749).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_badge_minus() {
    return IconData.iconData(0xf74a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_badge_plus() {
    return IconData.iconData(0xf74b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_badge_xmark() {
    return IconData.iconData(0xf74c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill() {
    return IconData.iconData(0xf74d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill_badge_checkmark() {
    return IconData.iconData(0xf74e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill_badge_exclam() {
    return IconData.iconData(0xf74f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill_badge_minus() {
    return IconData.iconData(0xf750).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill_badge_plus() {
    return IconData.iconData(0xf751).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_circle_fill_badge_xmark() {
    return IconData.iconData(0xf752).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_rectangle() {
    return IconData.iconData(0xf753).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_rectangle_fill() {
    return IconData.iconData(0xf754).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_square() {
    return IconData.iconData(0xf755).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_crop_square_fill() {
    return IconData.iconData(0xf756).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData person_fill() {
    return IconData.iconData(0xf47e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData personalhotspot() {
    return IconData.iconData(0xf757).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData perspective() {
    return IconData.iconData(0xf758).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_arrow_down_left() {
    return IconData.iconData(0xf759).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_arrow_right() {
    return IconData.iconData(0xf75a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_arrow_up_right() {
    return IconData.iconData(0xf75b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_badge_plus() {
    return IconData.iconData(0xf75c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_circle() {
    return IconData.iconData(0xf75d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_circle_fill() {
    return IconData.iconData(0xf75e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_down() {
    return IconData.iconData(0xf75f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_down_circle() {
    return IconData.iconData(0xf760).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_down_circle_fill() {
    return IconData.iconData(0xf761).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_down_fill() {
    return IconData.iconData(0xf762).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_fill() {
    return IconData.iconData(0xf4b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_fill_arrow_down_left() {
    return IconData.iconData(0xf763).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_fill_arrow_right() {
    return IconData.iconData(0xf764).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_fill_arrow_up_right() {
    return IconData.iconData(0xf765).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData phone_fill_badge_plus() {
    return IconData.iconData(0xf766).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo() {
    return IconData.iconData(0xf767).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo_fill() {
    return IconData.iconData(0xf768).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo_fill_on_rectangle_fill() {
    return IconData.iconData(0xf769).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData photo_on_rectangle() {
    return IconData.iconData(0xf76a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData piano() {
    return IconData.iconData(0xf8ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pin() {
    return IconData.iconData(0xf76b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pin_fill() {
    return IconData.iconData(0xf76c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pin_slash() {
    return IconData.iconData(0xf76d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData pin_slash_fill() {
    return IconData.iconData(0xf76e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData placemark() {
    return IconData.iconData(0xf455).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData placemark_fill() {
    return IconData.iconData(0xf456).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play() {
    return IconData.iconData(0xf487).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_circle() {
    return IconData.iconData(0xf76f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_circle_fill() {
    return IconData.iconData(0xf770).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_fill() {
    return IconData.iconData(0xf488).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_rectangle() {
    return IconData.iconData(0xf771).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData play_rectangle_fill() {
    return IconData.iconData(0xf772).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData playpause() {
    return IconData.iconData(0xf773).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData playpause_fill() {
    return IconData.iconData(0xf774).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus() {
    return IconData.iconData(0xf489).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_app() {
    return IconData.iconData(0xf775).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_app_fill() {
    return IconData.iconData(0xf776).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_bubble() {
    return IconData.iconData(0xf777).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_bubble_fill() {
    return IconData.iconData(0xf778).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_circle() {
    return IconData.iconData(0xf48a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_circle_fill() {
    return IconData.iconData(0xf48b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_rectangle() {
    return IconData.iconData(0xf779).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_rectangle_fill() {
    return IconData.iconData(0xf77a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_rectangle_fill_on_rectangle_fill() {
    return IconData.iconData(0xf77b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_rectangle_on_rectangle() {
    return IconData.iconData(0xf77c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_slash_minus() {
    return IconData.iconData(0xf77d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_square() {
    return IconData.iconData(0xf77e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_square_fill() {
    return IconData.iconData(0xf77f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_square_fill_on_square_fill() {
    return IconData.iconData(0xf780).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plus_square_on_square() {
    return IconData.iconData(0xf781).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plusminus() {
    return IconData.iconData(0xf782).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plusminus_circle() {
    return IconData.iconData(0xf783).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData plusminus_circle_fill() {
    return IconData.iconData(0xf784).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData power() {
    return IconData.iconData(0xf785).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData printer() {
    return IconData.iconData(0xf786).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData printer_fill() {
    return IconData.iconData(0xf787).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData projective() {
    return IconData.iconData(0xf788).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData purchased() {
    return IconData.iconData(0xf789).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData purchased_circle() {
    return IconData.iconData(0xf78a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData purchased_circle_fill() {
    return IconData.iconData(0xf78b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData qrcode() {
    return IconData.iconData(0xf78c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData qrcode_viewfinder() {
    return IconData.iconData(0xf78d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question() {
    return IconData.iconData(0xf78e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_circle() {
    return IconData.iconData(0xf78f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_circle_fill() {
    return IconData.iconData(0xf790).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_diamond() {
    return IconData.iconData(0xf791).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_diamond_fill() {
    return IconData.iconData(0xf792).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_square() {
    return IconData.iconData(0xf793).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData question_square_fill() {
    return IconData.iconData(0xf794).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData quote_bubble() {
    return IconData.iconData(0xf795).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData quote_bubble_fill() {
    return IconData.iconData(0xf796).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData radiowaves_left() {
    return IconData.iconData(0xf797).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData radiowaves_right() {
    return IconData.iconData(0xf798).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rays() {
    return IconData.iconData(0xf799).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData recordingtape() {
    return IconData.iconData(0xf79a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle() {
    return IconData.iconData(0xf79b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_3_offgrid() {
    return IconData.iconData(0xf79c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_3_offgrid_fill() {
    return IconData.iconData(0xf79d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_arrow_up_right_arrow_down_left() {
    return IconData.iconData(0xf79e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_arrow_up_right_arrow_down_left_slash() {
    return IconData.iconData(0xf79f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_badge_checkmark() {
    return IconData.iconData(0xf7a0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_badge_xmark() {
    return IconData.iconData(0xf7a1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_compress_vertical() {
    return IconData.iconData(0xf7a2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_dock() {
    return IconData.iconData(0xf7a3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_expand_vertical() {
    return IconData.iconData(0xf7a4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_fill() {
    return IconData.iconData(0xf7a5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_fill_badge_checkmark() {
    return IconData.iconData(0xf7a6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_fill_badge_xmark() {
    return IconData.iconData(0xf7a7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_fill_on_rectangle_angled_fill() {
    return IconData.iconData(0xf7a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_fill_on_rectangle_fill() {
    return IconData.iconData(0xf7a9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_1x2() {
    return IconData.iconData(0xf7aa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_1x2_fill() {
    return IconData.iconData(0xf7ab).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_2x2() {
    return IconData.iconData(0xf7ac).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_2x2_fill() {
    return IconData.iconData(0xf7ad).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_3x2() {
    return IconData.iconData(0xf7ae).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_grid_3x2_fill() {
    return IconData.iconData(0xf7af).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_on_rectangle() {
    return IconData.iconData(0xf7b0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_on_rectangle_angled() {
    return IconData.iconData(0xf7b1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_paperclip() {
    return IconData.iconData(0xf7b2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_split_3x1() {
    return IconData.iconData(0xf7b3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_split_3x1_fill() {
    return IconData.iconData(0xf7b4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_split_3x3() {
    return IconData.iconData(0xf7b5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_split_3x3_fill() {
    return IconData.iconData(0xf7b6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack() {
    return IconData.iconData(0xf3c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_badge_minus() {
    return IconData.iconData(0xf7b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_badge_person_crop() {
    return IconData.iconData(0xf7b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_badge_plus() {
    return IconData.iconData(0xf7b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_fill() {
    return IconData.iconData(0xf3ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_fill_badge_minus() {
    return IconData.iconData(0xf7ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_fill_badge_person_crop() {
    return IconData.iconData(0xf7bb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_fill_badge_plus() {
    return IconData.iconData(0xf7bc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_person_crop() {
    return IconData.iconData(0xf7bd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rectangle_stack_person_crop_fill() {
    return IconData.iconData(0xf7be).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData repeat() {
    return IconData.iconData(0xf7bf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData repeat_1() {
    return IconData.iconData(0xf7c0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData resize() {
    return IconData.iconData(0xf900).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData resize_h() {
    return IconData.iconData(0xf901).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData resize_v() {
    return IconData.iconData(0xf902).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData return_icon() {
    return IconData.iconData(0xf7c1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rhombus() {
    return IconData.iconData(0xf7c2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rhombus_fill() {
    return IconData.iconData(0xf7c3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rocket() {
    return IconData.iconData(0xf903).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rocket_fill() {
    return IconData.iconData(0xf904).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rosette() {
    return IconData.iconData(0xf7c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rotate_left() {
    return IconData.iconData(0xf7c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rotate_left_fill() {
    return IconData.iconData(0xf7c6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rotate_right() {
    return IconData.iconData(0xf7c7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData rotate_right_fill() {
    return IconData.iconData(0xf7c8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData scissors() {
    return IconData.iconData(0xf7c9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData scissors_alt() {
    return IconData.iconData(0xf905).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData scope() {
    return IconData.iconData(0xf7ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData scribble() {
    return IconData.iconData(0xf7cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData search_circle() {
    return IconData.iconData(0xf7cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData search_circle_fill() {
    return IconData.iconData(0xf7cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData selection_pin_in_out() {
    return IconData.iconData(0xf7ce).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shield() {
    return IconData.iconData(0xf7cf).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shield_fill() {
    return IconData.iconData(0xf7d0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shield_lefthalf_fill() {
    return IconData.iconData(0xf7d1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shield_slash() {
    return IconData.iconData(0xf7d2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shield_slash_fill() {
    return IconData.iconData(0xf7d3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shift() {
    return IconData.iconData(0xf7d4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData shift_fill() {
    return IconData.iconData(0xf7d5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sidebar_left() {
    return IconData.iconData(0xf7d6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sidebar_right() {
    return IconData.iconData(0xf7d7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData signature() {
    return IconData.iconData(0xf7d8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData skew() {
    return IconData.iconData(0xf7d9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData slash_circle() {
    return IconData.iconData(0xf7da).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData slash_circle_fill() {
    return IconData.iconData(0xf7db).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData slider_horizontal_3() {
    return IconData.iconData(0xf7dc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData slider_horizontal_below_rectangle() {
    return IconData.iconData(0xf7dd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData slowmo() {
    return IconData.iconData(0xf7de).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smallcircle_circle() {
    return IconData.iconData(0xf7df).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smallcircle_circle_fill() {
    return IconData.iconData(0xf7e0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smallcircle_fill_circle() {
    return IconData.iconData(0xf7e1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smallcircle_fill_circle_fill() {
    return IconData.iconData(0xf7e2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smiley() {
    return IconData.iconData(0xf7e3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smiley_fill() {
    return IconData.iconData(0xf7e4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smoke() {
    return IconData.iconData(0xf7e5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData smoke_fill() {
    return IconData.iconData(0xf7e6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData snow() {
    return IconData.iconData(0xf7e7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_down() {
    return IconData.iconData(0xf906).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_down_circle() {
    return IconData.iconData(0xf907).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_down_circle_fill() {
    return IconData.iconData(0xf908).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_up() {
    return IconData.iconData(0xf909).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_up_circle() {
    return IconData.iconData(0xf90a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sort_up_circle_fill() {
    return IconData.iconData(0xf90b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sparkles() {
    return IconData.iconData(0xf7e8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker() {
    return IconData.iconData(0xf7e9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_1() {
    return IconData.iconData(0xf7ea).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_1_fill() {
    return IconData.iconData(0xf3b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_2() {
    return IconData.iconData(0xf7eb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_2_fill() {
    return IconData.iconData(0xf7ec).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_3() {
    return IconData.iconData(0xf7ed).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_3_fill() {
    return IconData.iconData(0xf3ba).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_fill() {
    return IconData.iconData(0xf3b8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_slash() {
    return IconData.iconData(0xf7ee).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_slash_fill() {
    return IconData.iconData(0xf3b9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_slash_fill_rtl() {
    return IconData.iconData(0xf7ef).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_slash_rtl() {
    return IconData.iconData(0xf7f0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_zzz() {
    return IconData.iconData(0xf7f1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_zzz_fill() {
    return IconData.iconData(0xf7f2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_zzz_fill_rtl() {
    return IconData.iconData(0xf7f3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speaker_zzz_rtl() {
    return IconData.iconData(0xf7f4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData speedometer() {
    return IconData.iconData(0xf7f5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sportscourt() {
    return IconData.iconData(0xf7f6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sportscourt_fill() {
    return IconData.iconData(0xf7f7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square() {
    return IconData.iconData(0xf7f8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_down() {
    return IconData.iconData(0xf7f9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_down_fill() {
    return IconData.iconData(0xf7fa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_down_on_square() {
    return IconData.iconData(0xf7fb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_down_on_square_fill() {
    return IconData.iconData(0xf7fc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_left() {
    return IconData.iconData(0xf90c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_left_fill() {
    return IconData.iconData(0xf90d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_right() {
    return IconData.iconData(0xf90e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_right_fill() {
    return IconData.iconData(0xf90f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_up() {
    return IconData.iconData(0xf4ca).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_up_fill() {
    return IconData.iconData(0xf4cb).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_up_on_square() {
    return IconData.iconData(0xf7fd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_arrow_up_on_square_fill() {
    return IconData.iconData(0xf7fe).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_favorites() {
    return IconData.iconData(0xf910).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_favorites_alt() {
    return IconData.iconData(0xf911).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_favorites_alt_fill() {
    return IconData.iconData(0xf912).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_favorites_fill() {
    return IconData.iconData(0xf913).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_fill() {
    return IconData.iconData(0xf7ff).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_fill_line_vertical_square() {
    return IconData.iconData(0xf800).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_fill_line_vertical_square_fill() {
    return IconData.iconData(0xf801).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_fill_on_circle_fill() {
    return IconData.iconData(0xf802).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_fill_on_square_fill() {
    return IconData.iconData(0xf803).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_grid_2x2() {
    return IconData.iconData(0xf804).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_grid_2x2_fill() {
    return IconData.iconData(0xf805).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_grid_3x2() {
    return IconData.iconData(0xf806).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_grid_3x2_fill() {
    return IconData.iconData(0xf807).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_grid_4x3_fill() {
    return IconData.iconData(0xf808).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_lefthalf_fill() {
    return IconData.iconData(0xf809).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_line_vertical_square() {
    return IconData.iconData(0xf80a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_line_vertical_square_fill() {
    return IconData.iconData(0xf80b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_list() {
    return IconData.iconData(0xf914).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_list_fill() {
    return IconData.iconData(0xf915).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_on_circle() {
    return IconData.iconData(0xf80c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_on_square() {
    return IconData.iconData(0xf80d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_pencil() {
    return IconData.iconData(0xf417).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_pencil_fill() {
    return IconData.iconData(0xf417).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_righthalf_fill() {
    return IconData.iconData(0xf80e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_1x2() {
    return IconData.iconData(0xf80f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_1x2_fill() {
    return IconData.iconData(0xf810).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_2x1() {
    return IconData.iconData(0xf811).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_2x1_fill() {
    return IconData.iconData(0xf812).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_2x2() {
    return IconData.iconData(0xf813).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_split_2x2_fill() {
    return IconData.iconData(0xf814).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack() {
    return IconData.iconData(0xf815).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_down_dottedline() {
    return IconData.iconData(0xf816).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_down_right() {
    return IconData.iconData(0xf817).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_down_right_fill() {
    return IconData.iconData(0xf818).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_up() {
    return IconData.iconData(0xf819).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_up_fill() {
    return IconData.iconData(0xf81a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_up_slash() {
    return IconData.iconData(0xf81b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_3d_up_slash_fill() {
    return IconData.iconData(0xf81c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData square_stack_fill() {
    return IconData.iconData(0xf81d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData squares_below_rectangle() {
    return IconData.iconData(0xf81e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star() {
    return IconData.iconData(0xf81f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_circle() {
    return IconData.iconData(0xf820).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_circle_fill() {
    return IconData.iconData(0xf821).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_fill() {
    return IconData.iconData(0xf822).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_lefthalf_fill() {
    return IconData.iconData(0xf823).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_slash() {
    return IconData.iconData(0xf824).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData star_slash_fill() {
    return IconData.iconData(0xf825).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData staroflife() {
    return IconData.iconData(0xf826).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData staroflife_fill() {
    return IconData.iconData(0xf827).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stop() {
    return IconData.iconData(0xf828).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stop_circle() {
    return IconData.iconData(0xf829).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stop_circle_fill() {
    return IconData.iconData(0xf82a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stop_fill() {
    return IconData.iconData(0xf82b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stopwatch() {
    return IconData.iconData(0xf82c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData stopwatch_fill() {
    return IconData.iconData(0xf82d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData strikethrough() {
    return IconData.iconData(0xf82e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_club() {
    return IconData.iconData(0xf82f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_club_fill() {
    return IconData.iconData(0xf830).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_diamond() {
    return IconData.iconData(0xf831).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_diamond_fill() {
    return IconData.iconData(0xf832).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_heart() {
    return IconData.iconData(0xf833).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_heart_fill() {
    return IconData.iconData(0xf834).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_spade() {
    return IconData.iconData(0xf835).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData suit_spade_fill() {
    return IconData.iconData(0xf836).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sum() {
    return IconData.iconData(0xf837).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_dust() {
    return IconData.iconData(0xf838).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_dust_fill() {
    return IconData.iconData(0xf839).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_haze() {
    return IconData.iconData(0xf83a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_haze_fill() {
    return IconData.iconData(0xf83b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_max() {
    return IconData.iconData(0xf4b6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_max_fill() {
    return IconData.iconData(0xf4b7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_min() {
    return IconData.iconData(0xf83c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sun_min_fill() {
    return IconData.iconData(0xf83d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sunrise() {
    return IconData.iconData(0xf83e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sunrise_fill() {
    return IconData.iconData(0xf83f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sunset() {
    return IconData.iconData(0xf840).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData sunset_fill() {
    return IconData.iconData(0xf841).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData t_bubble() {
    return IconData.iconData(0xf842).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData t_bubble_fill() {
    return IconData.iconData(0xf843).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData table() {
    return IconData.iconData(0xf844).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData table_badge_more() {
    return IconData.iconData(0xf845).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData table_badge_more_fill() {
    return IconData.iconData(0xf846).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData table_fill() {
    return IconData.iconData(0xf847).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tag_circle() {
    return IconData.iconData(0xf848).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tag_circle_fill() {
    return IconData.iconData(0xf849).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tag_fill() {
    return IconData.iconData(0xf48d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_aligncenter() {
    return IconData.iconData(0xf84a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_alignleft() {
    return IconData.iconData(0xf84b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_alignright() {
    return IconData.iconData(0xf84c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_append() {
    return IconData.iconData(0xf84d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_badge_checkmark() {
    return IconData.iconData(0xf84e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_badge_minus() {
    return IconData.iconData(0xf84f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_badge_plus() {
    return IconData.iconData(0xf850).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_badge_star() {
    return IconData.iconData(0xf851).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_badge_xmark() {
    return IconData.iconData(0xf852).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_bubble() {
    return IconData.iconData(0xf853).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_bubble_fill() {
    return IconData.iconData(0xf854).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_cursor() {
    return IconData.iconData(0xf855).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_insert() {
    return IconData.iconData(0xf856).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_justify() {
    return IconData.iconData(0xf857).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_justifyleft() {
    return IconData.iconData(0xf858).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_justifyright() {
    return IconData.iconData(0xf859).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData text_quote() {
    return IconData.iconData(0xf85a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textbox() {
    return IconData.iconData(0xf85b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat() {
    return IconData.iconData(0xf85c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_123() {
    return IconData.iconData(0xf85d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_abc() {
    return IconData.iconData(0xf85e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_abc_dottedunderline() {
    return IconData.iconData(0xf85f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_alt() {
    return IconData.iconData(0xf860).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_size() {
    return IconData.iconData(0xf861).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_subscript() {
    return IconData.iconData(0xf862).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData textformat_superscript() {
    return IconData.iconData(0xf863).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData thermometer() {
    return IconData.iconData(0xf864).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData thermometer_snowflake() {
    return IconData.iconData(0xf865).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData thermometer_sun() {
    return IconData.iconData(0xf866).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ticket() {
    return IconData.iconData(0xf916).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData ticket_fill() {
    return IconData.iconData(0xf917).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tickets() {
    return IconData.iconData(0xf918).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tickets_fill() {
    return IconData.iconData(0xf919).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData timelapse() {
    return IconData.iconData(0xf867).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData timer() {
    return IconData.iconData(0xf868).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData timer_fill() {
    return IconData.iconData(0xf91a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData today() {
    return IconData.iconData(0xf91b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData today_fill() {
    return IconData.iconData(0xf91c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tornado() {
    return IconData.iconData(0xf869).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tortoise() {
    return IconData.iconData(0xf86a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tortoise_fill() {
    return IconData.iconData(0xf86b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tram_fill() {
    return IconData.iconData(0xf86c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash() {
    return IconData.iconData(0xf4c4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash_circle() {
    return IconData.iconData(0xf86d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash_circle_fill() {
    return IconData.iconData(0xf86e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash_fill() {
    return IconData.iconData(0xf4c5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash_slash() {
    return IconData.iconData(0xf86f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData trash_slash_fill() {
    return IconData.iconData(0xf870).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray() {
    return IconData.iconData(0xf871).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_2() {
    return IconData.iconData(0xf872).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_2_fill() {
    return IconData.iconData(0xf873).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_arrow_down() {
    return IconData.iconData(0xf874).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_arrow_down_fill() {
    return IconData.iconData(0xf875).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_arrow_up() {
    return IconData.iconData(0xf876).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_arrow_up_fill() {
    return IconData.iconData(0xf877).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_fill() {
    return IconData.iconData(0xf878).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_full() {
    return IconData.iconData(0xf879).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tray_full_fill() {
    return IconData.iconData(0xf87a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tree() {
    return IconData.iconData(0xf91d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData triangle() {
    return IconData.iconData(0xf87b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData triangle_fill() {
    return IconData.iconData(0xf87c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData triangle_lefthalf_fill() {
    return IconData.iconData(0xf87d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData triangle_righthalf_fill() {
    return IconData.iconData(0xf87e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tropicalstorm() {
    return IconData.iconData(0xf87f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tuningfork() {
    return IconData.iconData(0xf880).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv() {
    return IconData.iconData(0xf881).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv_circle() {
    return IconData.iconData(0xf882).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv_circle_fill() {
    return IconData.iconData(0xf883).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv_fill() {
    return IconData.iconData(0xf884).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv_music_note() {
    return IconData.iconData(0xf885).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData tv_music_note_fill() {
    return IconData.iconData(0xf886).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData uiwindow_split_2x1() {
    return IconData.iconData(0xf887).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData umbrella() {
    return IconData.iconData(0xf888).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData umbrella_fill() {
    return IconData.iconData(0xf889).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData underline() {
    return IconData.iconData(0xf88a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData upload_circle() {
    return IconData.iconData(0xf91e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData upload_circle_fill() {
    return IconData.iconData(0xf91f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData videocam() {
    return IconData.iconData(0xf4cc).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData videocam_circle() {
    return IconData.iconData(0xf920).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData videocam_circle_fill() {
    return IconData.iconData(0xf921).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData videocam_fill() {
    return IconData.iconData(0xf4cd).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData view_2d() {
    return IconData.iconData(0xf88b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData view_3d() {
    return IconData.iconData(0xf88c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData viewfinder() {
    return IconData.iconData(0xf88d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData viewfinder_circle() {
    return IconData.iconData(0xf88e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData viewfinder_circle_fill() {
    return IconData.iconData(0xf88f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wand_rays() {
    return IconData.iconData(0xf890).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wand_rays_inverse() {
    return IconData.iconData(0xf891).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wand_stars() {
    return IconData.iconData(0xf892).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wand_stars_inverse() {
    return IconData.iconData(0xf893).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform() {
    return IconData.iconData(0xf894).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_circle() {
    return IconData.iconData(0xf895).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_circle_fill() {
    return IconData.iconData(0xf896).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_path() {
    return IconData.iconData(0xf897).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_path_badge_minus() {
    return IconData.iconData(0xf898).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_path_badge_plus() {
    return IconData.iconData(0xf899).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData waveform_path_ecg() {
    return IconData.iconData(0xf89a).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wifi() {
    return IconData.iconData(0xf89b).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wifi_exclamationmark() {
    return IconData.iconData(0xf89c).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wifi_slash() {
    return IconData.iconData(0xf89d).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wind() {
    return IconData.iconData(0xf89e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wind_snow() {
    return IconData.iconData(0xf89f).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wrench() {
    return IconData.iconData(0xf8a0).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData wrench_fill() {
    return IconData.iconData(0xf8a1).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark() {
    return IconData.iconData(0xf404).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_circle() {
    return IconData.iconData(0xf405).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_circle_fill() {
    return IconData.iconData(0xf36e).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_octagon() {
    return IconData.iconData(0xf8a2).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_octagon_fill() {
    return IconData.iconData(0xf8a3).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_rectangle() {
    return IconData.iconData(0xf8a4).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_rectangle_fill() {
    return IconData.iconData(0xf8a5).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_seal() {
    return IconData.iconData(0xf8a6).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_seal_fill() {
    return IconData.iconData(0xf8a7).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_shield() {
    return IconData.iconData(0xf8a8).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_shield_fill() {
    return IconData.iconData(0xf8a9).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_square() {
    return IconData.iconData(0xf8aa).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData xmark_square_fill() {
    return IconData.iconData(0xf8ab).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData zoom_in() {
    return IconData.iconData(0xf8ac).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData zoom_out() {
    return IconData.iconData(0xf8ad).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  public static IconData zzz() {
    return IconData.iconData(0xf8ae).fontFamily(iconFont()).fontPackage(iconFontPackage()).build();
  }
  @Override
  public CupertinoIcons build() {
    return this;
  }
}
