package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OverlayPortalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OverlayPortal extends StatefulWidget implements OverlayPortalI {
  private MemorySegment st;
  protected OverlayPortal() {}
  OverlayPortal(MemorySegment st) {
    this.id = OverlayPortalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverlayPortal");
    System.out.println("New OverlayPortal id:"+id);
  }
  OverlayPortal(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overlayPortalChild not supported on web");
    return new Widget(OverlayPortalObjSt.child(st)) {};
  }
  public OverlayChildLocation overlayLocation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overlayPortalOverlayLocation not supported on web");
    return OverlayChildLocation.values()[OverlayPortalObjSt.overlayLocation(st)];
  }
  @Override
  public OverlayPortal build() {
    return this;
  }
}
