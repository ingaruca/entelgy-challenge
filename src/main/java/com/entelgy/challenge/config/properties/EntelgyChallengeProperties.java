package com.entelgy.challenge.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class EntelgyChallengeProperties {

    public static final String DEFAULT_CHALLENGE_PROPERTIES = "application.external.comments";

    private String url;
    private String path;

}
