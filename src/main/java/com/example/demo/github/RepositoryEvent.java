package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

public class RepositoryEvent {

    @Getter
    private final Type type;
    @Getter
    private final LocalDateTime creationTime;
    @Getter
    private final Actor actor;
    @Getter
    private final Issue issue;

    @JsonCreator
    public RepositoryEvent(@JsonProperty("event") String type,
                           @JsonProperty("created_at") LocalDateTime creationTime,
                           @JsonProperty("actor") Actor actor,
                           @JsonProperty("issue") Issue issue) {
        this.type = Type.valueFrom(type);
        this.creationTime = creationTime;
        this.actor = actor;
        this.issue = issue;
    }

    public enum Type {

        CLOSED("closed"),
        REOPENED("reopened"),
        SUBSCRIBED("subscribed"),
        UNSUBSCRIBED("unsubscribed"),
        MERGED("merged"),
        REFERENCED("referenced"),
        MENTIONED("mentioned"),
        ASSIGNED("assigned"),
        UNASSIGNED("unassigned"),
        LABELED("labeled"),
        UNLABELED("unlabeled"),
        MILESTONED("milestoned"),
        DEMILESTONED("demilestoned"),
        RENAMED("renamed"),
        LOCKED("locked"),
        UNLOCKED("unlocked"),
        HEAD_REF_DELETED("head_ref_deleted"),
        HEAD_REF_RESTORED("head_ref_restored"),
        CONVERTED_NOTE_TO_ISSUE("converted_note_to_issue"),
        MOVED_COLUMNS_IN_PROJECT("moved_columns_in_project"),
        COMMENT_DELETED("comment_deleted"),
        REVIEW_REQUESTED("review_requested");

        private String type;

        Type(String type) {
            this.type = type;
        }

        static Type valueFrom(String type) {
            for (Type value : values()) {
                if (type.equals(value.type)) {
                    return value;
                }
            }
            throw new IllegalArgumentException(
                    "'" + type + "' is not a valid event type");
        }
    }

}
