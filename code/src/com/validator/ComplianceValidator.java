
package com.finai.validator;

import java.util.ArrayList;
import java.util.List;

public class ComplianceValidator {

    public List<String> validateCompliance(String testCase) {
        List<String> issues = new ArrayList<>();

        if (!testCase.toLowerCase().contains("kyc")) {
            issues.add("Missing KYC check.");
        }
        if (!testCase.toLowerCase().contains("aml")) {
            issues.add("Missing AML validation.");
        }
        if (!testCase.toLowerCase().contains("sox")) {
            issues.add("Missing SOX compliance step.");
        }

        return issues;
    }

    public static void main(String[] args) {
        ComplianceValidator validator = new ComplianceValidator();
        String sampleTestCase = "This test covers KYC and credit score evaluation for a loan application.";
        List<String> violations = validator.validateCompliance(sampleTestCase);

        if (violations.isEmpty()) {
            System.out.println("Test case is compliant with KYC/AML/SOX.");
        } else {
            System.out.println("Compliance issues found:");
            for (String issue : violations) {
                System.out.println("- " + issue);
            }
        }
    }
}
