package com.dh.Integrador.Models.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole rol;

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority= new SimpleGrantedAuthority(rol.name());
        return Collections.singletonList(grantedAuthority);
    }

    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {

        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public UserRole getRol() {

        return rol;
    }

    public void setRol(UserRole rol) {

        this.rol = rol;
    }

    public User(String name, String userName, String email, String password, UserRole rol) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public User() {
    }
}
