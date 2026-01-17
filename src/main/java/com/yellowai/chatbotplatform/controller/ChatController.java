package com.yellowai.chatbotplatform.controller;

import com.yellowai.chatbotplatform.dto.ChatRequestDto;
import com.yellowai.chatbotplatform.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects/{projectId}/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<String> chat(
            @PathVariable Long projectId,
            @Valid @RequestBody ChatRequestDto request) {

        return ResponseEntity.ok(
                chatService.chat(projectId, request.getMessage())
        );
    }
}
