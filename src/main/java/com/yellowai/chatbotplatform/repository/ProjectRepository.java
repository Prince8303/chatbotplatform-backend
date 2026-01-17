package com.yellowai.chatbotplatform.repository;

import com.yellowai.chatbotplatform.entity.Project;
import com.yellowai.chatbotplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByOwner(User owner);
}
