package normalization;

import java.util.ArrayList;

import normalization.strategies.StrategyRegistry;

public class Normalizer {
    private final StrategyRegistry strategyRegistry;

    public Normalizer() {
        this.strategyRegistry = new StrategyRegistry();
    }

    public ProviderResponse normalize(SynapSysRequest request){
        //TODO
        return null;
    }
}
