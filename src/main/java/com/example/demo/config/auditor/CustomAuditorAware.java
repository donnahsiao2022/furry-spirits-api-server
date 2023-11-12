package com.example.demo.config.auditor;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String loggedName = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.ofNullable(loggedName);
    }

}
