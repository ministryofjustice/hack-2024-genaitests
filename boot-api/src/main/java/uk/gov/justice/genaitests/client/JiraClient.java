package uk.gov.justice.genaitests.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import uk.gov.justice.genaitests.model.JiraIssues;

import java.util.Map;

/**
 * Experimental code - not used.
 */
@Component
public class JiraClient {
    private static final String JIRA_URL = "${JIRA_URL}";
    private static final String JIRA_USER = "${JIRA_USER}";
    private static final String JIRA_TOKEN = "${JIRA_TOKEN}";
    private static final String JIRA_JQL = "${JIRA_JQL}";

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public JiraIssues getIssues() throws Exception {
        var params = Map.of("jql", JIRA_JQL);
        //        "fields", "id,key,summary,description");
        return restTemplateBuilder
                .basicAuthentication(JIRA_USER, JIRA_TOKEN)
                .rootUri(JIRA_URL)
                .build()
                .getForObject("/rest/api/3/search", JiraIssues.class);
    }
}

