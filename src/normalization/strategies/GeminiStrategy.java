package normalization.strategies;

import java.util.HashMap;
import java.util.Map;

import types.SynapSysRequest;

public class GeminiStrategy extends Network_Strategy {
    private final SynapSysRequest synapsysRequest;

    public GeminiStrategy(SynapSysRequest synapsysRequest) {
        super(util.settings.GEMINI_ROOT_URL.getStringValue() + synapsysRequest.getModel() + ":generateContent",
                synapsysRequest.getMessage());
        this.synapsysRequest = synapsysRequest;
    }

    @Override
    public String buildPayload() {
        String text = this.getPayload() == null ? "" : this.getPayload().replace("\\", "\\\\").replace("\"", "\\\"");
        String json = "{" +
                "\"contents\":[{" +
                "\"parts\":[{" +
                "\"text\":\"" + text + "\"" +
                "}]}]" +
                "}";

        return json;
    }

    @Override
    protected Map<String, String> addHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("x-goog-api-key", this.synapsysRequest.getApiKey());
        return headers;
    }

}