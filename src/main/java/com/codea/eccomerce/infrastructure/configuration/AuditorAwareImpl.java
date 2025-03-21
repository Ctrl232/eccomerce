package com.codea.eccomerce.infrastructure.configuration;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("🔴 Usuario NO autenticado");
            return Optional.empty();
        }

        System.out.println("🟢 Usuario autenticado: " + authentication.getName());
        return Optional.of(authentication.getName());
    }
}

