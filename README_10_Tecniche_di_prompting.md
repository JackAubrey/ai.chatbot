Applicate a questa classe possiamo vedere in azione alcun delle tecniche di prompting.
[LangChainRouterDispatcherService](src/main/java/ai/chatbot/service/LangChainRouterDispatcherService.java)


# Tecniche di Prompting usate

## 1. Instruction Prompting (o Zero-shot)

Dai istruzioni dirette al modello su cosa fare, senza necessariamente fornire esempi.

**Dove lo stai usando:**
```
Il tuo compito è classificare la richiesta dell'utente in una delle seguenti categorie...
Devi rispondere ESCLUSIVAMENTE con una sola parola
Non generare testo aggiuntivo, non spiegare nulla...
```

Queste frasi danno al modello un compito chiaro e vincolato, quindi è Instruction Prompting puro.

---

## 2. Few-shot Prompting

Dai più esempi di input/output per chiarire come il modello dovrebbe comportarsi.

**Dove lo stai usando:**
```
Esempi:

Utente: "Qual è la capitale della Francia?"
Risposta: GENERALE

Utente: "Traduci: buongiorno a tutti"
Risposta: TRADUZIONE

Utente: "Come funziona l'injection in Spring?"
Risposta: CODICE_JAVA

Utente: "Fammi una battuta su un programmatore pigro"
Risposta: UMORISMO
```

Qui stai dicendo: “ecco 4 esempi di cosa intendo”. Questo aiuta il modello a imparare il pattern di classificazione anche per input ambigui.

---

## 3. Constrained Output Prompting

Dai istruzioni molto specifiche sul formato della risposta e cosa non fare.

**Dove lo stai usando:**
```
Devi rispondere ESCLUSIVAMENTE con una sola parola, tra: GENERALE, TRADUZIONE, ...
Non generare testo aggiuntivo, non spiegare nulla, non commentare.
Rispondi solo con la parola chiave.
```

Questo è fondamentale per evitare risposte verbose. È una tecnica importante quando vuoi usare il risultato come “etichetta”, come nel tuo caso.

---

# Sintesi

| Tecnica               | Dove la usi                                                   |
|-----------------------|---------------------------------------------------------------|
| Instruction Prompting | Descrizione iniziale del compito                              |
| Few-shot Prompting    | Sezione con gli esempi Utente/Risposta                        |
| Constrained Output    | Specifica sul formato della risposta (solo una parola chiave) |
