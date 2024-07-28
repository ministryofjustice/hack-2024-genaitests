from atlassian import Jira

import logging
import requests
import sys

JIRA_URL="${JIRA_URL}"
USER="${JIRA_USER}"
TOKEN="${JIRA_TOKEN}"

SCENARIO_URL="http://localhost:8080/scenario"

# Defines a function for connecting to Jira
def connect_jira(log):
    '''
    Connect to JIRA.
    '''
    log.info("Connecting to JIRA: %s" % JIRA_URL)
    jira = Jira(url=JIRA_URL, username=USER, password=TOKEN, cloud=True)
    return jira

# Separate scenarios with an extra blank line
def add_blank_lines(input):
    x = []
    for item in input:
        if item.startswith('Scenario:') and len(x) > 0:
            x.append("")
        x.append(item)
    return x

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

    response = requests.post(SCENARIO_URL, json={"requirements": list(reqs_compressed)})

    scenarios = response.json()["scenarios"]
    scenarios_separated = add_blank_lines(scenarios)
    scenarios_text = "\n".join(scenarios_separated)
    jira.issue_add_comment(issue_key, scenarios_text)
    with open(issue_key + ".feature", "w") as text_file:
        text_file.write(scenarios_text)
