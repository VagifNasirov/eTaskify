package az.itcity.etaskify.service;

import az.itcity.etaskify.dto.OrganizationDto;
import az.itcity.etaskify.entity.Organization;
import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.mapper.OrganizationDtoMapper;
import az.itcity.etaskify.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository;
    private UserPrincipalService userPrincipalService;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, UserPrincipalService userPrincipalService) {
        this.organizationRepository = organizationRepository;
        this.userPrincipalService = userPrincipalService;
    }

    @Override
    public OrganizationDto create(OrganizationDto organizationDto) {
        Organization organization = OrganizationDtoMapper.INSTANCE.OrganizationDtoToOrganization(organizationDto);

        return OrganizationDtoMapper.INSTANCE.OrganizationToOrganizationDto(organizationRepository.save(organization));
    }

    @Override
    public Organization getMyOrganization() {

        User user = userPrincipalService.getUser();
        return user.getOrganization();
    }
}
