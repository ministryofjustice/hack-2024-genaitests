package uk.gov.justice.genaitests.client;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.gov.justice.genaitests.model.JiraIssues;

import java.util.Arrays;

/**
 * Experimental code - not used.
 */
@SpringBootTest
public class JiraClientTest {
    @Autowired
    JiraClient jiraClient;

    @Test
    @Disabled("Enable if JiraClient is configured")
    void testGetIssues() throws Exception {
        JiraIssues issues = jiraClient.getIssues();
        Arrays.stream(issues.issues()).filter(issue -> issue.key().startsWith("KAN-")).forEach(issue -> {
            System.out.println(issue.key());
            System.out.println(issue.fields().summary());
            System.out.println(issue.fields().description().content()[0].content()[0].text());
            System.out.println();
        });
    }
}
