package com.example.demo.events;


import com.example.demo.github.GithubClient;
import com.example.demo.github.RepositoryEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@Api(value = "Events APIs", description = "Operations for pertaining issues events in GitHub Projects")
public class EventsController {

    private final GithubProjectRepository repository;
    private final GithubClient githubClient;

    public EventsController(GithubProjectRepository githubProjectRepository, GithubClient githubClient) {
        this.repository = githubProjectRepository;
        this.githubClient = githubClient;
    }

    @ResponseBody
    @ApiOperation(value = "Get issues list of a GitHub Repository by name", response = RepositoryEvent.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/events/{repoName}")
    public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
        GithubProject project = this.repository.findByRepoName(repoName);

        return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
    }

    @GetMapping("/dashboard")
    @ResponseBody
    public List dashboard() {
        Iterable<GithubProject> projects = this.repository.findAll();

        List<DashboardEntry> entries = StreamSupport.stream(projects.spliterator(), true)
                .map(p -> new DashboardEntry(p, this.githubClient.fetchEventsList(p.getOrgName(), p.getRepoName())))
                .collect(Collectors.toList());
        return entries;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("projects", repository.findAll());
        return "admin";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
