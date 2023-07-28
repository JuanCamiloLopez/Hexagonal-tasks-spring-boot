package com.hexagonal.tasks.infrastructure.config;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecase.*;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAddapter;
import com.hexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase,
                new UpdateTaskUseCaseImpl(taskRepositoryPort)
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAddapter();
    }
}
