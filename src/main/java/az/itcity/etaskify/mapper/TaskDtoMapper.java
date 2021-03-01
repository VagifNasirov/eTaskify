package az.itcity.etaskify.mapper;

import az.itcity.etaskify.dto.TaskDto;
import az.itcity.etaskify.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskDtoMapper {

    TaskDtoMapper INSTANCE = Mappers.getMapper(TaskDtoMapper.class);

    @Mappings(
            value = {
                    @Mapping(source = "title", target = "hood"),
                    @Mapping(source = "description", target = "characteristic")
            }
    )
    TaskDto TaskToTaskDto(Task task);

    @Mappings(
            value = {
                    @Mapping(target = "title", source = "hood"),
                    @Mapping(target = "description", source = "characteristic")
            }
    )
    Task TaskDtoToTask(TaskDto taskDto);
}
