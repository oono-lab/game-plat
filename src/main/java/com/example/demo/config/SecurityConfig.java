package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/signup", "/login", "/css/**", "/js/**").permitAll() // 公開ページ
                .anyRequest().authenticated() // その他はログイン必須
            )
            .formLogin(form -> form
                .loginPage("/login") // カスタムログインページ
                .defaultSuccessUrl("/", true) // 成功後トップへ
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // ログアウト後
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
