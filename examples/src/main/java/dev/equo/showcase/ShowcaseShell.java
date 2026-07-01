package dev.equo.showcase;

import dev.equo.ewt.*;

/**
 * Root navigator. Holds the active PageId and rebuilds when a page asks
 * to navigate. Pages receive {@code goTo} / {@code goHome} as constructor
 * callbacks so they can hand control back without knowing about the shell.
 */
class ShowcaseShell extends SubStatefulWidget {
    @Override
    protected State<ShowcaseShell> createState() {
        return new ShowcaseShellState();
    }
}

class ShowcaseShellState extends SubState<ShowcaseShell> {
    private PageId current = PageId.HOME;

    void goTo(PageId page) {
        System.out.println("[shell] goTo " + page + " (was " + current + ")");
        setState(() -> {
            System.out.println("[shell] setState callback fired, current=" + current + " -> " + page);
            current = page;
        });
    }

    void goHome() {
        System.out.println("[shell] goHome (was " + current + ")");
        setState(() -> {
            System.out.println("[shell] setState callback fired, going HOME");
            current = PageId.HOME;
        });
    }

    @Override
    public Widget build(BuildContext context) {
        System.out.println("[shell] build current=" + current);
        return switch (current) {
            case HOME           -> new HomePage(this::goTo);
            case ANIMATION_LAB  -> new AnimationLabPage(this::goHome);
            case INTERACTIVE    -> new InteractivePage(this::goHome);
            case GALLERY        -> new GalleryPage(this::goHome);
        };
    }
}
