package normalization.strategies;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Map;

public abstract class Local_Strategy implements FMP_Strategy{
    private final HttpClient httpClient;
    private final String destinationURL;
    private final String payload;
    private final String name;

    public Local_Strategy(String destinationURL, String payload) {
        this.httpClient = HttpClient.newBuilder()
        .connectTimeout(java.time.Duration.ofSeconds(util.settings.TIMEOUT.getValue()))
        .build();
        this.destinationURL = destinationURL;
        this.payload = payload;
        this.name = this.getClass().getSimpleName();
    }

    public String getName(){
        return this.name;
    }

    protected String getPayload(){
        return this.getPayload();
    }

    public HttpResponse<String> post() {
        String json = this.buildPayload();

        try {
            return util.HttpHelper.postJson(this.destinationURL, json);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(this.getName() + " Failed to POST", e);
        }
    }

    protected abstract Map<String,String> addHeaders();
    protected abstract String buildPayload();
}
