package ru.skypro.lessons.springbootbd.weblibrarybd.security;

import org.springframework.security.core.GrantedAuthority;

public class SecurityGrantedAuthorities implements GrantedAuthority {
    private String role;

    public SecurityGrantedAuthorities(Role role) {
        this.role = role.getRole();
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
