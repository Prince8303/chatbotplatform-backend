package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.dto.CreatePromptRequestDto;
import com.yellowai.chatbotplatform.entity.Project;
import com.yellowai.chatbotplatform.entity.Prompt;
import com.yellowai.chatbotplatform.repository.ProjectRepository;
import com.yellowai.chatbotplatform.repository.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptService {

    private final PromptRepository promptRepository;
    private final ProjectRepository projectRepository;

    public PromptService(PromptRepository promptRepository,
                         ProjectRepository projectRepository) {
        this.promptRepository = promptRepository;
        this.projectRepository = projectRepository;
    }

    public Prompt createPrompt(Long projectId, CreatePromptRequestDto request) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Prompt prompt = new Prompt();
        prompt.setContent(request.getContent());
        prompt.setProject(project);

        return promptRepository.save(prompt);
    }

    public List<Prompt> getPromptsByProject(Long projectId) {
        return promptRepository.findByProjectId(projectId);
    }
}
