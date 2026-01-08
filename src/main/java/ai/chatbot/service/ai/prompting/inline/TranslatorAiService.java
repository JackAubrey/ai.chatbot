package ai.chatbot.service.ai.prompting.inline;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TranslatorAiService {

    @SystemMessage("Sei un traduttore esperto. Traduci sempre il testo che ricevi in inglese, senza commenti.")
    String traduci(@UserMessage String testoItaliano);
}