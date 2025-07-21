package ai.chatbot.dto.llama_stack;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LlamaStackResponse(
        @JsonProperty("response") String response
) {}