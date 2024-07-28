package uk.gov.justice.genaitests.model;

public record JiraIssues(JiraIssue[] issues) {
    public record JiraIssue(long id, String key, JiraFields fields, String description) {
        public record JiraFields(String summary, JiraDescription description) {
            public record JiraDescription(JiraContent1[] content) {
                public record JiraContent1(JiraContent2[] content) {
                    public record JiraContent2(String text) {}
                }
            }
        }
    }
}
