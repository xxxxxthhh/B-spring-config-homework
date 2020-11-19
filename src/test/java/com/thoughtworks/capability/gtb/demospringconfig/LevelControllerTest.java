package com.thoughtworks.capability.gtb.demospringconfig;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import	java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private String setLevelController(String levelNumber) throws IOException, InterruptedException {
    String filename = "application.properties";
    // String filename = "../src/main/resources/application.properties";
    Properties properties = new Properties();
    properties.setProperty("levelNumber", levelNumber);
    properties.store(new FileOutputStream(filename), "change LevelNum");

    Properties appProperty = new Properties();
    appProperty.load(new java.io.FileInputStream(filename));
    String levelNum = "";

    while(!levelNum.equals(levelNumber)){
      appProperty.load(new java.io.FileInputStream(filename));
      levelNum = appProperty.getProperty("levelNumber");
      System.out.println(levelNum);
    }
    return levelNum;
  }

  @Test
  void get_level_advanced_when_num_is_less_or_equal_1() throws Exception {
    String levelNum = setLevelController("-10");
    System.out.println(levelNum);
    mockMvc.perform(get("/level")).andExpect(jsonPath("$", is("basic")));
  }

}