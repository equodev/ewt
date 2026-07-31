package dev.equo;

import dev.equo.ewt.*;
import static dev.equo.ewt.EWT.*;
import java.util.List;

public class ProfileCard {

  public static void main(String[] args) {
    App.runApp(ProfileCardApp::new);
  }

  static class ProfileCardApp extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return materialApp("Profile Card", Colors.indigo(), new ProfileCardPage());
    }
  }

  static class ProfileCardPage extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return Scaffold()
          .appBar(AppBar()
              .title(Text("Profile")))
          .body(Center()
              .child(Container()
                  .width(320.0)
                  .decoration(BoxDecoration()
                      .color(Colors.white())
                      .borderRadius(BorderRadius_circular(16.0))
                      .boxShadow(List.of(
                          BoxShadow()
                              .color(Color_fromRGBO(0, 0, 0, 0.12))
                              .blurRadius(16.0)
                              .offset(Offset(0.0, 4.0)))))
                  .padding(EdgeInsets_all(24.0))
                  .child(Column()
                      .mainAxisSize(MainAxisSize.min)
                      .crossAxisAlignment(CrossAxisAlignment.center)
                      .children(List.of(
                          Container()
                              .width(88.0)
                              .height(88.0)
                              .decoration(BoxDecoration()
                                  .shape(BoxShape.circle)
                                  .color(Colors.indigo()))
                              .alignment(Alignment.center())
                              .child(Icon(Icons.person())
                                  .size(48.0)
                                  .color(Colors.white())),
                          SizedBox().height(16.0),
                          Text("Jane Doe")
                              .style(ts(22).bold()),
                          SizedBox().height(4.0),
                          Text("Flutter Developer")
                              .style(ts(14).color(Colors.grey().shade600())),
                          SizedBox().height(20.0),
                          Divider(),
                          SizedBox().height(16.0),
                          Row()
                              .crossAxisAlignment(CrossAxisAlignment.center)
                              .children(List.of(
                                  Icon(Icons.email())
                                      .size(18.0)
                                      .color(Colors.indigo()),
                                  SizedBox().width(8.0),
                                  Text("jane.doe@example.com")
                                      .style(ts(13))
                              )),
                          SizedBox().height(10.0),
                          Row()
                              .crossAxisAlignment(CrossAxisAlignment.center)
                              .children(List.of(
                                  Icon(Icons.work())
                                      .size(18.0)
                                      .color(Colors.indigo()),
                                  SizedBox().width(8.0),
                                  Text("Equo Technologies")
                                      .style(ts(13))
                              ))
                      ))
              ))
          );
    }
  }
}
