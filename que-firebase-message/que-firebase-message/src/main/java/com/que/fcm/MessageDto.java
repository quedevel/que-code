package com.que.fcm;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
  private String title;
  private String body;
  private String image;
  private Map<String, String> data = new HashMap<>();
}
