package normalization.strategies;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import types.GeminiResponse;
import types.ProviderResponse;
import types.SynapSysMessage;

public class GeminiStrategy implements FMP_Strategy {
    private final SynapSysMessage synapSysMessage;

    public GeminiStrategy(SynapSysMessage synapsysMessage) {
        this.synapSysMessage = synapsysMessage;
    }

    @Override
    public ProviderResponse post() {
        Client client = new Client();
        GenerateContentResponse response = client.models.generateContent(
                synapSysMessage.getModel(),
                synapSysMessage.getMessage(),
                null);
        client.close();

        return new GeminiResponse(response);
    }
}
