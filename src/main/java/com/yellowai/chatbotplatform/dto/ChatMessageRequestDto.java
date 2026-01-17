package com.yellowai.chatbotplatform.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatMessageRequestDto {

    @NotBlank
    private String senderEmail;

    @NotBlank
    private String message;

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getMessage() {
        return message;
    }
}
