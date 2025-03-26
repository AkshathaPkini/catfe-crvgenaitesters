
package com.finai.synthesizer;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ScenarioSynthesizer {

    private final OpenAiService service;

    public ScenarioSynthesizer(String apiKey) {
        this.service = new OpenAiService(apiKey);
    }

    public String synthesizeScenario(String flowDescription) {
        String prompt = "Create a multi-step test scenario for the following financial process: " + flowDescription +
                        ". Include validations for KYC, credit score, loan approval rules, and fraud detection.";

        CompletionRequest request = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .maxTokens(700)
                .temperature(0.6)
                .build();

        return service.createCompletion(request)
                .getChoices()
                .get(0)
                .getText()
                .trim();
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        ScenarioSynthesizer synthesizer = new ScenarioSynthesizer(apiKey);
        String flow = "Customer onboarding -> KYC -> Loan Application -> Risk Scoring -> Approval -> Disbursement";
        String scenario = synthesizer.synthesizeScenario(flow);
        System.out.println("Generated Scenario:\n" + scenario);
    }
}
