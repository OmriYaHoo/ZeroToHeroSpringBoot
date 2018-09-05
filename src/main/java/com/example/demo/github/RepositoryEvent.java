package com.example.demo.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.LocalDateTime;

public class RepositoryEvent {

    @ApiModelProperty(notes = "Type of issue")
    @Getter
    private final Type type;
    @ApiModelProperty(notes = "The creation time of the issue")
    @Getter
    private final LocalDateTime creationTime;
    @ApiModelProperty(notes = "Who created the issue")
    @Getter
    private final Actor actor;
    @ApiModelProperty(notes = "The issue")
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
        DUPLICATE("marked_as_duplicate"),
        ADDED("added_to_project"),
        REVIEW_REQUESTED("review_requested");

        @ApiModelProperty(notes = "Issue type")
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
