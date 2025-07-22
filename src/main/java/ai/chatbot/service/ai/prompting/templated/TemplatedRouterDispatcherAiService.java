package ai.chatbot.service.ai.prompting.templated;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

/**
 * <p>Questo templating, usa il few-shot prompting</p>
 * Nel contesto del prompting per LLM (Large Language Models)
 * significa fornire uno o più esempi espliciti su come la IA dovrebbe comportarsi.
 * <p>Tipi di prompting supportati:</p>
 *
 * <ul>
 *   <li><b>Zero-shot</b>: Dai solo un'istruzione. Nessun esempio fornito.</li>
 *   <li><b>One-shot</b>: Dai <em>un solo esempio</em> di input e output.</li>
 *   <li><b>Few-shot</b>: Dai <em>più esempi</em> (tipicamente 2–5), per chiarire cosa fare.</li>
 * </ul>
 *
 */
@RegisterAiService
public interface TemplatedRouterDispatcherAiService {
    @SystemMessage("ai/chatbot/templates/router-dispatcher-template.tmpl")
    String classifica(@UserMessage String richiesta);
}
