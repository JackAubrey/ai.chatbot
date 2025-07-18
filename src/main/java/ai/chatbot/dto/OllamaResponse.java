package ai.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OllamaResponse(
        String model,
        @JsonProperty("created_at") String createdAt,
        String response) {
}
