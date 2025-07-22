package ai.chatbot.service.ai.prompting.templated;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TemplatedTranslatorAiService {

    @SystemMessage("ai/chatbot/templates/translator-template.tmpl")
    String traduci(@UserMessage String testoItaliano);
}