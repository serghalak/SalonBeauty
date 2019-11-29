package com.salon.security;


import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public SecurityConfig(UserDetailsService userDetailsService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*.cors().and()*/
                .csrf().disable()
                    .authorizeRequests()
                    //.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
                    .antMatchers("/**").permitAll()
                    //.antMatchers(HttpMethod.GET,SecurityConstants.SIGN_UP_URL).permitAll()
                /*.antMatchers(HttpMethod.GET, SecurityConstants.VERIFICATION_EMAIL_URL)
                .permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_REQUEST_URL)
                .permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_URL)
                .permitAll()
                .antMatchers(SecurityConstants.H2_CONSOLE)
                .permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*//**", "/webjars/**")
                .permitAll()*/
                .anyRequest().authenticated();
                //.and().addFilter(new AuthenticationFilter(authenticationManager()));
//                .and().addFilter(getAuthenticationFilter())
//                    .addFilter(new AuthorizationFilter(authenticationManager()));
                /*.and()
                .addFilter(getAuthenticationFilter())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)*/

       /* http.headers().frameOptions().disable();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
//
//
//    public AuthenticationFilter getAuthenticationFilter()throws Exception{
//        final AuthenticationFilter filter=new AuthenticationFilter(authenticationManager());
//        filter.setFilterProcessesUrl("/api/users/login");
//        return filter;
//    }



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
