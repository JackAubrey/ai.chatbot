package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, LANGCHAIN_LOCAL, LLAMASTACK_LOCAL, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "langchain_local" -> LANGCHAIN_LOCAL;
            case "llamastack_local" -> LLAMASTACK_LOCAL;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
