package com.example.security_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User1 implements UserDetails{

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String passowrd;

    private String roles;

    @Transient
    private List<GrantedAuthority> authorities;

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.passowrd;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
//        this.authorities = new ArrayList<>();
        this.authorities = Arrays.asList(
                new SimpleGrantedAuthority("ROLE_"+this.roles));

        return this.authorities;


    }
    public User1(String iusername, String ipassword, String irole){

        this(Long.valueOf(0), iusername, ipassword, irole, null);


    }
}