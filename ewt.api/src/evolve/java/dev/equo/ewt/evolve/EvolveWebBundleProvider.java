package dev.equo.ewt.evolve;

import dev.equo.swt.ExternalWebBundleProvider;

/**
 * Web analogue of {@link EvolveBundleProvider}: hands Evolve the directory of the extracted
 * EWT-owned combined WEB bundle (evolve-app `flutter build web`), so Evolve's WebFlutterServer
 * serves it instead of its own. ServiceLoader entry (registered in META-INF/services); ships only
 * in the ewt-evolve WEB jar, so standalone Evolve never discovers it.
 */
public final class EvolveWebBundleProvider implements ExternalWebBundleProvider {

    @Override
    public String extractAndGetWebDir() {
        return EvolveBundleExtractor.extractAndGetWebDir();
    }
}
