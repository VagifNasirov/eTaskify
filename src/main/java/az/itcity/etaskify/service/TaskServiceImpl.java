package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.TaskDto;
import az.itcity.etaskify.entity.Task;
import az.itcity.etaskify.mapper.TaskDtoMapper;
import az.itcity.etaskify.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private OrganizationService organizationService;

    @Override
    public TaskDto create(TaskDto taskDto) {

        Task task = TaskDtoMapper.INSTANCE.TaskDtoToTask(taskDto);

        return TaskDtoMapper.INSTANCE.TaskToTaskDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getMyTasks() {
        return taskRepository.findAllByOrganization(organizationService.getMyOrganization())
                .stream()
                .map(TaskDtoMapper.INSTANCE::TaskToTaskDto)
                .collect(Collectors.toList());
    }
}
