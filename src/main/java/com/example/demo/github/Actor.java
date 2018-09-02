package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

public class Actor {

    @ApiModelProperty(notes = "User login name")
    @Getter private final String login;
    @ApiModelProperty(notes = "Avatar of the user")
    @Getter private final String avatarUrl;
    @ApiModelProperty(notes = "Link to the user profile")
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
