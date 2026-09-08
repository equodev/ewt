package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ImageIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ImageIcon extends StatelessWidget implements ImageIconI {
  private MemorySegment st;
  protected ImageIcon() {}
  ImageIcon(MemorySegment st) {
    this.id = ImageIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ImageIcon");
    System.out.println("New ImageIcon id:"+id);
  }
  ImageIcon(int id) { this.id = id; }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIconSize not supported on web");
    return ImageIconObjSt.size(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("imageIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ImageIconObjSt.color(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("imageIconSemanticLabel not supported on web");
    return ImageIconObjSt.semanticLabel(st).getString(0);
  }
  @Override
  public ImageIcon build() {
    return this;
  }
}
