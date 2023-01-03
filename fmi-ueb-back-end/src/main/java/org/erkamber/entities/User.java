package org.erkamber.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, updatable = false, insertable = false, nullable = false)
    private int id;

    @Column(name = "username", unique = true, updatable = true, insertable = true, nullable = false)
    private String username;

    @Column(name = "password", unique = false, updatable = true, insertable = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, updatable = true, insertable = true, nullable = false)
    private String email;

    @Column(name = "phone", unique = false, updatable = true, insertable = true, nullable = true)
    private String phoneNumber = null;

    public User() {
    }

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(int id, String username, String password, String email, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}