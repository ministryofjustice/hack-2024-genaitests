from atlassian import Jira

import logging
import requests
import sys

JIRA_URL="${JIRA_URL}"
JIRA_USER="${JIRA_USER}"
JIRA_TOKEN="${JIRA_TOKEN}"

GENAPI_URL="http://localhost:8080/scenario"

# Defines a function for connecting to Jira
def connect_jira(log):
    '''
    Connect to JIRA.
    '''
    log.info("Connecting to JIRA: %s" % JIRA_URL)
    jira = Jira(url=JIRA_URL, username=JIRA_USER, password=JIRA_TOKEN, cloud=True)
    return jira

# Separate scenarios with an extra blank line
def add_blank_lines(input):
    output = []
    for line in input:
        if (line.startswith('Scenario:') or line.startswith('Feature:')) and len(output) > 0:
            output.append("")
        output.append(line)
    return output

# create logger
log = logging.getLogger(__name__)

# create a connection object
jira = connect_jira(log)
issue_key = sys.argv[1]
issue = jira.issue(issue_key)

if 'fields' in issue:
    fields = issue['fields']
    desc = fields['description']
    reqs = desc.split('\n')
    reqs_compressed = filter((lambda x: len(x) != 0), reqs)

    response = requests.post(GENAPI_URL, json={"requirements": list(reqs_compressed)})

    scenarios = response.json()["scenarios"]
    scenarios_separated = add_blank_lines(scenarios)
    scenarios_text = "\n".join(scenarios_separated)
    jira.issue_add_comment(issue_key, scenarios_text)
    with open(issue_key + ".feature", "w") as text_file:
        text_file.write(scenarios_text)
