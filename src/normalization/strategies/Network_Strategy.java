package normalization.strategies;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Map;

import types.SynapSysRequest;

public abstract class Network_Strategy implements FMP_Strategy {
    private final HttpClient httpClient;
    private final String destinationURL;
    private final String payload;
    private final String name;
    private final SynapSysRequest synapSysRequest;

    public Network_Strategy(String destinationURL, String payload, SynapSysRequest synapSysRequest) {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(java.time.Duration.ofSeconds(util.settings.TIMEOUT.getValue()))
                .build();
        this.destinationURL = destinationURL;
        this.payload = payload;
        this.synapSysRequest = synapSysRequest;
        this.name = this.getClass().getSimpleName();
    }

    public String getName() {
        return this.name;
    }

    protected String getPayload() {
        return this.payload;
    }

    protected String getProvider() {
        return this.synapSysRequest.getProvider();
    }

    public HttpResponse<String> post() {
        String json = this.buildPayload();
        Map<String, String> headers = this.addHeaders();

        try {
            return util.HttpHelper.postJsonWithHeaders(this.destinationURL, json, headers);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(this.getName() + " Failed to POST", e);
        }
    }

    protected abstract Map<String, String> addHeaders();

    protected abstract String buildPayload();
}
