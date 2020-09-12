package com.soaint.api.rest.message.service;

import com.soaint.api.rest.message.model.dto.MessageRequest;
import com.soaint.api.rest.message.model.repository.MessageRepository;
import com.soaint.api.rest.message.service.impl.MessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MessageServiceTest {

  @Autowired
  private MessageServiceImpl messageService;

  @MockBean
  MessageRepository messageRepository;

  private MessageRequest messageRequest;

  @BeforeEach
  public void init() {
    this.messageRequest = new MessageRequest("Hola", true, true, false);
  }

  @Test
  public void createSuccessfullyTest() {
    this.messageService.create(messageRequest);
  }

}
