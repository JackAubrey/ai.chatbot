package ai.chatbot.service.ai.prompting.templated;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TemplatedComedianAiService {

    @SystemMessage("ai/chatbot/templates/comedian-template.tmpl")
    String raccontaBarzelletta(@UserMessage String richiesta);
}
