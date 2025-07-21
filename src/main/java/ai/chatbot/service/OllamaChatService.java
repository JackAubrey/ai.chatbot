package ai.chatbot.service;

import ai.chatbot.client.OllamaClient;
import ai.chatbot.dto.*;
import ai.chatbot.dto.ollama.OllamaModelTag;
import ai.chatbot.dto.ollama.OllamaRequest;
import ai.chatbot.dto.ollama.OllamaResponse;
import ai.chatbot.exception.ConfigurationException;
import org.jboss.logging.Logger;

import java.util.List;

class OllamaChatService implements ChatService {
    private static final Logger LOG = Logger.getLogger(OllamaChatService.class);

    private final OllamaClient ollamaClient;
    private final String model;

    public OllamaChatService(OllamaClient ollamaClient, String model) {
        LOG.debugf(" Ollama Chat Service Provider started");
        this.ollamaClient = ollamaClient;
        this.model = model;
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        LOG.debugf("Generating response using model: %s", model);
        LOG.debugf("Prompt: %s", request.prompt());

        List<String> installedModels = ollamaClient.getAvailableModels().models().stream()
                .map(OllamaModelTag::name)
                .toList();

        LOG.debugf("Model Names: %s", installedModels);

        boolean found = installedModels.stream()
                .anyMatch(t -> t.trim().equalsIgnoreCase(model) || t.trim().split(":")[0].equalsIgnoreCase(model));

        if (!found) {
            throw new ConfigurationException(
                    "Modello '" + model + "' non disponibile. Modelli installati: " +
                            String.join(", ", installedModels)
            );
        }

        OllamaRequest ollamaRequest = new OllamaRequest(model, request.prompt(), false);
        OllamaResponse ollamaResponse = ollamaClient.generate(ollamaRequest);

        LOG.debugf("Ollama response: %s", ollamaResponse.response());

        return new ChatResponse(ollamaResponse.response());
    }
}
