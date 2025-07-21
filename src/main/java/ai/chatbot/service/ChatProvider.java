package ai.chatbot.service;

public enum ChatProvider {
    OLLAMA, LANGCHAIN_LOCAL, PROMPT_ROUTING_LANGCHAIN_LOCAL, DEFAULT;

    public static ChatProvider from(String value) {
        return switch (value.toLowerCase()) {
            case "ollama" -> OLLAMA;
            case "prompt_routing_langchain_local" -> PROMPT_ROUTING_LANGCHAIN_LOCAL;
            case "langchain_local" -> LANGCHAIN_LOCAL;
            case "default", "" -> DEFAULT;
            default -> DEFAULT; // fallback sicuro
        };
    }
}
