package az.itcity.etaskify.repository;

import az.itcity.etaskify.entity.Organization;
import az.itcity.etaskify.entity.User;
import az.itcity.etaskify.role.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByOrganizationAndAndRole(Organization organization, Roles role);
    Optional<User> getUserByEmail(String email);
}
