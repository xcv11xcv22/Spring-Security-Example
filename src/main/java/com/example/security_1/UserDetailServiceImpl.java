package com.example.security_1;

import java.util.List;
import java.util.Optional;

// import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository uRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User1 u = new User1();
        // u.setUsername(username);
        // List<User1> u111 = uRepository.findAll();
        // List<User1> u11 = uRepository.findAll(Example.of(u));
        // u11.if
        User1 uuu = uRepository.findByUser(username);
        // return u11.get();
        // u11n.
        // TODO Auto-generated method stub
        // UserDetails uu = u11.isPresent() ? u11.get() : null;
        return uuu;
    }
}