package dev.equo.ewt.evolve;

import dev.equo.swt.ExternalBundleProvider;

/**
 * ServiceLoader entry (registered in META-INF/services): hands Evolve the base directory of
 * the extracted EWT-owned combined bundle. Ships only in the evolve-bundle classifier jar,
 * so standalone Evolve never discovers it.
 */
public final class EvolveBundleProvider implements ExternalBundleProvider {

    @Override
    public String extractAndGetBundleBaseDir() {
        return EvolveBundleExtractor.extractAndGetBase();
    }
}
