package api;
import normalization.*;
import types.*;

public class Generator {
    private final Normalizer normalizer;

    public Generator(){
        this.normalizer = new Normalizer();
    }
    public ProviderResponse generate(SynapSysRequest request) {
        return normalizer.normalize(request);
    }
}
