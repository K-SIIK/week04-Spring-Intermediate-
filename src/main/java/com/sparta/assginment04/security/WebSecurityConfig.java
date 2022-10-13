package com.sparta.assginment04.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // @Configuration을 클래스에 선언하면 스프링 프레임워크가 빈을 주입하는 클래스로 인식하는것 같다.
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
//@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 활성화
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean // 빈으로 등록해서 스프링 프레임워크가  인코딩할 수 있도록 해줌 -> @.Autowired 로 의존성 주입 가능해짐
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
//        // CSRF -> Cross Site Request Forgery  해킹 비슷한거
//        http.csrf()
//                .ignoringAntMatchers("/user/**");
//
//        http.authorizeRequests()
//                // 어떤 요청이든 '인증'
////                .anyRequest().authenticated()
//                .and()
//                // 로그인 기능 허용
//                .formLogin()// 로그인 기능 작동
//                .loginPage("/user/login") // 로그인 페이지
//                .defaultSuccessUrl("/")// 로그인 성공시 이동하는 페이지
//                .failureUrl("/user/login?page") // 로그인 실패 시 이동하는 페이지
//                .permitAll()
//                .and()
//                // 로그아웃 기능 허용
//                .logout()
//                .permitAll();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable();
    }
}
