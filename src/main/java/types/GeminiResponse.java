package types;

import com.google.genai.types.GenerateContentResponse;

public class GeminiResponse implements ProviderResponse {
    private final GenerateContentResponse generateContentResponse;

    public GeminiResponse(GenerateContentResponse generateContentResponse) {
        this.generateContentResponse = generateContentResponse;
    }

    @Override
    public SynapSysMessage convertToSynapSysMessage() {
        return new SynapSysMessage("gemini", "", this.generateContentResponse.text());
    }
}
