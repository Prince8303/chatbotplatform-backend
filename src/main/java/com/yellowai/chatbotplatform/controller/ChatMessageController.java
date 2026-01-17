package com.yellowai.chatbotplatform.controller;

import com.yellowai.chatbotplatform.dto.ChatMessageRequestDto;
import com.yellowai.chatbotplatform.service.ChatMessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatMessageController {

    private final ChatMessageService service;

    public ChatMessageController(ChatMessageService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(
            @Valid @RequestBody ChatMessageRequestDto request
    ) {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/messages")
    public ResponseEntity<?> getMessages(
            @RequestParam String email
    ) {
        return ResponseEntity.ok(service.getBySender(email));
    }
}
