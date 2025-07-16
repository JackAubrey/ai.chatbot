package ai.chatbot.dto;

public class ChatResponse {
    public String response;

    public ChatResponse() {
        // richiesto da framework/reflection
    }

    public ChatResponse(String response) {
        this.response = response;
    }
}
