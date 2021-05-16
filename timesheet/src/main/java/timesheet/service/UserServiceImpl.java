package timesheet.service;

import java.util.ArrayList;
import java.util.List;

import timesheet.constant.Constants;
import timesheet.model.Manager;
import timesheet.model.User;
import timesheet.repository.ManagerRepository;
import timesheet.repository.UserRepository;
import timesheet.utility.StringProecessUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager getManagerByUsername(String username) {
        Manager manager = managerRepository.findByUsername(username);
        if (manager == null)
            throw new IllegalStateException("Manager entity not found for username: " + username);
        return manager;
    }
    
    /**
     * return the primary key for the user entity. return 0 if the user name already exists.
     * Save entity manager. User will be saved as well, due to cascade type ALL.
     *
     */
    @Override
    public Long registerNewManager(User user) {
        if (user == null)
            throw new IllegalArgumentException("user is null");
        Manager manager = new Manager();
        manager.setUser(user);
        try {
            managerRepository.save(manager);
        } catch (DataIntegrityViolationException e) {
            logger.error("Username exists.", e.getMessage());
            return 0l;
        }
        return user.getUserId();
    }

    @Override
    public Long updateUser(User userNew) {
        if (userNew == null)
            throw new IllegalArgumentException("user is null");

        User user = getUserByUsername(userNew.getUsername());
        user.setEmail(userNew.getEmail());
        user.setFirstname(userNew.getFirstname());
        user.setLastname(userNew.getLastname());
        user.setOrganization(userNew.getOrganization());
        user.setPassword(userNew.getPassword());
        user = userRepository.save(user);

        return user.getUserId();
    }
    
    @Override
    public String resetPasswordFor(String username) {
        User user = getUserByUsername(username);
        String password = StringProecessUtil.randomString(8);
        user.setPassword(password);
        userRepository.save(user);
        return password;
    }
    
    @Override
    public void disableUser(String username) {
        User user = getUserByUsername(username);
        user.setEnabled(false);
        userRepository.save(user);
    }
    
    /**
     * Spring security method.
     * Check user password, enable indicator, expired indicator and roles.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);

        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        if (user.getRole().equals(Constants.ROLE_EMPLOYEE))
            authorityList.add(new SimpleGrantedAuthority(Constants.ROLE_EMPLOYEE));
        if (user.getRole().equals(Constants.ROLE_MANAGER))
            authorityList.add(new SimpleGrantedAuthority(Constants.ROLE_MANAGER));

        return new org.springframework.security.core.userdetails.User(
                username, user.getPassword(), user.getEnabled(), !user.getExpired(), true, true, authorityList);
    }

    @Override
    public User getUserByUsername(String username) {
        User user =userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found.");
        return user;
    }
}
