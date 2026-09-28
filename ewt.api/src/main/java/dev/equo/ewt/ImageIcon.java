package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ImageIcon extends StatelessWidget implements ImageIconI {
  protected ImageIcon() {}
  ImageIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIconSize not supported on web");
    return factories.ImageIcon_readBack_size(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("imageIconColor", getId());
      return new Color(__nid);
    }
    return factories.ImageIcon_readBack_color(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIconSemanticLabel not supported on web");
    return factories.ImageIcon_readBack_semanticLabel(nativeStruct);
  }
  @Override
  public ImageIcon build() {
    return this;
  }
}
