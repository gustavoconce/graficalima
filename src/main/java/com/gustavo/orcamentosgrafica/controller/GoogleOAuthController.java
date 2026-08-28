package com.gustavo.orcamentosgrafica.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class GoogleOAuthController {

    private final GoogleAuthorizationCodeFlow flow;

    public GoogleOAuthController(GoogleAuthorizationCodeFlow flow) {
        this.flow = flow;
    }

    @GetMapping("/api/google-drive/authorize")
    public RedirectView authorize() throws IOException {

        String authorizationUrl = flow.newAuthorizationUrl()
                .setRedirectUri("http://localhost:8080/oauth2/callback")
                .build();

        return new RedirectView(authorizationUrl);
    }

    @GetMapping("/oauth2/callback")
    public String callback(
            @RequestParam("code") String code
    ) throws IOException {

        var tokenResponse = flow.newTokenRequest(code)
                .setRedirectUri("http://localhost:8080/oauth2/callback")
                .execute();

        flow.createAndStoreCredential(tokenResponse, "usuario");

        return "OAuth autorizado com sucesso!";
    }
}