package az.itcity.etaskify.repository;

import az.itcity.etaskify.entity.Organization;
import az.itcity.etaskify.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByOrganization(Organization organization);
}
