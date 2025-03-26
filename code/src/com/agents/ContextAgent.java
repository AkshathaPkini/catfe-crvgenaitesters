
package com.finai.agents;

import com.finai.generator.TestCaseGenerator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ContextAgent {

    private String lastKnownContext = "";

    public boolean hasContextChanged(String contextFilePath) {
        try {
            String currentContext = new String(Files.readAllBytes(Paths.get(contextFilePath)));
            if (!Objects.equals(currentContext, lastKnownContext)) {
                lastKnownContext = currentContext;
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error reading context file: " + e.getMessage());
        }
        return false;
    }

    public void handleContextChange(String contextFilePath, TestCaseGenerator generator) {
        if (hasContextChanged(contextFilePath)) {
            System.out.println("Context changed. Regenerating test case...");
            String prompt = "Generate test case based on updated context: " + lastKnownContext;
            String newTestCase = generator.generateTestCase(prompt);
            System.out.println("Generated Test Case:\n" + newTestCase);
        } else {
            System.out.println("No context change detected.");
        }
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        TestCaseGenerator generator = new TestCaseGenerator(apiKey);
        ContextAgent agent = new ContextAgent();
        String contextPath = "test_data/sample_test_data.json";
        agent.handleContextChange(contextPath, generator);
    }
}
