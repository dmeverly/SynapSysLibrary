package normalization.strategies;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.ResponseCreateParams;

import types.ProviderResponse;
import types.SynapSysMessage;

import com.openai.models.responses.Response;

public class OpenAIStrategy implements FMP_Strategy {
    private final SynapSysMessage synapSysMessage;

    public OpenAIStrategy(SynapSysMessage synapSysMessage) {
        this.synapSysMessage = synapSysMessage;
    }

    @Override
    public ProviderResponse post() {
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(this.synapSysMessage.getMessage())
                .model(this.synapSysMessage.getModel())
                .build();

        Response response = client.responses().create(params);
        
        return new OpenAIResponse(response);
    }
}
