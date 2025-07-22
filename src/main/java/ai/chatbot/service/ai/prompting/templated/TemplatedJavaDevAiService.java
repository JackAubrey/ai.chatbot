package ai.chatbot.service.ai.prompting.templated;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TemplatedJavaDevAiService {

    @SystemMessage("ai/chatbot/templates/java-dev-template.tmpl")
    String scriviCodice(@UserMessage String richiesta);
}
