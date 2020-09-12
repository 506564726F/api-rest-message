package com.soaint.api.rest.message.service;

import com.soaint.api.rest.message.model.dto.MessageDto;
import com.soaint.api.rest.message.model.dto.MessageRequest;

public interface MessageService {

  MessageDto create(MessageRequest messageRequest);

}
