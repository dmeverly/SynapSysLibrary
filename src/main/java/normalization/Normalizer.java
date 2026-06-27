package normalization;

import normalization.strategies.GeminiStrategy;
import normalization.strategies.OllamaCloudStrategy;
import normalization.strategies.OllamaLocalStrategy;
import normalization.strategies.OpenAIStrategy;

import types.SynapSysMessage;

public class Normalizer {

    public Normalizer() {
    }

    public SynapSysMessage normalize(SynapSysMessage synapSysMessage) {
        String provider = synapSysMessage.getProvider();
        switch (provider) {
            case "gemini":
                return new GeminiStrategy(synapSysMessage).post().convertToSynapSysMessage();
            case "openai":
                return new OpenAIStrategy(synapSysMessage).post().convertToSynapSysMessage();
            case "ollama-cloud":
                return new OllamaCloudStrategy(synapSysMessage).post().convertToSynapSysMessage();
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

    public SynapSysMessage normalize(SynapSysMessage synapSysMessage, int localPort) {
        String provider = synapSysMessage.getProvider();
        switch (provider) {
            case "ollama-local":
                return new OllamaLocalStrategy(synapSysMessage, localPort).post().convertToSynapSysMessage();
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }
}
