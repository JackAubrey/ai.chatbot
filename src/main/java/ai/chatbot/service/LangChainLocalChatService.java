package ai.chatbot.service;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.jboss.logging.Logger;

class LangChainLocalChatService implements ChatService {

    private static final Logger LOG = Logger.getLogger(LangChainLocalChatService.class);

    private final AiChatModel chatModel;

    interface AiChatModel {
        String chat(String userMessage);
    }

    public LangChainLocalChatService(String model, String baseUrl) {
        LOG.debugf("LangChain4J using Ollama with model: %s at baseUrl: %s", model, baseUrl);

        var llm = OllamaChatModel.builder()
                .baseUrl(baseUrl)
                .modelName(model)
                .build();

        this.chatModel = AiServices.builder(AiChatModel.class)
                .chatModel(llm)
                .build();
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        String reply = chatModel.chat(request.prompt());
        LOG.debugf("LangChain4J response: %s", reply);
        return new ChatResponse(reply);
    }
}
