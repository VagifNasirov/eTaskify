package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.OrganizationDto;
import az.itcity.etaskify.dto.UserDto;
import az.itcity.etaskify.entity.Organization;

public interface OrganizationService {

    OrganizationDto create(OrganizationDto organizationDto);

    Organization getMyOrganization();
}
