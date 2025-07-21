package ai.chatbot.conf;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "chat")
public interface ChatConfig {

    @WithDefault("default")
    String provider();

    @WithDefault("llama3")
    String model();

    OllamaConfig ollama();

    LlamaStackConfig llamaStack();

    interface OllamaConfig {
        @WithDefault("http://localhost:11434")
        String baseUrl();
    }

    interface LlamaStackConfig {
        @WithDefault("http://localhost:37255")
        String baseUrl();
    }
}