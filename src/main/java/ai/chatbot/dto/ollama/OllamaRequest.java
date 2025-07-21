package ai.chatbot.dto.ollama;

public record OllamaRequest(String model, String prompt, boolean stream) {
}
