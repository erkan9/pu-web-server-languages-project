package org.erkamber.mappers;

import org.erkamber.dtos.UserDto;
import org.erkamber.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    /**
     * Method, which is used to Map a UserDto to a User
     *
     * @param userDto UserDto, which is going to be mapped
     * @return Mapped object as User
     */
    public User mapUserDtoToUser(UserDto userDto) {

        return new User(userDto.getId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), userDto.getPhoneNumber());
    }

    /**
     * Method, which is used to Map a User to a UserDto
     *
     * @param user User, which is going to be mapped
     * @return Mapped object as UserDto
     */
    public UserDto mapUserToUserDto(User user) {

        return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber());
    }

    /**
     * Method, which is going to be used Map a List of Users to List of UsersDto
     *
     * @param listOfUsers List of Users, which is going to be mapped.
     * @return Mapped List with UserDto objects.
     */
    public List<UserDto> mapListOfUserToUserDto(List<User> listOfUsers) {

        return listOfUsers.stream().map(this::mapUserToUserDto).collect(Collectors.toList());
    }
}