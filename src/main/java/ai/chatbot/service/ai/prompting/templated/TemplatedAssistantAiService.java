package ai.chatbot.service.ai.prompting.templated;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TemplatedAssistantAiService {

    @SystemMessage("ai/chatbot/templates/assistant-template.tmpl")
    String chat(@UserMessage String prompt);
}
