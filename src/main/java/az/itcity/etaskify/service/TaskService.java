package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto create(TaskDto taskDto);
    List<TaskDto> getMyTasks();
}
