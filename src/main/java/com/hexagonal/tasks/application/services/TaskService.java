package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

/*Vamos a implementar las contratos de la capa de dominio*/
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase, UpdateTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase, UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task) ;
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id, updateTask);
    }
}
