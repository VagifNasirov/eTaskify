package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.entity.User;


import java.util.List;

public interface UserService {
    UserDto create(UserDto userDto);
    List<UserDto> getMyUsers();
}
