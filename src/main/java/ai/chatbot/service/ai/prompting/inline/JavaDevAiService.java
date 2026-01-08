package ai.chatbot.service.ai.prompting.inline;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface JavaDevAiService {

    @SystemMessage("Sei un programmatore esperto in Java e Spring Boot e Quarkus. Rispondi solo con codice valido e commentato.")
    String scriviCodice(@UserMessage String richiesta);
}
