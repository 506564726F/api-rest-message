package com.soaint.api.rest.message.model.api;

import com.soaint.api.rest.message.model.dto.MessageDto;
import com.soaint.api.rest.message.model.dto.MessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Api(value = "Message")
public interface MessageApi {

  @ApiOperation(value = "Create an message", nickname = "createMessage", notes = "create a message.", response = MessageDto.class,
      responseContainer = "List", tags = {
      "PersonConfigurationBackOffice",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Succesful response", response = MessageDto.class, responseContainer = "List"),
      @ApiResponse(code = 400, message = "Request contains incorrect syntax or cannot be processed"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  @RequestMapping(value = "/message/create",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST)
  default ResponseEntity<MessageDto> createMessage(
      @ApiParam(value = "MessageRequest") @RequestBody MessageRequest messageRequest) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
