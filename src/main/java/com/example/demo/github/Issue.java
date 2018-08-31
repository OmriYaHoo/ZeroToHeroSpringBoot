package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Issue {

    @Getter
    private final String htmlUrl;
    @Getter
    private final int number;
    @Getter
    private final String title;

    @JsonCreator
    public Issue(@JsonProperty("html_url") String htmlUrl,
                 @JsonProperty("number") int number,
                 @JsonProperty("title") String title) {
        this.htmlUrl = htmlUrl;
        this.number = number;
        this.title = title;
    }
}
