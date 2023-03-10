package university.rosbiotech.prototype1.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import university.rosbiotech.prototype1.dtos.TaskDto;
import university.rosbiotech.prototype1.entities.Task;

@Component
@RequiredArgsConstructor
public class TaskConverter {
    public TaskDto entityToDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription());
    }
}
