package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

public class Issue {

    @ApiModelProperty(notes = "Link to the issue")
    @Getter
    private final String htmlUrl;
    @ApiModelProperty(notes = "Issue number")
    @Getter
    private final int number;
    @ApiModelProperty(notes = "Issue title")
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
