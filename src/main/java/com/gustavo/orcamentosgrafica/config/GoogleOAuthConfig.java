package com.gustavo.orcamentosgrafica.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Configuration
public class GoogleOAuthConfig {

    @Value("${google.oauth.credentials-path}")
    private String credentialsPath;

    @Value("${google.oauth.tokens-path}")
    private String tokensPath;

    @Bean
    public GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow()
            throws IOException, GeneralSecurityException {

        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(
                        GsonFactory.getDefaultInstance(),
                        new FileReader(credentialsPath)
                );

        return new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                clientSecrets,
                Collections.singleton(DriveScopes.DRIVE)
        )
                .setDataStoreFactory(
                        new FileDataStoreFactory(
                                new File(tokensPath)
                        )
                )
                .setAccessType("offline")
                .build();
    }
}