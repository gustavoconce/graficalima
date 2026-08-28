package com.gustavo.orcamentosgrafica.service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleDriveService {

    private final Drive drive;
    private final String folderId;

    public GoogleDriveService(
            GoogleAuthorizationCodeFlow flow,
            @Value("${google.drive.folder-id}") String folderId
    ) throws GeneralSecurityException, IOException {

        this.folderId = folderId;

        Credential credential = flow.loadCredential("usuario");

        if (credential == null) {
            throw new IllegalStateException(
                    "Credencial Google não encontrada. Autorize o aplicativo primeiro."
            );
        }

        this.drive = new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                GsonFactory.getDefaultInstance(),
                credential
        )
                .setApplicationName("Gráfica Lima")
                .build();
    }

    public String upload(MultipartFile arquivo) throws IOException {

        File metadata = new File();

        metadata.setName(arquivo.getOriginalFilename());
        metadata.setParents(Collections.singletonList(folderId));

        InputStreamContent mediaContent = new InputStreamContent(
                arquivo.getContentType(),
                arquivo.getInputStream()
        );

        File arquivoCriado = drive.files()
                .create(metadata, mediaContent)
                .setFields("id, name")
                .execute();

        return arquivoCriado.getId();
    }
}