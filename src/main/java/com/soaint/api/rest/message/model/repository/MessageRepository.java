package com.soaint.api.rest.message.model.repository;

import com.soaint.api.rest.message.model.dto.MessageDto;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageDto, Integer> {

}
