package com.example.security_1;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Dataloader {

    private final PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    private final UserRepository uRepository;
    @jakarta.annotation.PostConstruct
    private void load(){
        uRepository.deleteAll();
//        DelegatingPasswordEncoder passwordEncoder1 =
//                (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();

        Map<String, PasswordEncoder> encords = new HashMap<>();
        encords.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        DelegatingPasswordEncoder d1 = new DelegatingPasswordEncoder("pbkdf2", encords);

        Iterable<User1> uu = List.of(new User1("peter",d1.encode("ppassword") , "USER"),
                new User1("john", d1.encode("jpassword"), "ADMIN"));
        uRepository.saveAll(uu);

    }
}
