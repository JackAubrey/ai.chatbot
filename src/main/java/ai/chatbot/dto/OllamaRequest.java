package ai.chatbot.dto;

public class OllamaRequest {
    public String model;
    public String prompt;
    public boolean stream;

    public OllamaRequest() {
    }

    public OllamaRequest(String model, String prompt, boolean stream) {
        this.model = model;
        this.prompt = prompt;
        this.stream = stream;
    }
}
