package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
