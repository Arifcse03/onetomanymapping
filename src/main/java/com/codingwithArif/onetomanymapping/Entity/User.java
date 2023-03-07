package com.codingwithArif.onetomanymapping.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "xx_users_t")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xx_user_s")
    @SequenceGenerator(name = "xx_user_s", sequenceName = "xx_user_s", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = true, unique = true)
    private String username;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

