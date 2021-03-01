package az.itcity.etaskify.controller;

import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/admin/users") //   /admin-e rol verilib yene de ehtiyac varmi
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public UserDto addUser(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }


}
