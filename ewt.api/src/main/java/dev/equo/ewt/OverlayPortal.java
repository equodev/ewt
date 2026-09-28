package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OverlayPortal extends StatefulWidget implements OverlayPortalI {
  protected OverlayPortal() {}
  OverlayPortal(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverlayPortal");
    this.nativeStruct = factories.takeLastStruct();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overlayPortalChild not supported on web");
    return factories.OverlayPortal_readBack_child(nativeStruct);
  }
  public OverlayChildLocation overlayLocation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overlayPortalOverlayLocation not supported on web");
    return factories.OverlayPortal_readBack_overlayLocation(nativeStruct);
  }
  @Override
  public OverlayPortal build() {
    return this;
  }
}
