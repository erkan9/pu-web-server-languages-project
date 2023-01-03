package org.erkamber.controllers;

import org.erkamber.dtos.UserDto;
import org.erkamber.services.interfaces.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method, which is used to Register a new user in the DB
     *
     * @param registeredUserDto DTO of the User, which is being registered
     */
    @PostMapping("/users")
    public void addNewUser(@Valid @RequestBody UserDto registeredUserDto) {

        userService.userRegister(registeredUserDto);
    }

    /**
     * Method, which is used to Log in
     *
     * @param username Username of the user, which is trying to log in
     * @param password Password of the user, which is trying to log in
     */
    @PostMapping(value = "/users/login", params = {"username", "password"})
    public void userLogIn(@RequestParam(name = "username")
                          String username,
                          @RequestParam(name = "password")
                          String password) {

        userService.userLogIn(username, password);
    }

    /**
     * Method, which is used to find a User by ID
     *
     * @param id ID of the user, which is being searched
     * @return The DTO object of the searched User
     */
    @GetMapping(value = "/users/byID", params = {"id"})
    public UserDto getUserByID(@RequestParam(name = "id")
                               int id) {

        return userService.findUserByID(id);
    }

    /**
     * Method, which is used to get all the users
     *
     * @return List of all Users as DTO object
     */
    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {

        return userService.getAllUsers();
    }
}