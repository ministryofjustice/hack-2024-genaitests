package uk.gov.justice.genaitests.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.genaitests.model.JiraWebHook;

import java.io.File;

@Slf4j
@RestController
public class WebHookController {
    @PostMapping("/webhook")
    public ResponseEntity<String> postWebhook(@RequestBody JiraWebHook request) throws Exception {
        if (request != null && request.issue() != null && request.comment() != null) {
            if (log.isInfoEnabled()) {
                log.info("received a web hook event [{}] for issue [{}] -- comment is [{}]",
                        request.webhookEvent(), request.issue().key(), request.comment().body());
            }
            if ("comment_created".equals(request.webhookEvent()) && "genaitests".equals(request.comment().body())) {
                Process p = Runtime.getRuntime().exec("./runmain " + request.issue().key());
                //p.waitFor();
            }
        }
        return ResponseEntity.ok("{}");
    }
}
