
package com.finai.generator;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.List;

public class TestCaseGenerator {

    private final OpenAiService service;

    public TestCaseGenerator(String apiKey) {
        this.service = new OpenAiService(apiKey);
    }

    public String generateTestCase(String prompt) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .maxTokens(500)
                .temperature(0.7)
                .build();

        return service.createCompletion(completionRequest)
                .getChoices()
                .get(0)
                .getText()
                .trim();
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        TestCaseGenerator generator = new TestCaseGenerator(apiKey);
        String prompt = "Generate a test case for validating SWIFT ISO change in payment payload with KYC impact.";
        String result = generator.generateTestCase(prompt);
        System.out.println("Generated Test Case:\n" + result);
    }
}
