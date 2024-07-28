package uk.gov.justice.genaitests.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.genaitests.model.ScenarioRequest;
import uk.gov.justice.genaitests.model.ScenarioResponse;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class ScenarioController {
    private final ChatClient chatClient;

    @Value("classpath:/system-prompt.txt")
    private String systemPrompt;

    @Value("classpath:/user-prompt.st")
    private Resource userPromptTemplate;

    public ScenarioController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/scenario")
    public ScenarioResponse postScenario(@RequestBody ScenarioRequest request) {
        String reqStr = Arrays.stream(request.requirements())
                .map(s -> s.indent(2))
                .map(s -> "*" + s.substring(1))
                .collect(Collectors.joining("\n"));
        return chatClient.prompt()
                .system(systemPrompt)
                .user(userSpec -> userSpec
                        .text(userPromptTemplate)
                        .param("requirements", reqStr))
                .call()
                .entity(ScenarioResponse.class);
    }
}
