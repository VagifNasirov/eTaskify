package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.mapper.UserDtoMapper;
import az.itcity.etaskify.repository.UserRepository;
import az.itcity.etaskify.role.Roles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private OrganizationService organizationService;

    @Transactional
    @Override
    public UserDto create(UserDto userDto) {
        User user = UserDtoMapper.INSTANCE.UserDtoToUser(userDto);

        return UserDtoMapper.INSTANCE.UserToUserDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getMyUsers() {
        return userRepository.findAllByOrganizationAndAndRole(organizationService.getMyOrganization(), Roles.ROLE_USER)
                .stream()
                .map(UserDtoMapper.INSTANCE::UserToUserDto)
                .collect(Collectors.toList());
    }

}
