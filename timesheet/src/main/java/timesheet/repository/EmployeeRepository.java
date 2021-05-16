package timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import timesheet.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @SuppressWarnings("unchecked")
    Employee save(Employee employee);

    @Query("select e from Employee e where e.user.username = :username")
    Employee findByUsername(@Param("username") String username);

    @Query("select e from Employee e where e.user.firstname = :firstName and e.user.lastname = :lastName")
    Employee findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select p.employees from Project p where p.name = :projectName")
    List<Employee> findEmployeeListByProject(@Param("projectName") String projectName);
}
