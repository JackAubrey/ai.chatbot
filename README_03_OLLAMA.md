# 🧠 Cos'è Ollama?

**Ollama** è uno strumento che ti permette di eseguire modelli di intelligenza artificiale (**LLM**) localmente sul tuo PC, **senza bisogno di connessioni cloud** (come OpenAI o Hugging Face).  
È una specie di **“Docker per LLM”**: ti scarica i modelli già ottimizzati, li esegue e li espone tramite una **API HTTP REST** sulla porta `11434`.

---

## ⚙️ Cosa fa Ollama?

- Scarica un modello LLM ottimizzato per il tuo sistema  
  👉 `ollama pull nome-modello`

- Lo esegue e lo tiene in RAM  
  👉 `ollama run nome-modello`

- Espone una API REST  
  👉 `POST http://localhost:11434/api/generate`

- Gestisce l'inferenza completamente in **locale**, sfruttando **CPU e/o GPU**

---

## ✅ Vantaggi

- 🔐 Nessun bisogno di cloud o credenziali API
- ⚡ Ottimo per **prototipi**, **chatbot**, **microservizi** e **progetti embedded**
- 🧰 Facile da usare da riga di comando, browser o via codice

---

# 🤖 Cos'è un modello (tipo `llama3`, `mistral`, `phi`)?

Sono **modelli di linguaggio open-source**, ovvero **grandi reti neurali** addestrate a comprendere e generare testo in linguaggio naturale.  
Ollama ti permette di **eseguirli in locale**.

---

## 🔷 `llama3` (by Meta)

- Creato da **Meta (Facebook)**
- Ultima versione: **LLaMA 3 8B / 70B** (rilasciata nel 2024)
- Molto potente, **competitivo con GPT-3.5**
- **Supportato direttamente** da Ollama con ottimizzazioni

---

## 🔶 `mistral`

- Creato da **Mistral.ai**, una startup europea
- Versione piccola: **Mistral 7B**, molto efficiente
- Ottimo compromesso tra **velocità e accuratezza**
- Spesso usato in **applicazioni real-time**

---

## 🟦 `phi` (es. `phi3`)

- Creato da **Microsoft**
- Più leggero, progettato anche per dispositivi **mobili o embedded**
- Ottimo per **progetti a basso consumo**

---

# 🎓 In sintesi

| Strumento                | Cosa fa                                                                                             |
|--------------------------|-----------------------------------------------------------------------------------------------------|
| **Ollama**               | Avvia un **"server" AI locale**, che esegue modelli                                                 |
| **llama3, mistral, phi** | Sono i **modelli AI veri e propri**, cioè "cervelli" addestrati a rispondere al linguaggio naturale |
| **Quarkus / Java**       | Il tuo **codice applicativo**, che si collega all’API REST di Ollama per ottenere risposte          |

---
