package com.entelgy.challenge.config;

import com.entelgy.challenge.config.properties.EntelgyChallengeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntelgyChallengeConfiguration {

    @Bean
    @ConfigurationProperties(prefix = EntelgyChallengeProperties.DEFAULT_CHALLENGE_PROPERTIES)
    public EntelgyChallengeProperties commentsChallengeProperties() {
        return new EntelgyChallengeProperties();
    }

}
