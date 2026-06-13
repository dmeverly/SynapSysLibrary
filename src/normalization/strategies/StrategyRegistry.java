package normalization.strategies;

public class StrategyRegistry {

    public static Class<? extends FMP_Strategy> getStrategy(String provider) {
        return strategies.get(provider);
    }
}