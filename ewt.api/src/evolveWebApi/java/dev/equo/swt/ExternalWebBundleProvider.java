package dev.equo.swt;

/**
 * Compile-only copy of Evolve's web bundle SPI, which ships in the enterprise Evolve jar and not in
 * the public swt-evolve build the evolve source set compiles against. It is never packaged: at run
 * time the enterprise jar provides the real interface, and the public build never loads the
 * provider, since only Evolve's web surface looks it up. Keep it identical to Evolve's interface.
 */
public interface ExternalWebBundleProvider {

    String extractAndGetWebDir();
}
