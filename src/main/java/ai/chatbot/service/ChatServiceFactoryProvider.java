package ai.chatbot.service;

import ai.chatbot.client.LlamaStackApiClient;
import ai.chatbot.client.OllamaClient;
import ai.chatbot.conf.ChatConfig;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.jboss.logging.Logger;

@ApplicationScoped
public class ChatServiceFactoryProvider {
    private static final Logger LOG = Logger.getLogger(ChatServiceFactoryProvider.class);

    final OllamaClient ollamaClient;
    final LlamaStackApiClient llamaStackApiClient;
    final ChatConfig chatConfig;


    public ChatServiceFactoryProvider(
            @RestClient OllamaClient ollamaClient,
            @RestClient LlamaStackApiClient llamaStackApiClient,
            ChatConfig chatConfig) {
        this.ollamaClient = ollamaClient;
        this.llamaStackApiClient = llamaStackApiClient;
        this.chatConfig = chatConfig;
    }

    @Produces
    @ApplicationScoped
    public ChatService produceChatService() {
        ChatProvider providerEnum = ChatProvider.from(chatConfig.provider());

        ChatService cs =  switch (providerEnum) {
            case OLLAMA -> new OllamaChatService(ollamaClient, chatConfig.model());
            case LANGCHAIN_LOCAL -> new LangChainLocalChatService(chatConfig.model(), chatConfig.ollama().baseUrl());
            case LLAMASTACK_LOCAL -> new LlamaStackChatService(llamaStackApiClient, chatConfig.model());
            default -> {
                LOG.warn("Provider non riconosciuto. Uso DefaultChatService.");
                yield new DefaultChatService();
            }
        };

        LOG.debugf("Inizializzazione ChatService con provider: %s - %s", chatConfig.provider(), cs.getClass().getName());
        return cs;
    }

}
