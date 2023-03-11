package university.rosbiotech.prototype1.restControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import university.rosbiotech.prototype1.converters.TaskConverter;
import university.rosbiotech.prototype1.dtos.TaskDto;
import university.rosbiotech.prototype1.entities.Task;
import university.rosbiotech.prototype1.exceptions.ResourceNotFoundException;
import university.rosbiotech.prototype1.services.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskRestController {
    private final TaskService taskService;
    private final TaskConverter taskConverter;

    @GetMapping
    @PreAuthorize(value = "hasAuthority('read')")
    public List<TaskDto> getAll() {
        return taskService.getAll().stream().map(taskConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('read')")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        return taskConverter.entityToDto(task);
    }

    @PostMapping("/create")
    @PreAuthorize(value = "hasAuthority('write')")
    public TaskDto createNewTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.createNewTask(taskDto);
        return taskConverter.entityToDto(task);
    }
}
