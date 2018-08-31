package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Actor {

    @Getter private final String login;
    @Getter private final String avatarUrl;
    @Getter private final String htmlUrl;

    @JsonCreator
    public Actor(@JsonProperty("login") String login,
                 @JsonProperty("avatar_url") String avatarUrl,
                 @JsonProperty("html_url") String htmlUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }

}
