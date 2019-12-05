package com.salon.security;


import com.salon.services.UserService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public SecurityConfig(UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                .antMatchers("/","/api/users","/api/users/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    /*.addFilter(new AuthenticationFilter(authenticationManager()));*/
                    .addFilter(getAuthenticationFilter());
                //.and().addFilter());
//                .and().addFilter(getAuthenticationFilter())
//                    .
                /*.and()

                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)*/

       /* http.headers().frameOptions().disable();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


    public AuthenticationFilter getAuthenticationFilter()throws Exception{
        final AuthenticationFilter filter=new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/api/users/login");
        return filter;
    }



//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/css/**", "/index").permitAll()
//                /*.anyRequest().authenticated();*/
//                /*.antMatchers("/api/**").hasRole("USER")*/
//                .anyRequest().authenticated()
//                /*.and()
//                .formLogin()*/
//                /*.loginPage("/login").failureUrl("/login-error")*/;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("serg").password("1").roles("USER");
//    }
}
