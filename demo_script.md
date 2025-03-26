
# FinTestGenAI Demo Script

This script guides you through a step-by-step demonstration of the FinTestGenAI system.

---

## Step 1: Setup

1. Export your OpenAI API key:

```bash
export OPENAI_API_KEY=your_api_key_here
```

2. Compile the project:

```bash
mvn clean install
```

---

## Step 2: Generate a Test Case

Run the test case generator to create a test case from a financial prompt.

```bash
java com.finai.generator.TestCaseGenerator
```

Expected Output:
```
Generated Test Case:
- Validate if customer with valid KYC and compliant SWIFT ISO message format is accepted for transaction processing.
- Assert: Payment is approved.
```

---

## Step 3: Trigger Context-Aware Test Generation

1. Modify the `sample_test_data.json` file with a new business rule or regulatory input.
2. Run the Context Agent:

```bash
java com.finai.agents.ContextAgent
```

Expected Output:
```
Context changed. Regenerating test case...
Generated Test Case:
...
```

---

## Step 4: Run Scenario Synthesizer

```bash
java com.finai.synthesizer.ScenarioSynthesizer
```

Expected Output:
```
Generated Scenario:
1. Onboard customer and validate KYC.
2. Evaluate credit score.
3. Initiate loan request.
...
```

---

## Step 5: Compliance Validation

```bash
java com.finai.validator.ComplianceValidator
```

Expected Output:
```
Compliance issues found:
- Missing AML validation.
```

---

## Step 6: Test Execution

```bash
java com.finai.executor.TestExecutor
```

Expected Output:
```
Executing test case...
Test Execution Result: PASS
```

---

## Summary

This demo showcases FinTestGenAI's ability to:
- Monitor system context
- Generate and update test cases using GenAI
- Synthesize real-world financial workflows
- Validate against compliance rules
- Execute and log test results
