package com.thoughtworks.capability.gtb.demospringconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

@Data
@Configuration
@ConfigurationProperties("mail")
public class MailConfig {

    private String hostname;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

    @Override
    public String toString() {
      String mailConfig =   "MailConfig{" +
          "hostname='" + hostname + '\'' +
          ", port=" + port +
          ", from='" + from + '\'' +
          ", defaultRecipients='" + defaultRecipients.toString() + '\'' +
          ", additionalHeaders='" + additionalHeaders.toString() + '\'' +
          ", credentials{" +
          "username='" + credentials.getUsername()  + '\'' +
          ", password='" + credentials.getPassword()  + '\'' +
          ", authMethod='" + credentials.getAuthMethod()  + '\'' +
          "}}";

      return mailConfig;

    }
}
