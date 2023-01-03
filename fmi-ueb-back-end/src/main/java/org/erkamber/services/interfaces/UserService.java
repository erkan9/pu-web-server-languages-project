package org.erkamber.services.interfaces;

import org.erkamber.dtos.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Method, which is used for Log in. It calls a method which checks if there is a user with that username and password
     *
     * @param username The username of the user, which is trying to log in
     * @param password The password of the user, which is trying to log in
     */
    void userLogIn(String username, String password);

    /**
     * Method, which is used for user registration. Calls validation method and if exception is not thrown,
     * new User is saved in DB
     *
     * @param registeredUserDto Object of the user, which is being registered
     */
    void userRegister(UserDto registeredUserDto);

    /**
     * Method, which is used to find a User by ID and return it.
     *
     * @param searchedUserID ID of the user, which is being searched.
     * @return Dto object of the user
     */
    UserDto findUserByID(int searchedUserID);

    /**
     * Method, which is used the get All the Users
     *
     * @return List of all the Users as DTO
     */
    List<UserDto> getAllUsers();
}