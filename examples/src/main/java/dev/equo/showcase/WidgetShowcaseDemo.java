package dev.equo.showcase;

import dev.equo.ewt.App;

/**
 * Entry point for the EWT Widget Showcase.
 *
 * Run with:
 *   ./gradlew :examples:run -PmainClass=dev.equo.showcase.WidgetShowcaseDemo
 */
public class WidgetShowcaseDemo {
    public static void main(String[] args) {
        App.runApp(ShowcaseApp::new);
    }
}
