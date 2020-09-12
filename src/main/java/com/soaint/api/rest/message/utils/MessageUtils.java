package com.soaint.api.rest.message.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageUtils {

  public static boolean validateParameters(final boolean logError, final boolean logMessage, final boolean logWarning,
      final boolean logToConsole, final boolean logToFile, final boolean logToDatabase, final String messageText, final boolean message,
      final boolean warning, final boolean error)
      throws Exception {

    if (messageText.length() == 0) {
      throw new Exception("The message cannot be empty.");
    } else {
      if (!logToConsole && !logToFile && !logToDatabase) {
        throw new Exception("Invalid configuration");
      } else if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
        throw new Exception("Error or Warning or Message must be specified");
      }
    }
    return true;
  }
}
