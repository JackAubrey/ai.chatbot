package ai.chatbot.service.ai.prompting;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface AiChatModel {

    @SystemMessage("Sei un assistente AI educato e conciso. Rispondi sempre in italiano.")
    String chat(@UserMessage String prompt);
}

