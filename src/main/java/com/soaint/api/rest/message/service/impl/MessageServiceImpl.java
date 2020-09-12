package com.soaint.api.rest.message.service.impl;

import static com.soaint.api.rest.message.utils.MessageUtils.validateParameters;

import com.soaint.api.rest.message.model.dto.MessageDto;
import com.soaint.api.rest.message.model.dto.MessageRequest;
import com.soaint.api.rest.message.model.repository.MessageRepository;
import com.soaint.api.rest.message.service.MessageService;
import java.io.File;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageServiceImpl implements MessageService {

  private final static boolean logToFile = true;

  private final static boolean logToConsole = true;

  private final static boolean logMessage = true;

  private final static boolean logWarning = true;

  private final static boolean logError = true;

  private final static boolean logToDatabase = true;

  private final static Logger logger = Logger.getLogger("MyLog");

  @Autowired
  MessageRepository messageRepository;

  @Override
  public MessageDto create(MessageRequest messageRequest) {
    int t = 0;
    String l = StringUtils.EMPTY;
    MessageDto messageCreate = new MessageDto();
    try {
      final boolean response = getValidateParameters(messageRequest);
      if (response) {
        if (messageRequest.isMessage() && logMessage) {
          t = 1;
        }

        if (messageRequest.isError() && logError) {
          t = 2;
        }

        if (messageRequest.isWarning() && logWarning) {
          t = 3;
        }

        if ((messageRequest.isWarning() && logWarning) && (messageRequest.isError() && logError)) {
          t = 4;
        }

        if (messageRequest.isError() && logError) {
          l += l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageRequest.getMessageText();
        }

        if (messageRequest.isWarning() && logWarning) {
          l += "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageRequest.getMessageText();
        }

        if (messageRequest.isMessage() && logMessage) {
          l += "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageRequest.getMessageText();
        }

        FileHandler fh = new FileHandler(new File("").getAbsolutePath() + "/src/main/resources/logs/logFile_" + LocalDateTime.now() + ".txt");
        ConsoleHandler ch = new ConsoleHandler();

        if (logToFile) {
          logger.addHandler(fh);
          logger.log(Level.INFO, messageRequest.getMessageText());
        }

        if (logToConsole) {
          logger.addHandler(ch);
          logger.log(Level.INFO, messageRequest.getMessageText());
        }

        messageCreate.setMessageContent(StringUtils.join(t, l));
        messageCreate.setMessageDate(LocalDateTime.now().toString());
      }
    } catch (Exception exception) {
      MessageServiceImpl.log.error("ERROR: ", exception);
    }
    return messageRepository.save(messageCreate);
  }

  private boolean getValidateParameters(MessageRequest messageRequest) throws Exception {
    return validateParameters(logError, logMessage, logWarning, logToConsole, logToFile, logToDatabase, messageRequest.getMessageText(),
        messageRequest.isMessage(), messageRequest.isWarning(), messageRequest.isError());
  }
}
