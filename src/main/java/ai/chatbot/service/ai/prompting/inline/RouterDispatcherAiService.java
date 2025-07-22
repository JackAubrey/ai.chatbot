package ai.chatbot.service.ai.prompting.inline;

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
public interface RouterDispatcherAiService {
    @SystemMessage("""
        Il tuo compito è classificare la richiesta dell'utente in una delle seguenti categorie:

        GENERALE     - domande informative o conversazioni
        TRADUZIONE   - richieste di traduzione
        CODICE_JAVA  - richieste di codice o spiegazioni su Java
        UMORISMO     - richieste di battute o contenuti divertenti

        Devi rispondere ESCLUSIVAMENTE con **una sola parola**, tra:
        GENERALE, TRADUZIONE, CODICE_JAVA, UMORISMO

        Non generare testo aggiuntivo, non spiegare nulla, non commentare.
        Rispondi solo con la parola chiave.

        Esempi:

        Utente: "Qual è la capitale della Francia?"
        Risposta: GENERALE

        Utente: "Traduci: buongiorno a tutti"
        Risposta: TRADUZIONE

        Utente: "Come funziona l'injection in Spring?"
        Risposta: CODICE_JAVA

        Utente: "Fammi una battuta su un programmatore pigro"
        Risposta: UMORISMO
    """)
    String classifica(@UserMessage String richiesta);
}
