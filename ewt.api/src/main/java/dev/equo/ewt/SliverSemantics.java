package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverSemantics extends _SemanticsBase implements SliverSemanticsI {
  private MemorySegment st;
  protected SliverSemantics() {}
  SliverSemantics(MemorySegment st) {
    this.id = SliverSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverSemantics");
    System.out.println("New SliverSemantics id:"+id);
  }
  SliverSemantics(int id) { this.id = id; }
  @Builder.Factory
  static SliverSemantics sliverSemanticsSliverSemantics(@Builder.Parameter WidgetI sliver, Optional<Boolean> container, Optional<Boolean> explicitChildNodes, Optional<Boolean> excludeSemantics, Optional<Boolean> blockUserActions, Optional<Boolean> enabled, Optional<Boolean> checked, Optional<Boolean> mixed, Optional<Boolean> selected, Optional<Boolean> toggled, Optional<Boolean> button, Optional<Boolean> slider, Optional<Boolean> keyboardKey, Optional<Boolean> link, Optional<Boolean> header, OptionalInt headingLevel, Optional<Boolean> textField, Optional<Boolean> readOnly, Optional<Boolean> focusable, Optional<Boolean> focused, Optional<AccessibilityFocusBlockType> accessibilityFocusBlockType, Optional<Boolean> inMutuallyExclusiveGroup, Optional<Boolean> obscured, Optional<Boolean> multiline, Optional<Boolean> scopesRoute, Optional<Boolean> namesRoute, Optional<Boolean> hidden, Optional<Boolean> image, Optional<Boolean> liveRegion, Optional<Boolean> expanded, Optional<Boolean> isRequired, OptionalInt maxValueLength, OptionalInt currentValueLength, Optional<String> identifier, Optional<NativeObj.I> traversalParentIdentifier, Optional<NativeObj.I> traversalChildIdentifier, Optional<String> label, Optional<String> value, Optional<String> increasedValue, Optional<String> decreasedValue, Optional<String> hint, Optional<String> tooltip, Optional<String> onTapHint, Optional<String> onLongPressHint, Optional<TextDirection> textDirection, Optional<Runnable> onTap, Optional<Runnable> onLongPress, Optional<Runnable> onScrollLeft, Optional<Runnable> onScrollRight, Optional<Runnable> onScrollUp, Optional<Runnable> onScrollDown, Optional<Runnable> onIncrease, Optional<Runnable> onDecrease, Optional<Runnable> onCopy, Optional<Runnable> onCut, Optional<Runnable> onPaste, Optional<Runnable> onDismiss, Optional<Consumer<Boolean>> onMoveCursorForwardByCharacter, Optional<Consumer<Boolean>> onMoveCursorBackwardByCharacter, Optional<Consumer<String>> onSetText, Optional<Runnable> onDidGainAccessibilityFocus, Optional<Runnable> onDidLoseAccessibilityFocus, Optional<Runnable> onFocus, Optional<Runnable> onExpand, Optional<Runnable> onCollapse, Optional<SemanticsRole> role, Optional<SemanticsValidationResult> validationResult, Optional<SemanticsHitTestBehavior> hitTestBehavior, Optional<SemanticsInputType> inputType, Optional<String> minValue, Optional<String> maxValue) {
    var st = factories.sliverSemanticsSliverSemantics(sliver.build(),
      container,
      explicitChildNodes,
      excludeSemantics,
      blockUserActions,
      enabled,
      checked,
      mixed,
      selected,
      toggled,
      button,
      slider,
      keyboardKey,
      link,
      header,
      headingLevel,
      textField,
      readOnly,
      focusable,
      focused,
      accessibilityFocusBlockType,
      inMutuallyExclusiveGroup,
      obscured,
      multiline,
      scopesRoute,
      namesRoute,
      hidden,
      image,
      liveRegion,
      expanded,
      isRequired,
      maxValueLength,
      currentValueLength,
      identifier,
      traversalParentIdentifier.map(NativeObj.I::build),
      traversalChildIdentifier.map(NativeObj.I::build),
      label,
      value,
      increasedValue,
      decreasedValue,
      hint,
      tooltip,
      onTapHint,
      onLongPressHint,
      textDirection,
      onTap,
      onLongPress,
      onScrollLeft,
      onScrollRight,
      onScrollUp,
      onScrollDown,
      onIncrease,
      onDecrease,
      onCopy,
      onCut,
      onPaste,
      onDismiss,
      onMoveCursorForwardByCharacter,
      onMoveCursorBackwardByCharacter,
      onSetText,
      onDidGainAccessibilityFocus,
      onDidLoseAccessibilityFocus,
      onFocus,
      onExpand,
      onCollapse,
      role,
      validationResult,
      hitTestBehavior,
      inputType,
      minValue,
      maxValue);
    if (st == null) throw new RuntimeException("Failed to created widget SliverSemantics");
    return new SliverSemantics(st);
  }
  public static SliverSemanticsSliverSemanticsBuilder sliverSemantics(WidgetI sliver) {
    return SliverSemanticsSliverSemanticsBuilder.sliverSemanticsSliverSemantics(sliver);
  }
  @Override
  public SliverSemantics build() {
    return this;
  }
}
