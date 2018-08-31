package com.example.demo.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@ConfigurationProperties("github")
@Validated
public class GithubProperties {

    @Getter
    @Setter
    /**
     * Github API token ("user: sampletoken")
     */
    @Pattern(regexp = "\\w:\\w")
    private String token;


}
