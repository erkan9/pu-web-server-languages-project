package org.erkamber.validations;

import org.erkamber.configurations.PasswordEncoder;
import org.erkamber.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class UserValidation {

    private final PasswordEncoder passwordEncoder;

    public UserValidation(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Method. which is used to check if a User by Username and Password is Found.
     *
     * @param username Username of the searched user
     * @param password Password of the searched user
     * @param allUsers List of all Users
     * @return Boolean. True if user is found. False if not
     */
    public boolean isUserFound(String username, String password, List<User> allUsers) {

        return allUsers.stream().anyMatch(user -> user.getUsername().equals(username) &&
                passwordEncoder.passwordEncoder().matches(password, user.getPassword()));
    }

    /**
     * Method, which is used to validate if the Username Format is Valid/Correct
     *
     * @param username Username, which is being validated
     * @return Boolean if Username is Valid or Not
     */
    public boolean isUsernameCorrect(String username) {

        String usernamePattern = "([A-Za-z_]{5,15})\\w+";

        return Pattern.compile(usernamePattern).matcher(username).matches();
    }

    /**
     * Method, which is used to validate if the Password Format is Valid/Correct
     *
     * @param password Password, which is being validated.
     * @return Boolean if the Password is Valid or Not.
     */
    public boolean isPasswordCorrect(String password) {

        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@-_~])[A-Za-z@-_~|]{6,20}$";

        return Pattern.compile(passwordPattern).matcher(password).matches();
    }

    /**
     * Method, which is used to validate if the Email Format is Valid/Correct
     *
     * @param email Email, which is being validated.
     * @return Boolean if the Email is Valid or Not.
     */
    public boolean isEmailCorrect(String email) {

        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        return Pattern.compile(emailPattern).matcher(email).matches();
    }

    /**
     * Method, which is used to validate if the Phone Number Format is Valid/Correct
     *
     * @param phoneNumber Phone Number, which is being validated.
     * @return Boolean if the Phone Number is Valid or Not.
     */
    public boolean isPhoneNumberCorrect(String phoneNumber) {

        String phoneNumberPattern = "^\\d{3}?[- ]?\\d{3}[- ]?\\d{4}$";

        return Pattern.compile(phoneNumberPattern).matcher(phoneNumber).matches();
    }
}