
# FinTestGenAI

**Context-Aware Testing System for Financial Ecosystems**

---

## Overview

FinTestGenAI is a Java-based intelligent test automation system that uses Generative AI to dynamically create, update, and validate test cases for financial services such as payments, KYC, loan approvals, and fraud detection.

---

## Features

- Dynamic test case generation using OpenAI
- AI agent that tracks system context and regenerates test cases
- Multi-step scenario synthesis (e.g., KYC → Loan Approval)
- Compliance validation (KYC, AML, SOX)
- Test execution and result logging

---

## Project Structure

- `generator/TestCaseGenerator.java`: Generates test cases using prompts
- `agents/ContextAgent.java`: Triggers test generation on context change
- `synthesizer/ScenarioSynthesizer.java`: Creates end-to-end financial test flows
- `validator/ComplianceValidator.java`: Checks for compliance gaps
- `executor/TestExecutor.java`: Simulates test case execution

---

## Requirements

- Java 11+
- Maven
- OpenAI API Key

---

## Setup

1. Clone the repo and navigate to the project:
```bash
git clone https://github.com/your-org/FinTestGenAI.git
cd FinTestGenAI
```

2. Set your OpenAI API key:
```bash
export OPENAI_API_KEY=your_key_here
```

3. Build the project:
```bash
mvn clean install
```

4. Run any of the modules:
```bash
java com.finai.generator.TestCaseGenerator
java com.finai.agents.ContextAgent
```

---

## Example Use Case

Update `sample_test_data.json` to simulate a change in system configuration or regulatory input. The `ContextAgent` will detect the change and regenerate a relevant test case via OpenAI.

---

## License

MIT License
