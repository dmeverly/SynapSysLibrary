package types;

public class SynapSysMessage {
    private final String provider;
    private final String model;
    private final String message;

    public SynapSysMessage(String provider, String model, String message) {
        this.provider = provider;
        this.model = model;
        this.message = message;
    }

    public String getModel() {
        return this.model;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}