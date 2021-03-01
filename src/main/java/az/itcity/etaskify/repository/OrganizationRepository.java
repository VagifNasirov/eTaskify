package az.itcity.etaskify.repository;

import az.itcity.etaskify.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    //String getOrganizationById(Long id);
}
