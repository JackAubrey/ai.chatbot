package ai.chatbot.client;

import ai.chatbot.dto.ollama.OllamaRequest;
import ai.chatbot.dto.ollama.OllamaResponse;
import ai.chatbot.dto.ollama.OllamaTagsResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
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
