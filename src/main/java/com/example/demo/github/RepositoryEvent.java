package com.example.demo.github;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class RepositoryEvent {

    private final Type type;
    private final OffsetDateTime creationTime;
    private final Actor actor;
    private final Issue issue;

}
