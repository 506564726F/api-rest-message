package com.soaint.api.rest.message.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationProperties {

  @Value("${swagger.base.package.name}")
  private String swaggerBasePackage;
}
