package normalization.strategies;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import types.OllamaResponse;
import types.ProviderResponse;
import types.SynapSysMessage;

public class OllamaCloudStrategy extends OllamaStrategy {

    public OllamaCloudStrategy(SynapSysMessage synapsysMessage) {
        super(synapsysMessage);
    }

    @Override
    public ProviderResponse post() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ollama.com/api/generate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(buildPayload(this.synapSysMessage.getMessage())))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new OllamaResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new OllamaResponse(null);
    }
}
