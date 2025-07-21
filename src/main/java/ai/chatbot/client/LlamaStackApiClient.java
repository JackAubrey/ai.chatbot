package ai.chatbot.client;

import ai.chatbot.dto.llama_stack.LlamaStackRequest;
import ai.chatbot.dto.llama_stack.LlamaStackResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Client REST per comunicare con LlamaStack.
 */
@RegisterRestClient(configKey = "llamastack-api")
public interface LlamaStackApiClient {

    /**
     * Invoca /v1/openai/v1/chat/completions per ottenere una risposta dal modello LLM.
     *
     * @param request Oggetto contenente il prompt e il nome del modello.
     * @return Risposta generata dal modello.
     */
    @POST
    @Path("/v1/openai/v1/chat/completions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    LlamaStackResponse chat(LlamaStackRequest request);
}
