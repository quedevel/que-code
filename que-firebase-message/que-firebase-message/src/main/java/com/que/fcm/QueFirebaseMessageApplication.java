package com.que.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class QueFirebaseMessageApplication {

  public static void main(String[] args) {
    SpringApplication.run(QueFirebaseMessageApplication.class, args);
  }

  @Bean
  FirebaseMessaging firebaseMessaging() throws IOException {
    ClassPathResource resource = new ClassPathResource("firebase/peachmind-48908-firebase-adminsdk-ikupz-174f0df471.json");

    InputStream inputStream = resource.getInputStream();

    FirebaseApp app = null;
    List<FirebaseApp> firebaseAppList = FirebaseApp.getApps();

    if (firebaseAppList != null && !firebaseAppList.isEmpty()) {
      for (FirebaseApp firebaseApp : firebaseAppList) {
        if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)){
          app = firebaseApp;
        }
      }
    } else {
      FirebaseOptions options = FirebaseOptions.builder()
          .setCredentials(GoogleCredentials.fromStream(inputStream))
          .build();

      app = FirebaseApp.initializeApp(options);
    }
    return FirebaseMessaging.getInstance(app);
  }

}
