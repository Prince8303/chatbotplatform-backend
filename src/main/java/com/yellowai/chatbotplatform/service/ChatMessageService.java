package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.dto.ChatMessageRequestDto;
import com.yellowai.chatbotplatform.dto.ChatMessageResponseDto;
import com.yellowai.chatbotplatform.entity.ChatMessage;
import com.yellowai.chatbotplatform.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {

    private final ChatMessageRepository repository;

    public ChatMessageService(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public ChatMessageResponseDto save(ChatMessageRequestDto request) {
        ChatMessage message =
                new ChatMessage(request.getSenderEmail(), request.getMessage());

        ChatMessage saved = repository.save(message);

        return new ChatMessageResponseDto(
                saved.getId(),
                saved.getSenderEmail(),
                saved.getMessage(),
                saved.getCreatedAt()
        );
    }

    public List<ChatMessageResponseDto> getBySender(String email) {
        return repository.findBySenderEmailOrderByCreatedAtAsc(email)
                .stream()
                .map(m -> new ChatMessageResponseDto(
                        m.getId(),
                        m.getSenderEmail(),
                        m.getMessage(),
                        m.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}
