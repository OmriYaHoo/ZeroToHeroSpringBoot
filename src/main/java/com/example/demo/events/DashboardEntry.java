package com.example.demo.events;

import com.example.demo.github.RepositoryEvent;
import lombok.Getter;

import java.util.List;

public class DashboardEntry {

    @Getter private final GithubProject project;
    @Getter private final List<RepositoryEvent> events;

    public DashboardEntry(GithubProject project, List<RepositoryEvent> events) {
        this.project = project;
        this.events = events;
    }
}
