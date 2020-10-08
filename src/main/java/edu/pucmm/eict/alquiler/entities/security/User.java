package edu.pucmm.eict.alquiler.entities.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String name;
    private boolean active;
    private String roles;

    public User() { }

    public User(String username, String password, String name, String roles){
        this.username = username;
        this.password = password;
        this.name = name;
        this.active = true;
        this.roles = roles;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getRoles() { return roles; }

    public void setRoles(String roles) { this.roles = roles; }
}