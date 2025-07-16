package ai.chatbot.client;

import ai.chatbot.dto.OllamaRequest;
import ai.chatbot.dto.OllamaResponse;
import ai.chatbot.dto.OllamaTagsResponse;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Client REST per comunicare con Ollama in locale.
 */
@Path("/api")
@RegisterRestClient(configKey = "ollama-api")
public interface OllamaClient {


    /**
     * Invoca /api/generate per ottenere una risposta dal modello LLM.
     *
     * @param request Oggetto contenente il prompt e il nome del modello.
     * @return Risposta generata dal modello.
     */
    @POST
    @Path("/generate")
    @Produces("application/json")
    @Consumes("application/json")
    OllamaResponse generate(OllamaRequest request);

    /**
     * Invoca /api/tags per ottenere la lista dei modelli installati in Ollama.
     *
     * @return ritorna una lista di modelli installati localmente.
     */
    @GET
    @Path("/tags")
    @Produces("application/json")
    OllamaTagsResponse getAvailableModels();
}
