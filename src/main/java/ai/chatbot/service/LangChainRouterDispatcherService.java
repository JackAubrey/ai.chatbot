package ai.chatbot.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface LangChainRouterDispatcherService {
    @SystemMessage("""
        Il tuo compito è identificare il contesto della richiesta dell'utente.
        Rispondi solo con una di queste etichette, esattamente così:
        - GENERALE
        - TRADUZIONE
        - CODICE_JAVA
        - UMORISMO
        Non aggiungere nulla, solo la parola chiave.
    """)
    String classifica(@UserMessage String richiesta);
}
