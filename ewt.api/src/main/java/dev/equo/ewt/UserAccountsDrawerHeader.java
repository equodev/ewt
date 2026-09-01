package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.UserAccountsDrawerHeaderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class UserAccountsDrawerHeader extends StatefulWidget implements UserAccountsDrawerHeaderI {
  private MemorySegment st;
  protected UserAccountsDrawerHeader() {}
  UserAccountsDrawerHeader(MemorySegment st) {
    this.id = UserAccountsDrawerHeaderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget UserAccountsDrawerHeader");
    System.out.println("New UserAccountsDrawerHeader id:"+id);
  }
  UserAccountsDrawerHeader(int id) { this.id = id; }
  @Builder.Factory
  static UserAccountsDrawerHeader userAccountsDrawerHeaderUserAccountsDrawerHeader(Optional<DecorationI> decoration, Optional<EdgeInsetsGeometryI> margin, Optional<WidgetI> currentAccountPicture, Optional<List<WidgetI>> otherAccountsPictures, WidgetI accountName, WidgetI accountEmail, Optional<Runnable> onDetailsPressed, Optional<ColorI> arrowColor) {
    var st = factories.userAccountsDrawerHeaderUserAccountsDrawerHeader(decoration.map(DecorationI::build),
      margin.map(EdgeInsetsGeometryI::build),
      currentAccountPicture.map(WidgetI::build),
      otherAccountsPictures.map(i -> i.stream().map(WidgetI::build).toList()),
      accountName.build(),
      accountEmail.build(),
      onDetailsPressed,
      arrowColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget UserAccountsDrawerHeader");
    return new UserAccountsDrawerHeader(st);
  }
  public static UserAccountsDrawerHeaderUserAccountsDrawerHeaderBuilder userAccountsDrawerHeader() {
    return UserAccountsDrawerHeaderUserAccountsDrawerHeaderBuilder.userAccountsDrawerHeaderUserAccountsDrawerHeader();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderDecoration not supported on web");
    return new Decoration(UserAccountsDrawerHeaderObjSt.decoration(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderMargin not supported on web");
    return new EdgeInsetsGeometry(UserAccountsDrawerHeaderObjSt.margin(st)) {};
  }
  public Widget currentAccountPicture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderCurrentAccountPicture not supported on web");
    return new Widget(UserAccountsDrawerHeaderObjSt.currentAccountPicture(st)) {};
  }
  public Widget accountName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderAccountName not supported on web");
    return new Widget(UserAccountsDrawerHeaderObjSt.accountName(st)) {};
  }
  public Widget accountEmail() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderAccountEmail not supported on web");
    return new Widget(UserAccountsDrawerHeaderObjSt.accountEmail(st)) {};
  }
  public Color arrowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("userAccountsDrawerHeaderArrowColor", getId());
      return new Color(__nid);
    }
    return new Color(UserAccountsDrawerHeaderObjSt.arrowColor(st));
  }
  @Override
  public UserAccountsDrawerHeader build() {
    return this;
  }
}
