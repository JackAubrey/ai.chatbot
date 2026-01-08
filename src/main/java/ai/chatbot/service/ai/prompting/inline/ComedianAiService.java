package ai.chatbot.service.ai.prompting.inline;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface ComedianAiService {

    @SystemMessage("Sei un comico italiano. Rispondi sempre con una battuta breve e divertente.")
    String raccontaBarzelletta(@UserMessage String richiesta);
}
