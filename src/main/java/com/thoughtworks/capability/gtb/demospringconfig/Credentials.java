package com.thoughtworks.capability.gtb.demospringconfig;

import lombok.Data;

@Data
public class Credentials {
  private String username;
  private String password;
  private String authMethod;
}
