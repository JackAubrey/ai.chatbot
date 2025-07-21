package ai.chatbot.service.ai.prompting;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface AssistantAiService {

    @SystemMessage("Sei un assistente AI educato e conciso. Rispondi sempre in italiano.")
    String rispondi(@UserMessage String prompt);
}
