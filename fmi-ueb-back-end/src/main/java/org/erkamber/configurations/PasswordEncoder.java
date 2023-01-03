package org.erkamber.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

    /**
     * Method, used to return a Password Encoder, which is Bcrypt.
     *
     * @return Object of BCrypt Password Encoder
     */
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}