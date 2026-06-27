package normalization.strategies;

import types.SynapSysMessage;

import java.net.http.HttpClient;

public abstract class OllamaStrategy implements FMP_Strategy {
    protected final SynapSysMessage synapSysMessage;
    protected final HttpClient client;

    public OllamaStrategy(SynapSysMessage synapsysMessage) {
        this.synapSysMessage = synapsysMessage;
        this.client = HttpClient.newHttpClient();
    }

    protected String buildPayload(String prompt) {
        String escapedModel = this.synapSysMessage.getModel().replace("\\", "\\\\").replace("\"", "\\\"");
        String escapedPrompt = prompt.replace("\\", "\\\\").replace("\"", "\\\"");
        return "{\"model\":\"" + escapedModel + "\",\"prompt\":\"" + escapedPrompt + "\"}";
    }
}
