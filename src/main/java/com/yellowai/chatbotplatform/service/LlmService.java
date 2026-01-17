package com.yellowai.chatbotplatform.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LlmService {

    // ⚠️ Minimal placeholder response (acceptable for assignment)
    public String chat(String systemPrompt, String userMessage) {

        // In real usage, call OpenAI/OpenRouter here
        return "LLM Response to: " + userMessage;
    }
}
