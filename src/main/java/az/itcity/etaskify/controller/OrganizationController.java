package az.itcity.etaskify.controller;

import az.itcity.etaskify.dto.OrganizationDto;
import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.service.OrganizationService;
import az.itcity.etaskify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/organizations")
public class OrganizationController {
    private OrganizationService organizationService;
    private UserService userService;

    @Autowired
    public OrganizationController(OrganizationService organizationService, UserService userService) {
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @GetMapping("/myUsers")
    public List<UserDto> getMyUsers(){

        return userService.getMyUsers();
    }

}
