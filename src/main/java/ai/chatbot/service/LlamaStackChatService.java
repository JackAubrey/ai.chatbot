package ai.chatbot.service;

import ai.chatbot.client.LlamaStackApiClient;
import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;
import ai.chatbot.dto.llama_stack.LlamaStackRequest;
import ai.chatbot.dto.llama_stack.LlamaStackResponse;
import org.jboss.logging.Logger;

class LlamaStackChatService implements ChatService {

    private static final Logger LOG = Logger.getLogger(LlamaStackChatService.class);
    private static final String FORCED_MODEL = "OpenVINO/mistral-7B-instruct-v0.2-int4-ov";

    private final LlamaStackApiClient llamaStackApiClient;
    private final String model;

    public LlamaStackChatService(LlamaStackApiClient llamaStackApiClient, String model) {
        this.llamaStackApiClient = llamaStackApiClient;

        if (!FORCED_MODEL.equalsIgnoreCase(model)) {
            LOG.warnf("Il modello '%s' è stato ignorato. Verrà usato 'mistral' (OpenVINO preset).", FORCED_MODEL);
            this.model = FORCED_MODEL;
        } else {
            this.model = model;
        }
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        LOG.debugf("Generating response using model: %s", model);
        LOG.debugf("Prompt: %s", request.prompt());

        LlamaStackRequest llamaRequest = new LlamaStackRequest(model, request.prompt(), false);
        LlamaStackResponse llamaResponse = llamaStackApiClient.chat(llamaRequest);

        LOG.debugf("LlamaStack response: %s", llamaResponse.response());

        return new ChatResponse(llamaResponse.response());
    }
}