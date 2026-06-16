package types;

import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.Response;


public class OpenAIResponse implements ProviderResponse {
    private final ResponseCreateParams responseCreateParams;

    public OpenAIResponse(ResponseCreateParams responseCreateParams) {
        this.responseCreateParams = responseCreateParams;
    }

    @Override
    public SynapSysMessage convertToSynapSysMessage() {
        return new SynapSysMessage("openai", "", this.responseCreateParams.text());
    }
}