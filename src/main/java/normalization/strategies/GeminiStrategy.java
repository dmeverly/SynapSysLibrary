package normalization.strategies;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import types.GeminiResponse;
import types.ProviderResponse;
import types.SynapSysMessage;

public class GeminiStrategy implements FMP_Strategy {
    private final SynapSysMessage synapSysMessage;
    private final Client client;

    public GeminiStrategy(SynapSysMessage synapsysMessage) {
        this.synapSysMessage = synapsysMessage;
        this.client = new Client();
    }

    @Override
    public ProviderResponse post() {
        GenerateContentResponse response = client.models.generateContent(
                synapSysMessage.getModel(),
                synapSysMessage.getMessage(),
                null);
        return new GeminiResponse(response);
    }
}
