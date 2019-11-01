package gr.demokritos.cassandra.services;

import gr.demokritos.commons.dtos.UserDto;
import gr.demokritos.commons.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCassandraService implements UserService {
    @Override
    public UserDto saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(UserDto userDto) {

    }

    @Override
    public UserDto getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
