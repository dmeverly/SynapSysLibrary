package normalization.strategies;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import types.SynapSysRequest;

public class OllamaStrategy extends Network_Strategy{
    private final SynapSysRequest synapsysRequest;

    public OllamaStrategy(SynapSysRequest synapsysRequest, int port) {
        super(util.settings.OLLAMA_URL.getStringValue() + ":"+ port + "/api/generate",
                synapsysRequest.getMessage());
        this.synapsysRequest = synapsysRequest;
    }

    @Override
    public String buildPayload() {
        String text = this.getPayload() == null ? "" : this.getPayload().replace("\\", "\\\\").replace("\"", "\\\"");
        String model = this.synapsysRequest.getModel();
        String json = "{" +
                "\"model\":[{" +
                "\"prompt\":[{" + text + "\"" +
                "}\'";

        return json;
    }

    @Override
    protected Map<String, String> addHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", this.synapsysRequest.getApiKey());`1
        return headers;
    }

    
}
