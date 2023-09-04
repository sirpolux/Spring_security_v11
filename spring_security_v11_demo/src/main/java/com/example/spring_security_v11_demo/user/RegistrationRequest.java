package com.example.spring_security_v11_demo.user;

import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role){
}
