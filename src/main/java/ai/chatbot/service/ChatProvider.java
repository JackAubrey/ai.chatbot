package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, LANGCHAIN_LOCAL, PROMPT_INLINE_ROUTING, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "prompt_inline_routing" -> PROMPT_INLINE_ROUTING;
            case "langchain_local" -> LANGCHAIN_LOCAL;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
