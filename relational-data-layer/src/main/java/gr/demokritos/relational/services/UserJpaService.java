package gr.demokritos.relational.services;

import gr.demokritos.dtos.UserDto;
import gr.demokritos.relational.persistence.entities.User;
import gr.demokritos.relational.persistence.repositories.UserJpaRepository;
import gr.demokritos.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJpaService implements UserService {

    @Autowired
    private UserJpaRepository repo;

    @Autowired
    private RelationalMapperService relationalMapperService;

    public UserDto saveUser(UserDto userDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    public void deleteUser(UserDto userDto) {
        repo.delete(relationalMapperService.getEntity(userDto, User.class));
    }

    public UserDto getUserByUsername(String username) {
        return relationalMapperService.getDto(repo.findByUsername(username), UserDto.class);
    }

    public UserDto getUserByEmail(String email) {
        return relationalMapperService.getDto(repo.findByEmail(email), UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        return relationalMapperService.getDtos(repo.findAll(), UserDto.class);
    }
}
