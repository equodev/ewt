package dev.equo.ewt;

import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Fluent shorthand builder for {@link TextStyle}. Use via
 * {@code import static dev.equo.ewt.EWT.*} and {@code ts()} / {@code ts(int)} / {@code ts(double)}.
 *
 * <pre>{@code
 * Text("Title").style(ts(22).bold())
 * Text("hint").style(ts(14).color(Colors.grey().shade600()))
 * Text("body").style(ts().italic().tracking(0.5))
 * }</pre>
 *
 * Only the most common TextStyle properties are exposed. For anything else, use
 * {@link EWT#TextStyle()} and chain the full builder directly.
 */
public final class EwtTextStyle implements TextStyleI {
    private Double fontSize;
    private FontWeightI fontWeight;
    private FontStyle fontStyle;
    private ColorI color;
    private ColorI backgroundColor;
    private Double letterSpacing;
    private Double wordSpacing;
    private Double height;

    EwtTextStyle() {}

    public EwtTextStyle size(int n) { fontSize = (double) n; return this; }
    public EwtTextStyle size(double n) { fontSize = n; return this; }

    public EwtTextStyle bold() { fontWeight = FontWeight.bold(); return this; }
    public EwtTextStyle italic() { fontStyle = FontStyle.italic; return this; }
    public EwtTextStyle weight(FontWeightI w) { fontWeight = w; return this; }

    public EwtTextStyle color(ColorI c) { color = c; return this; }
    public EwtTextStyle bg(ColorI c) { backgroundColor = c; return this; }

    public EwtTextStyle tracking(double v) { letterSpacing = v; return this; }
    public EwtTextStyle wordSpacing(double v) { wordSpacing = v; return this; }
    public EwtTextStyle lineHeight(double v) { height = v; return this; }

    private static OptionalDouble opt(Double d) {
        return d != null ? OptionalDouble.of(d) : OptionalDouble.empty();
    }

    @Override
    public TextStyle build() {
        return TextStyle.textStyleTextStyle(
            Optional.empty(),
            Optional.ofNullable(color),
            Optional.ofNullable(backgroundColor),
            opt(fontSize),
            Optional.ofNullable(fontWeight),
            Optional.ofNullable(fontStyle),
            opt(letterSpacing),
            opt(wordSpacing),
            Optional.empty(),
            opt(height),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            OptionalDouble.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        );
    }
}
