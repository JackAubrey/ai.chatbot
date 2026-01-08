package ai.chatbot.resource;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;

import ai.chatbot.service.ChatService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("/chat")
public class ChatResource {
    private final ChatService chatService;

    public ChatResource(ChatService chatService) {
        this.chatService = chatService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ChatResponse chat(ChatRequest request) {
        return chatService.chat(request);
    }
}