package com.thoughtworks.capability.gtb.demospringconfig;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import	java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(properties = "levelNumber=10")
@AutoConfigureMockMvc
// @ActiveProfiles("dev")
class LevelControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void get_level_advanced_when_num_is_more_than_1() throws Exception {
    mockMvc.perform(get("/level")).andExpect(jsonPath("$", is("advanced")));
  }

}