package normalization.strategies;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import types.OllamaResponse;
import types.ProviderResponse;
import types.SynapSysMessage;

public class OllamaLocalStrategy extends OllamaStrategy {
    private final int localPort;

    public OllamaLocalStrategy(SynapSysMessage synapSysMessage, int localPort) {
        super(synapSysMessage);
        this.localPort = localPort;
    }

    @Override
    public ProviderResponse post() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + this.localPort + "/api/generate"))
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
