## PODMAN
- install > sudo dnf install -y podman
- verify > podman --version

## PODMAN DESKTOP
- optional if flatpak is not installed > sudo dnf install -y flatpak
- add flatpack repo > flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo
- install > flatpak install flathub io.podman_desktop.PodmanDesktop

# OLLAM
- download> wget https://github.com/ollama/ollama/releases/download/v0.9.6/ollama-linux-amd64.tgz
- prepare
    * mkdir ollama-setup
    * mv ollama-linux-amd64.tgz ollama-setup/
    * cd ollama-setup
    * tar -xzf ollama-linux-amd64.tar.gz
- install
    * sudo cp bin/ollama /usr/local/bin/
    * sudo chmod +x /usr/local/bin/ollama
- verify > ollama --version
- clean
    * cd ..
    * rm -rf ollama-setup
- pull models (ex llama3, mistral, deepseek-coder, deepseek-llm)
    * ollama pull <nome-model>
- start and stop a models in background
    * ollama run <model-name> $
    * ollama stop <model-name>
- check running model
    * ollama ps
- verify ollama local. Before execute the secondo curl we must run models using "ollama run <model-name> $"
    * curl http://localhost:11434/api/tags
    * curl http://localhost:11434/api/models
- verify ollama directly
    * ollama run mistral --prompt "Scrivi una funzione Java che calcoli il fattoriale"
- verify ollama via curl
    * curl http://localhost:11434/api/generate \
      -H "Content-Type: application/json" \
      -d '{"model": "llama3", "prompt": "Qual è la capitale della Francia?", "stream": false}'

# QUARKUS CLI
## SDKMAN if not yet installed
- curl -s "https://get.sdkman.io" | bash
- source "$HOME/.sdkman/bin/sdkman-init.sh"

## QUARKUS CLI via SDKMAN
- sdk install quarkus
- sdk install jbang
- quarkus --version
- jbang version

