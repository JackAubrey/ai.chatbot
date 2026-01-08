package ai.chatbot.service;


import ai.chatbot.service.ai.prompting.inline.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PromptInlineRouterModel {
    private final RouterDispatcherAiService dispatcher;
    private final AssistantAiService generale;
    private final TranslatorAiService traduttore;
    private final JavaDevAiService javaDev;
    private final ComedianAiService comico;

    public PromptInlineRouterModel(
            RouterDispatcherAiService dispatcher,
            AssistantAiService generale,
            TranslatorAiService traduttore,
            JavaDevAiService javaDev,
            ComedianAiService comico
    ) {
        this.dispatcher = dispatcher;
        this.generale = generale;
        this.traduttore = traduttore;
        this.javaDev = javaDev;
        this.comico = comico;
    }

    public RouterDispatcherAiService getDispatcher() {
        return dispatcher;
    }

    public AssistantAiService getGenerale() {
        return generale;
    }

    public TranslatorAiService getTraduttore() {
        return traduttore;
    }

    public JavaDevAiService getJavaDev() {
        return javaDev;
    }

    public ComedianAiService getComico() {
        return comico;
    }
}
