package com.example.mssinaramongo.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Dotenv dotenv = Dotenv.configure()
                .directory("./")  // ou especifique o caminho do seu .env
                .ignoreIfMissing()
                .load();

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> dotenvMap = new HashMap<>();

        dotenv.entries().forEach(entry -> {
            dotenvMap.put(entry.getKey(), entry.getValue());
        });

        environment.getPropertySources()
                .addFirst(new MapPropertySource("dotenvProperties", dotenvMap));
    }
}