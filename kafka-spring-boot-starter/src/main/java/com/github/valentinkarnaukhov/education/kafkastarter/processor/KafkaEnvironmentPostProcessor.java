package com.github.valentinkarnaukhov.education.kafkastarter.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class KafkaEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final PropertySourceLoader loader = new PropertiesPropertySourceLoader();
    private static final String PROPERTIES_PATH = "config.properties";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource configPath = new ClassPathResource("config.properties");
        try {
            List<PropertySource<?>> propertySource = loader.load(PROPERTIES_PATH, configPath);
            propertySource.stream()
                    .filter(Objects::nonNull)
                    .forEach(ps -> environment.getPropertySources().addLast(ps));
        } catch (IOException e) {
            // ignore
        }
    }
}
