package timesheet.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "timesheet.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder registry) throws Exception {
        registry.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .antMatchers("/admin", "/admin/**").hasRole("MANAGER")
                .antMatchers("/", "/**", "/user", "/user/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                //.failureUrl("/login?error")        default
                .permitAll()
                .and()
                .logout()
                //.logoutSuccessUrl("/login?logout");      default
                .and()
                .exceptionHandling().accessDeniedPage("/permission-deny");
    }
}
