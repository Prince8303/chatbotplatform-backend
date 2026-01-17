package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.entity.Prompt;
import com.yellowai.chatbotplatform.repository.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final PromptRepository promptRepository;
    private final LlmService llmService;

    public ChatService(PromptRepository promptRepository,
                       LlmService llmService) {
        this.promptRepository = promptRepository;
        this.llmService = llmService;
    }

    public String chat(Long projectId, String userMessage) {

        List<Prompt> prompts = promptRepository.findByProjectId(projectId);

        StringBuilder systemPrompt = new StringBuilder();
        for (Prompt p : prompts) {
            systemPrompt.append(p.getContent()).append("\n");
        }

        return llmService.chat(systemPrompt.toString(), userMessage);
    }
}
