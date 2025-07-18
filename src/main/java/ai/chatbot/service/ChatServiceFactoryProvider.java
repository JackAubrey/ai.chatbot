package ai.chatbot.service;

import ai.chatbot.client.OllamaClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.jboss.logging.Logger;

@ApplicationScoped
public class ChatServiceFactoryProvider {
    private static final Logger LOG = Logger.getLogger(ChatServiceFactoryProvider.class);

    final OllamaClient ollamaClient;
    final String model;
    final String baseUrl;
    final String provider;


    public ChatServiceFactoryProvider(
            @RestClient OllamaClient ollamaClient,
            @ConfigProperty(name = "ollama.model", defaultValue = "llama3") String model,
            @ConfigProperty(name = "ollama.base-url", defaultValue = "http://localhost:11434") String baseUrl,
            @ConfigProperty(name = "chat.provider", defaultValue = "default") String provider) {
        this.ollamaClient = ollamaClient;
        this.model = model;
        this.baseUrl = baseUrl;
        this.provider = provider;
    }

    @Produces
    @ApplicationScoped
    public ChatService produceChatService() {
        ChatProvider providerEnum = ChatProvider.from(provider);

        ChatService cs =  switch (providerEnum) {
            case OLLAMA -> new OllamaChatService(ollamaClient, model);
            case LANGCHAIN_LOCAL -> new LangChainLocalChatService(model, baseUrl);
            default -> {
                LOG.warn("Provider non riconosciuto. Uso DefaultChatService.");
                yield new DefaultChatService();
            }
        };

        LOG.debugf("Inizializzazione ChatService con provider: %s - %s", provider, cs.getClass().getName());
        return cs;
    }

}
