package ai.chatbot.service;

import ai.chatbot.dto.ChatRequest;
import ai.chatbot.dto.ChatResponse;
import org.jboss.logging.Logger;

/**
 * Dynamic Strategy Pattern basato su contesto semantico, potenziato da un LLM dispatcher.
 * Questo pattern non ha un nome “canonico” ma può essere considerato un Prompt Routing Strategy,
 * una forma di semantic dispatching o anche una Multi-Agent Coordination Strategy se esteso
 */
class LangChainLocalRouterService implements ChatService {
    private static final Logger LOG = Logger.getLogger(LangChainLocalRouterService.class);

    private final LangChainLocalRouterModel routerModel;

    public LangChainLocalRouterService(
            LangChainLocalRouterModel routerModel
    ) {
        this.routerModel = routerModel;
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        String label = routerModel.getDispatcher().classifica(request.prompt()).trim().toUpperCase()
                .replaceAll("[^A-Z_]", ""); // rimuove caratteri non alfabetici o underscore
        LOG.debugf("Router Label Classification: %s", label);
        return switch (label) {
            case "TRADUZIONE" -> {
                LOG.debug("going to translate");
                yield new ChatResponse(routerModel.getTraduttore().traduci(request.prompt()));
            }
            case "CODICE_JAVA" -> {
                LOG.debug("going to produce source code");
                yield new ChatResponse(routerModel.getJavaDev().scriviCodice(request.prompt()));
            }
            case "UMORISMO" -> {
                LOG.debug("going to produce a joke");
                yield new ChatResponse(routerModel.getComico().raccontaBarzelletta(request.prompt()));
            }
            default -> {
                LOG.debug("going to produce a generic response");
                yield new ChatResponse(routerModel.getGenerale().rispondi(request.prompt()));
            }
        };
    }
}
