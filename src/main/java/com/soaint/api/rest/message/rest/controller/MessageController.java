package com.soaint.api.rest.message.rest.controller;

import com.soaint.api.rest.message.model.api.MessageApi;
import com.soaint.api.rest.message.model.dto.MessageDto;
import com.soaint.api.rest.message.model.dto.MessageRequest;
import com.soaint.api.rest.message.service.MessageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController implements MessageApi {

  @NonNull
  private final MessageService messageService;

  @Override
  public ResponseEntity<MessageDto> createMessage(MessageRequest messageRequest) {
    try {
      this.messageService.create(messageRequest);
      MessageController.log.info("Info - Message created {}", messageRequest);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception exception) {
      MessageController.log.info("Info - creation failed {}", messageRequest);
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }
}
