package types;

import com.openai.models.responses.Response;

public class OpenAIResponse implements ProviderResponse {
    private final Response response;

    public OpenAIResponse(Response response) {
        this.response = response;
    }

    @Override
    public SynapSysMessage convertToSynapSysMessage() {
        StringBuilder message = new StringBuilder();

        for (var outputItem : this.response.output()) {
            if (!outputItem.isMessage()) {
                continue;
            }

            for (var content : outputItem.asMessage().content()) {
                if (!content.isOutputText()) {
                    continue;
                }

                message.append(content.asOutputText().text());
            }
        }

        return new SynapSysMessage("openai", "", message.toString());
    }
}