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
    private static final String USER = "${JIRA_USER}";
    private static final String TOKEN = "${JIRA_TOKEN}";
    private static final String JQL = "${JIRA_JQL}";

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public JiraIssues getIssues() throws Exception {
        var params = Map.of("jql", JQL);
        //        "fields", "id,key,summary,description");
        return restTemplateBuilder
                .basicAuthentication(USER, TOKEN)
                .rootUri(JIRA_URL)
                .build()
                .getForObject("/rest/api/3/search", JiraIssues.class);
    }
}

