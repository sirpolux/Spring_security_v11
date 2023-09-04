package com.example.spring_security_v11_demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices implements  IUserServices{
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User registerUser(RegistrationRequest registrationRequest) {
        Optional<User> isRegistered=this.findByEmail(registrationRequest.email());
        if(isRegistered.isPresent()){
            throw new EmailAlreadyExistException("User with email address exists");
        }
        User user =  new User();
        user.setFirstName(registrationRequest.firstName());
        user.setLastName(registrationRequest.lastName());
        user.setEmail(registrationRequest.email());
        user.setRole(registrationRequest.role());
        user.setPassword(passwordEncoder.encode(registrationRequest.password()));
        return userRepository.save(user);
    }
}
