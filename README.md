<p align="center">
  <img src="src/main/resources/emblem-mono-light.png" width="84" alt="" />
</p>

# SynapSys SDK

**Author**: David Everly  
**Language**: Java
**Status**: Active development  
Copyright © 2025 David Everly

Based on SynapSys, a broker-style orchestration framework I created in 2025, the SynapSys SDK is a reimagining of the concept.  Instead of server-side orchestration, which adds overhead cost, compute, maintenance and additional security concerns, this SDK-style library enables an application to interact with supported foundation model LLMs using a common API.  This abstracts away the differences between foundation model provider APIs, reducing friction and cognitive burden of switching between model providers.

---

## Purpose

SynapSys SDK exists to reduce the need to memorize and keep up-to-date with foundation model provider API changes over time.  Instead of using their API directly, the SDK's generate() function takes your desired provider,model combination and forms the request to meet the requirements of the provider's API automatically.

---

## Security Model

The SynapSys SDK delegates most security, including handling of API keys, back to the user application.  The SDK does not store user information or keys and does not employ pre- post- flight guard pipelines.

---

## What This Is

SynapSys SDK provides:

* A **simple** API suitable for deploying multiple agents in tandem

This is infrastructure for **rapid LLM deployment** to support multi-agent systems

---

## What This Is Not

SynapSys SDK does **not** provide:

* security protocols or input validation - these concerns are delegated to the user application

---

## Developer & Deployment Notes

### Configuration & Secrets

Secrets are supplied via environment variables (recommended injection at runtime).

Key mappings:

* GEMINI_API_KEY=KEY
* OPENAI_API_KEY=KEY
* OLLAMA_LOCAL_API_KEY=KEY (unused)

No secrets are committed to this repository.

---

### Local Development

#### Prerequisites

* Java 25
* Maven

Setup:

* load .env variables to inject at runtime

#### Build

```
mvn compile
```

#### Test

```
set -euo pipefail

exec "$(dirname "$0")/scripts/run-testapp.sh"
```

---

## License

This project is licensed under the **Apache License 2.0**.

You are free to use, modify, and distribute this software, including for
commercial purposes, subject to the terms of the license.

Private guard logic, policies, and runtime configurations are not included
in this repository and are not covered by this license.