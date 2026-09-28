package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class UserAccountsDrawerHeader extends StatefulWidget implements UserAccountsDrawerHeaderI {
  protected UserAccountsDrawerHeader() {}
  UserAccountsDrawerHeader(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget UserAccountsDrawerHeader");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static UserAccountsDrawerHeader userAccountsDrawerHeaderUserAccountsDrawerHeader(Optional<DecorationI> decoration, Optional<EdgeInsetsGeometryI> margin, Optional<WidgetI> currentAccountPicture, Optional<List<WidgetI>> otherAccountsPictures, Optional<WidgetI> accountName, Optional<WidgetI> accountEmail, Optional<Runnable> onDetailsPressed, Optional<ColorI> arrowColor) {
    int id = factories.userAccountsDrawerHeaderUserAccountsDrawerHeader(decoration.map(DecorationI::build),
      margin.map(EdgeInsetsGeometryI::build),
      currentAccountPicture.map(WidgetI::build),
      otherAccountsPictures.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      accountName.map(WidgetI::build),
      accountEmail.map(WidgetI::build),
      onDetailsPressed,
      arrowColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget UserAccountsDrawerHeader");
    return new UserAccountsDrawerHeader(id);
  }
  public static UserAccountsDrawerHeaderUserAccountsDrawerHeaderBuilder userAccountsDrawerHeader() {
    return UserAccountsDrawerHeaderUserAccountsDrawerHeaderBuilder.userAccountsDrawerHeaderUserAccountsDrawerHeader();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderDecoration not supported on web");
    return factories.UserAccountsDrawerHeader_readBack_decoration(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderMargin not supported on web");
    return factories.UserAccountsDrawerHeader_readBack_margin(nativeStruct);
  }
  public Widget currentAccountPicture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderCurrentAccountPicture not supported on web");
    return factories.UserAccountsDrawerHeader_readBack_currentAccountPicture(nativeStruct);
  }
  public Widget accountName() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderAccountName not supported on web");
    return factories.UserAccountsDrawerHeader_readBack_accountName(nativeStruct);
  }
  public Widget accountEmail() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("userAccountsDrawerHeaderAccountEmail not supported on web");
    return factories.UserAccountsDrawerHeader_readBack_accountEmail(nativeStruct);
  }
  public Color arrowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("userAccountsDrawerHeaderArrowColor", getId());
      return new Color(__nid);
    }
    return factories.UserAccountsDrawerHeader_readBack_arrowColor(nativeStruct);
  }
  @Override
  public UserAccountsDrawerHeader build() {
    return this;
  }
}
