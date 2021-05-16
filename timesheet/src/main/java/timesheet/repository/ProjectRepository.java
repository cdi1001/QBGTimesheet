package timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timesheet.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select e.projects from Employee e where e.employeeId = :employeeId")
    List<Project> findByEmployeeId(@Param("employeeId") Long id);

    @Query("select p from Project p where p.manager.managerId = :managerId")
    List<Project> findByManagerId(@Param("managerId") Long id);

    Project findByName(String name);

    Project save(Project project);
}
