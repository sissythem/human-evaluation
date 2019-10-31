package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(UserDto userDto);
    UserDto getUserByUsername(String username);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
}
