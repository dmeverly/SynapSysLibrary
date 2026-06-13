package types;

public class SynapSysRequest {
    private final String provider;
    private final String model;
    private final String message;
    private final String API_Key;

    public SynapSysRequest(String provider, String model, String message, String API_Key) {
        this.provider = provider;
        this.model = model;
        this.API_Key = API_Key;
        this.message = message;
    }

    public String getModel(){
        return this.model;
    }

    public String getMessage() {
        return this.message;
    }

    public String getApiKey() {
        return this.API_Key;
    }
}