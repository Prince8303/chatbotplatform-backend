package com.yellowai.chatbotplatform.repository;

import com.yellowai.chatbotplatform.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findBySenderEmailOrderByCreatedAtAsc(String senderEmail);
}
