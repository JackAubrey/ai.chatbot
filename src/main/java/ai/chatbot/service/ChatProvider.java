package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, LANGCHAIN_LOCAL, PROMPT_INLINE_ROUTING, PROMPT_TEMPLATED_ROUTING, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "langchain_local" -> LANGCHAIN_LOCAL;
            case "prompt_inline_routing" -> PROMPT_INLINE_ROUTING;
            case "prompt_templated_routing" -> PROMPT_TEMPLATED_ROUTING;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
