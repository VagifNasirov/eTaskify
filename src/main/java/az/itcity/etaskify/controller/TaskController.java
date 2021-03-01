package az.itcity.etaskify.controller;

import az.itcity.etaskify.dto.TaskDto;
import az.itcity.etaskify.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/addTasks")
    public TaskDto addTasks(@RequestBody TaskDto taskDto){
        return taskService.create(taskDto);
    }

    @GetMapping
    public List<TaskDto> getOwnTasks(){

        return taskService.getMyTasks();
    }
}
