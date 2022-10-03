/**
 * 
 */
package com.shurjomukhi.logserver.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Web security configuration
 * 
 * @author Mahmudul Hasan Rana
 * @since 2022-10-03
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${spring.security.user.name}")
    private String username;
     
    @Value("${spring.security.user.password}")
    private String password;
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(username).password(password).roles("ACTUATOR","ADMIN").build());
         
        http.antMatcher("/manage/**").authorizeRequests().anyRequest().hasRole("ACTUATOR").and().httpBasic()
                .and().userDetailsService(manager);
    }

}
