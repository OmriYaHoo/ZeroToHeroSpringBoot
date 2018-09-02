package com.example.demo.events;

import com.example.demo.github.RepositoryEvent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

public class DashboardEntry {

    @ApiModelProperty(notes = "Github Project Entry")
    @Getter private final GithubProject project;
    @ApiModelProperty(notes = "Issues list of the Github project")
    @Getter private final List<RepositoryEvent> events;

    public DashboardEntry(GithubProject project, List<RepositoryEvent> events) {
        this.project = project;
        this.events = events;
    }
}
