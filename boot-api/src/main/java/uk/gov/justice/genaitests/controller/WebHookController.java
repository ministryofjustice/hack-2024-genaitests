package uk.gov.justice.genaitests.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.justice.genaitests.model.JiraWebHook;

import java.io.File;

@RestController
public class WebHookController {
    @PostMapping("/webhook")
    public ResponseEntity<String> postWebhook(@RequestBody JiraWebHook request) throws Exception {
        System.out.println(request.webhookEvent());
        System.out.println(request.issue().key());
        System.out.println(request.comment().body());
        if (request.webhookEvent().equals("comment_created") && request.comment().body().equals("genaitests")) {
            Process p = Runtime.getRuntime().exec("./runmain " + request.issue().key());
            //p.waitFor();
        }
        return ResponseEntity.ok("");
    }
}
