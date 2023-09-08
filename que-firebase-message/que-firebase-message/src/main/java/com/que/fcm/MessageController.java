package com.que.fcm;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

  private final MessageService messageService;

  @GetMapping
  public String sendMessage(){
    return messageService.sendMessage(new MessageDto("테스트 타이틀","테스트 내용", "", new HashMap<>()));
  }

}
