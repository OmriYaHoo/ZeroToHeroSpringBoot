package com.example.demo.events;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class GithubProject implements Serializable {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated GithubProject ID")
    private Long id;

    @ApiModelProperty(notes = "The orgName of the repository - meaning the owner")
    private String orgName;

    @ApiModelProperty(notes = "The Github project name")
    @Column(unique = true)
    private String repoName;

}
