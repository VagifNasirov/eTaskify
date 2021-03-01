package az.itcity.etaskify.controller;

import az.itcity.etaskify.dto.OrganizationDto;
import az.itcity.etaskify.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private OrganizationService organizationService;

    public RegistrationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDto signUp(@RequestBody OrganizationDto organizationDto){
        return organizationService.create(organizationDto);
    }
}
