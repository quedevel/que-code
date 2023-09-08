package com.que.fcm;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

  private final FirebaseMessaging firebaseMessaging;

  @Value("${firebase.token}")
  private String TOKEN;

  public String sendMessage(MessageDto dto){
    Notification notification = Notification.builder()
        .setTitle("공통 타이틀 메세지")
        .setBody("공통 컨텐츠")
        .build();

    AndroidNotification androidNotification = AndroidNotification.builder()
        .setTitle("안드로이드 타이틀")
        .setBody("안드로이트 내용")
        .build();

    AndroidConfig androidConfig = AndroidConfig.builder()
        .setNotification(androidNotification)
        .build();

    Map<String, String> data = new HashMap<>();
    data.put("deeplink","example://peachmind");


    Message message = Message.builder()
        .setNotification(notification)
        .setToken(TOKEN)
        .setAndroidConfig(androidConfig)
        .putAllData(data)
        .build();

    try {
      firebaseMessaging.send(message);
    } catch (FirebaseMessagingException e) {
      throw new RuntimeException(e);
    }

    return "ok";
  }
}
