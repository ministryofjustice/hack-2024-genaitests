package uk.gov.justice.genaitests.model;

public record JiraWebHook(String webhookEvent, JiraIssues.JiraIssue issue, JiraComment comment) {
    public record JiraComment(String body) {}
}
