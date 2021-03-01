package az.itcity.etaskify.mapper;

import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mappings(
            value = {
                    @Mapping(source = "name", target = "firstname"),
                    @Mapping(source = "surname", target = "lastname")
            }
    )
    UserDto UserToUserDto(User user);

    @Mappings(
            value = {
                    @Mapping(target = "name", source = "firstname"),
                    @Mapping(target = "surname", source = "lastname")
            }
    )
    User UserDtoToUser(UserDto userDto);
}
