package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, LANGCHAIN_LOCAL, PROMPT_ROUTING_INLINE, PROMPT_ROUTING_TEMPLATED, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "prompt_routing_inline" -> PROMPT_ROUTING_INLINE;
            case "prompt_routing_templated" -> PROMPT_ROUTING_TEMPLATED;
            case "langchain_local" -> LANGCHAIN_LOCAL;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
