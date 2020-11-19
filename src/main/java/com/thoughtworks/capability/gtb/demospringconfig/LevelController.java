package com.thoughtworks.capability.gtb.demospringconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.Location;

@RestController
@Configurable
@PropertySource("classpath:application-dev.properties")
public class LevelController {

    @Value("${levelNumber}")
    private int levelNumber;

    @GetMapping("/level")
    public String getLevel() {
      return levelNumber < 1 ? "basic" : "advanced";
    }
}
