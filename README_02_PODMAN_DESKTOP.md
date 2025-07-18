# 🧠 Quando usare Podman Desktop con AI Lab

Podman Desktop con l’estensione **AI Lab** è uno strumento potente per sviluppatori che lavorano con modelli LLM in locale. Ecco **quando e perché** conviene usarlo durante lo sviluppo con Quarkus, LangChain4J e Ollama.

---

## ✅ Quando ti conviene usarlo

### 1. Gestione semplice di più modelli LLM

Podman Desktop + AI Lab ti consente di:

- Avviare/stoppare modelli (es. `llama3`, `mistral`, `deepseek-coder`) come container
- Vedere i modelli attivi con interfaccia grafica
- Testare prompt direttamente da AI Lab

> **Esempio**: vuoi confrontare `llama3` e `mistral` su uno stesso prompt.

---

### 2. Sperimentazione di Tooling, Guardrails e RAG

AI Lab offre funzionalità avanzate:

- **Tooling** AI con supporto JSON Schema (tipo "plugin")
- **Guardrails** per validare prompt e filtrare contenuti
- **RAG locale** con upload di documenti ed embedding
- **Pipeline AI** modulari (MCP - Multi Component Pipeline)

> **Esempio**: vuoi indicizzare un PDF e fare domande sui suoi contenuti.

---

### 3. Esposizione REST/GRPC dei modelli

AI Lab permette di esporre i modelli AI come:

- API REST o GRPC locali
- Servizi accessibili da Quarkus tramite `@RestClient`

> **Esempio**: vuoi cambiare modello a runtime senza dover rifare il deploy.

---

### 4. Ottimizzazione delle pipeline AI senza modificare Java

Vuoi testare rapidamente:

- Prompt complessi
- Combinazioni di modelli e strumenti
- Strategie di validazione

... Senza dover ricompilare o rilanciare l'app Java.

> **Esempio**: provi una chain-of-thought + RAG in AI Lab, poi la porti in LangChain4J.

---

## 🧭 In sintesi

| Situazione                              | Usare AI Lab? |
|-----------------------------------------|:-------------:|
| Sperimentare nuovi modelli              |       ✅       |
| Lavorare con RAG (PDF, Markdown) locali |       ✅       |
| Testare tool AI modulari                |       ✅       |
| Debug visuale dei prompt/risposte       |       ✅       |
| Orchestrare componenti AI               |       ✅       |
| Deploy Java con GraalVM (solo codice)   |       ❌       |

---

## 🔄 Esempio d’uso consigliato

1. Carichi un PDF in AI Lab e generi lo embedding
2. Testi il comportamento tramite interfaccia
3. Una volta validato, **trasferisci la logica in Quarkus** usando LangChain4J:
    - Retriever
    - PromptTemplate
    - Pipeline
    - Tool/Guardrail se necessario

---

## 💡 Conclusione

Podman Desktop + AI Lab è **una sandbox visiva potente** per validare tutto ciò che poi verrà integrato in Java, riducendo errori e velocizzando lo sviluppo.
