package com.example.giraexam.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String email;
    private boolean isAnonymous;

    public String getUsername() {
        return email;
    }

    public CurrentUser setUsername(String username) {
        this.email = username;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isAnonymous() {
        return this.id==null;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
        return this;
    }
}
