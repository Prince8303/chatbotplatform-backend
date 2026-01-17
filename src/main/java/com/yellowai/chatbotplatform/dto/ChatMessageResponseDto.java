package com.yellowai.chatbotplatform.dto;

import java.time.LocalDateTime;

public class ChatMessageResponseDto {

    private Long id;
    private String senderEmail;
    private String message;
    private LocalDateTime createdAt;

    public ChatMessageResponseDto(
            Long id,
            String senderEmail,
            String message,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
