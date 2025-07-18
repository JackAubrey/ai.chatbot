🧩 1. MCP: Multi-Component Prompt
✅ Cos'è un MCP (Multi-Component Prompt)?

Un MCP è una tecnica di prompt engineering in cui costruiamo un prompt composto da più parti strutturate, ciascuna con uno scopo chiaro.

✍️ Esempio:

Immagina questo prompt:

> [system]  
> Sei un assistente esperto in contratti legali.
>
> [context]  
> Ecco il contenuto del contratto PDF:  
> "Lorem ipsum dolor sit amet..."
>
> [question]  
> Quali sono le clausole di risoluzione anticipate?
>
> [instruction]  
> Rispondi in modo sintetico ed elenca i riferimenti legali.

### 👉 Questo è un MCP, perché ha più componenti ben separati:
- system message
- context
- domanda
- istruzione

È molto utile in sistemi RAG o agenti AI, perché aiuta a guidare meglio il modello.

---

🔍 2. RAG: Retrieval-Augmented Generation  
✅ Cos'è un RAG?

RAG è un'architettura AI dove:

- Ricevi una domanda
- Fai una ricerca intelligente (retrieval) in una knowledge base (testi, PDF, DB, ecc.)
- Usi quei documenti trovati per comporre un prompt
- Dai il prompt a un LLM (es. phi3) che genera la risposta finale

🔁 Pipeline di un RAG:

Utente → Domanda  
      ↓  
Motore di ricerca semantico (es. Chroma, Weaviate)  
      ↓  
Documenti rilevanti (retrieved context)  
      ↓  
MCP (prompt strutturato)  
      ↓  
LLM (via Ollama, OpenAI, ecc.)  
      ↓  
Risposta

---

🧠 Differenza chiave

| Concetto | Tipo              | Funzione                                | Esempio              |
|----------|-------------------|-----------------------------------------|----------------------|
| **MCP**  | Tecnica di prompt | Organizzare l'input per l'LLM           | Prompt multi-sezione |
| **RAG**  | Architettura      | Recuperare info prima della generazione | Chatbot su PDF o DB  |

---

🧠 Un’analogia

- 🔍 RAG è come un giornalista che cerca fonti prima di scrivere un articolo
- 🗂️ MCP è come la struttura dell’articolo (titolo, corpo, citazioni, ecc.)

✅ Come si usano insieme?

In una pipeline RAG moderna, tu:

- recuperi documenti (RAG)
- componi il prompt con MCP
- lo dai al LLM via Ollama o API
