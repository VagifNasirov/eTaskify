package az.itcity.etaskify.mapper;

import az.itcity.etaskify.dto.OrganizationDto;
import az.itcity.etaskify.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationDtoMapper {

    OrganizationDtoMapper INSTANCE = Mappers.getMapper(OrganizationDtoMapper.class);

    @Mappings(
            value = {
                    @Mapping(source = "name", target = "orgName"),
                    @Mapping(source = "phoneNumber", target = "number")
            }
    )
    OrganizationDto OrganizationToOrganizationDto(Organization organization);

    @Mappings(
            value = {
                    @Mapping(target = "name", source = "orgName"),
                    @Mapping(target = "phoneNumber", source = "number")
            }
    )
    Organization OrganizationDtoToOrganization(OrganizationDto organizationDto);
}
