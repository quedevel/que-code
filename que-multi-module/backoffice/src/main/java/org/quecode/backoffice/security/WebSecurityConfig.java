package org.quecode.backoffice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider provider;

    /**
     * 정적 파일의 경우, 인증/인가 절차를 무시하도록 설정
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// csrf 설정
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/","/index").authenticated()
                .antMatchers("/sample/**").permitAll()  // test용 sample 페이지 전체 허용
                .anyRequest()
                .permitAll()
//                .access("@authorizationChecker.check(request, authentication)")// URL 접근 처리 ( cash 처리 필요 )
//            .and()
//                .exceptionHandling()
//                .accessDeniedPage("/login")    // 권한 없는 유저 페이지
                .and()
                .authenticationProvider(provider)
                .formLogin()
                .loginPage("/login")
                //.successHandler(successHandler())
                //.loginProcessingUrl("/authenticateUser")
                .usernameParameter("username")   // 아이디 파라미터 name
                .passwordParameter("password")        // 비밀번호 파라미터 name
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그 아웃  URL
                .logoutSuccessUrl("/login") // 로그 아웃 후 URL
                .invalidateHttpSession(true) // 세션 만료
        ;
    }
}
