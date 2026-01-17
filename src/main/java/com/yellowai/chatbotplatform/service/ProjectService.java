package com.yellowai.chatbotplatform.service;

import com.yellowai.chatbotplatform.dto.CreateProjectRequestDto;
import com.yellowai.chatbotplatform.entity.Project;
import com.yellowai.chatbotplatform.entity.User;
import com.yellowai.chatbotplatform.repository.ProjectRepository;
import com.yellowai.chatbotplatform.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository,
                          UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(CreateProjectRequestDto request) {

        String email =
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setOwner(user);

        return projectRepository.save(project);
    }
}
