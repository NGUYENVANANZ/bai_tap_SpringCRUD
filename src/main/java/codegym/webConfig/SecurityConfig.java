package codegym.webConfig;


import codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .and().authorizeRequests().antMatchers("/user").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .and().authorizeRequests().antMatchers("/show", "/edit", "/create", "/delete").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").successHandler(new SuccessHandler())
                .and().logout().logoutUrl("/logout");
        http.csrf().disable();
    }
}