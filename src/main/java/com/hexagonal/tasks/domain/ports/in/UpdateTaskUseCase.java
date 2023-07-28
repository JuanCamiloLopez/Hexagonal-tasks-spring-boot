package com.hexagonal.tasks.domain.ports.in;
import com.hexagonal.tasks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
/*Como a la hora de actualizar vamos a trabajar con un id y este puede existir o no y dar respuesta o no darla, vamos a utilizar optional */
    Optional<Task> updateTask(Long id, Task updateTask);

}
