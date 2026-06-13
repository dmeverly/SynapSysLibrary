package util;

public enum settings {
    TIMEOUT(10),
    GEMINI_ROOT_URL("https://generativelanguage.googleapis.com/v1beta/models/"),
    OLLAMA_URL("http://localhost");

    private final int value;
    private final String stringValue;

    settings(int value) {
        this.value = value;
        this.stringValue = null;
    }

    settings(String stringValue) {
        this.value = 0;
        this.stringValue = stringValue;
    }

    public int getValue() {
        return value;
    }

    public String getStringValue() {
        return stringValue;
    }
}