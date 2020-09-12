package com.soaint.api.rest.message.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageRequest {

  @JsonProperty("messageContent")
  private String messageText;

  @JsonProperty("message")
  private boolean message;

  @JsonProperty("warning")
  private boolean warning;

  @JsonProperty("error")
  private boolean error;

}
