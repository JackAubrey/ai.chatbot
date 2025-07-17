package ai.chatbot.service;

import ai.chatbot.client.OllamaClient;
import ai.chatbot.dto.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ChatService {
    private static final Logger LOG = Logger.getLogger(ChatService.class);

    private final OllamaClient ollamaClient;

    @ConfigProperty(name = "ollama.model", defaultValue = "llama3")
    String model;

    public ChatService(@RestClient OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

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
            throw new BadRequestException(
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
