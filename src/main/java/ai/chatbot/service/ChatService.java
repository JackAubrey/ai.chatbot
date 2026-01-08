package ai.chatbot.service;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;

public interface ChatService {
    ChatResponse chat(ChatRequest request);
}
