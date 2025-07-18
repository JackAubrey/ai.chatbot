package ai.chatbot.service;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;
import ai.chatbot.exception.ConfigurationException;

class DefaultChatService implements ChatService {
    @Override
    public ChatResponse chat(ChatRequest request) {
        throw new ConfigurationException("Nessun provider valido configurato. Imposta 'chat.provider' in application.properties.");
    }
}