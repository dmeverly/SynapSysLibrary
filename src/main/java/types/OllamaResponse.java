package types;

import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OllamaResponse implements ProviderResponse {
    private static final Pattern JSON_STRING_PATTERN = Pattern
            .compile("\\\"response\\\"\\s*:\\s*\\\"((?:\\\\.|[^\\\"\\\\])*)\\\"");

    private final HttpResponse<String> response;

    public OllamaResponse(HttpResponse<String> response) {
        this.response = response;
    }

    @Override
    public SynapSysMessage convertToSynapSysMessage() {
        if (response == null) {
            return new SynapSysMessage("ollama", "", "Error: No response received from Ollama API.");
        }

        String responseBody = response.body();
        if (responseBody == null || responseBody.isBlank()) {
            return new SynapSysMessage("ollama", "", "");
        }

        StringBuilder responseBuilder = new StringBuilder();
        String[] lines = responseBody.split("\\R");
        for (String line : lines) {
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) {
                continue;
            }

            if (trimmedLine.startsWith("data:")) {
                trimmedLine = trimmedLine.substring(5).trim();
            }

            Matcher matcher = JSON_STRING_PATTERN.matcher(trimmedLine);
            if (matcher.find()) {
                responseBuilder.append(unescapeJson(matcher.group(1)));
            } else if (trimmedLine.startsWith("{") && trimmedLine.endsWith("}")) {
                responseBuilder.append(trimmedLine);
            }
        }

        String extractedText = responseBuilder.toString().trim();
        if (extractedText.isEmpty()) {
            return new SynapSysMessage("ollama", "", responseBody.trim());
        }

        return new SynapSysMessage("ollama", "", extractedText);
    }

    private String unescapeJson(String value) {
        return value.replace("\\\"", "\"")
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
                .replace("\\\\", "\\");
    }
}