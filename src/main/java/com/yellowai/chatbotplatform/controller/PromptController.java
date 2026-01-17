package com.yellowai.chatbotplatform.controller;

import com.yellowai.chatbotplatform.dto.CreatePromptRequestDto;
import com.yellowai.chatbotplatform.entity.Prompt;
import com.yellowai.chatbotplatform.service.PromptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/prompts")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping
    public ResponseEntity<Prompt> createPrompt(
            @PathVariable Long projectId,
            @Valid @RequestBody CreatePromptRequestDto request) {

        return ResponseEntity.ok(
                promptService.createPrompt(projectId, request)
        );
    }

    @GetMapping
    public ResponseEntity<List<Prompt>> getPrompts(
            @PathVariable Long projectId) {

        return ResponseEntity.ok(
                promptService.getPromptsByProject(projectId)
        );
    }
}
