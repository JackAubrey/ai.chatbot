package ai.chatbot.web;

import ai.chatbot.exception.ConfigurationException;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return resolveError(e);
    }

    private Response resolveError(Exception ex) {
        // ConfigurationException
        return switch(ex) {
            case BadRequestException e -> buildResponse(Response.Status.BAD_REQUEST, e.getMessage());
            case ConfigurationException e -> buildResponse(Response.Status.INTERNAL_SERVER_ERROR, "Errore di configurazione: " + e.getMessage());
            default -> buildResponse(Response.Status.INTERNAL_SERVER_ERROR, "Internal error: " + ex.getMessage());
        };
    }

    private Response buildResponse(Response.Status status, String error) {
        return Response.status(status)
                .entity(new ErrorDTO(error))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    public record ErrorDTO(String error) {}
}
