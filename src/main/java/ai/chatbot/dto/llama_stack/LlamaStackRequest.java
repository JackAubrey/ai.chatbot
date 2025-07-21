package ai.chatbot.dto.llama_stack;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LlamaStackRequest(
        @JsonProperty("model") String model,
        @JsonProperty("prompt") String prompt,
        @JsonProperty("stream") boolean stream
) {}
