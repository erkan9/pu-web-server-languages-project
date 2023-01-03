package org.erkamber.services.implementations;

import org.erkamber.configurations.PasswordEncoder;
import org.erkamber.dtos.UserDto;
import org.erkamber.entities.User;
import org.erkamber.exceptions.InvalidCredentialsException;
import org.erkamber.exceptions.NotFoundException;
import org.erkamber.mappers.UserMapper;
import org.erkamber.repositories.UserRepository;
import org.erkamber.services.interfaces.UserService;
import org.erkamber.validations.UserValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserValidation userValidation;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserValidation userValidation, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Method, which is used for Log in. It calls a method which checks if there is a user with that username and password
     *
     * @param username The username of the user, which is trying to log in
     * @param password The password of the user, which is trying to log in
     */
    @Override
    public void userLogIn(String username, String password) {

        isUserFound(username, password);
    }

    /**
     * Method, which is used to check if there is an existing user with given username and password
     *
     * @param username The username of the user, which is trying to log in
     * @param password The password of the user, which is trying to log in
     */
    private void isUserFound(String username, String password) {

        boolean isUserFound = userValidation.isUserFound(username, password, findAllUsers());

        if (!isUserFound) {

            throw new NotFoundException("User Not Found!");
        }
    }

    /**
     * Method, which is used for user registration. Calls validation method and if exception is not thrown,
     * new User is saved in DB
     *
     * @param registeredUserDto Object of the user, which is being registered
     */
    @Override
    public void userRegister(UserDto registeredUserDto) {

        areNewUserCredentialsValid(registeredUserDto);

        User registeredUser = userMapper.mapUserDtoToUser(registeredUserDto);

        String encodedPassword = passwordEncoder.passwordEncoder().encode(registeredUserDto.getPassword());

        registeredUser.setPassword(encodedPassword);

        userRepository.save(registeredUser);
    }

    /**
     * Method, which is used to check if the new user credentials are valid.
     *
     * @param registeredUserDto Object of the user, which wants to register.
     */
    private void areNewUserCredentialsValid(UserDto registeredUserDto) {

        boolean isUsernameValid = userValidation.isUsernameCorrect(registeredUserDto.getUsername());

        boolean isPasswordValid = userValidation.isPasswordCorrect(registeredUserDto.getPassword());

        boolean isEmailValid = userValidation.isEmailCorrect(registeredUserDto.getEmail());

        boolean isPhoneNumberValid = userValidation.isPhoneNumberCorrect(registeredUserDto.getPhoneNumber());

        if (!isUsernameValid) {

            throw new InvalidCredentialsException("Invalid Username!");

        } else if (!isPasswordValid) {

            throw new InvalidCredentialsException("Invalid Password!");

        } else if (!isEmailValid) {

            throw new InvalidCredentialsException("Invalid Email!");

        } else if (registeredUserDto.getPhoneNumber() != null && !isPhoneNumberValid) {

            throw new InvalidCredentialsException("Invalid Phone Number!");
        }
    }

    /**
     * Method, which is used to find a User by ID and return it.
     *
     * @param searchedUserID ID of the user, which is being searched.
     * @return Dto object of the user
     */
    @Override
    public UserDto findUserByID(int searchedUserID) {

        Optional<User> user = userRepository.findById(searchedUserID);

        return userMapper.mapUserToUserDto(user.orElseThrow(() -> new NotFoundException("User NOT Found!")));
    }

    /**
     * Method, which is used the get All the Users
     *
     * @return List of all the Users as DTO
     */
    @Override
    public List<UserDto> getAllUsers() {

        List<User> allUsers = findAllUsers();

        return userMapper.mapListOfUserToUserDto(allUsers);
    }

    /**
     * Method, which is used to get all the Users from the DB
     *
     * @return List of the users
     */
    private List<User> findAllUsers() {

        return userRepository.findAll();
    }
}