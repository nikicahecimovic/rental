package com.vhs.rental.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @NotNull(message = "User username cannot be null!")
    private String username;

    @Column
    @NotNull(message = "User password cannot be null!")
    private String password;

    @Column
    @NotNull(message = "User role cannot be null!")
    private String role;

    @Column
    @NotNull(message = "User must have an active status!")
    private boolean active;

}
