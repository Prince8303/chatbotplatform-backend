package com.yellowai.chatbotplatform.controller;

import com.yellowai.chatbotplatform.dto.CreateProjectRequestDto;
import com.yellowai.chatbotplatform.entity.Project;
import com.yellowai.chatbotplatform.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(
            @Valid @RequestBody CreateProjectRequestDto request) {

        return ResponseEntity.ok(
                projectService.createProject(request)
        );
    }
}
