package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Spacer extends StatelessWidget implements SpacerI {
  protected Spacer() {}
  Spacer(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Spacer");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Spacer spacerSpacer(OptionalInt flex) {
    int id = factories.spacerSpacer(flex);
    if (id <= 0) throw new RuntimeException("Failed to created widget Spacer");
    return new Spacer(id);
  }
  public static SpacerSpacerBuilder spacer() {
    return SpacerSpacerBuilder.spacerSpacer();
  }
  public int flex() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("spacerFlex not supported on web");
    return factories.Spacer_readBack_flex(nativeStruct);
  }
  @Override
  public Spacer build() {
    return this;
  }
}
