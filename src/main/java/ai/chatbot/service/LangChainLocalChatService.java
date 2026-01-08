package ai.chatbot.service;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;
import ai.chatbot.service.ai.prompting.inline.AssistantAiService;
import org.jboss.logging.Logger;

class LangChainLocalChatService implements ChatService {

    private static final Logger LOG = Logger.getLogger(LangChainLocalChatService.class);

    private final AssistantAiService chatModel;

    public LangChainLocalChatService(AssistantAiService chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        String reply = chatModel.chat(request.prompt());
        LOG.debugf("LangChain4J response: %s", reply);
        return new ChatResponse(reply);
    }
}
