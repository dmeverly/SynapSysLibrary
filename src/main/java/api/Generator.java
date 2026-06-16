package api;

import normalization.*;
import types.*;

public class Generator {
    private final Normalizer normalizer;

    public Generator() {
        this.normalizer = new Normalizer();
    }

    public SynapSysMessage generate(SynapSysMessage synapSysMessage) {
        return normalizer.normalize(synapSysMessage);
    }
}
