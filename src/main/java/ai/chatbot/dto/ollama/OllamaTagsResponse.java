package ai.chatbot.dto.ollama;

import java.util.List;

public record OllamaTagsResponse(List<OllamaModelTag> models) {
}