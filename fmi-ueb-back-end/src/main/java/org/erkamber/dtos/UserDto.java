package org.erkamber.dtos;

import lombok.Data;

@Data
public class UserDto {

    private int id;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserDto(int id, String username, String password, String email, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}