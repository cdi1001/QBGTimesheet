package timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import timesheet.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

    User findByUsername(String username);

    @SuppressWarnings("unchecked")
    User save(User user);

}
