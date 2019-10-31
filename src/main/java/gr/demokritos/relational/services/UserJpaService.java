package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.UserDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.User;
import gr.demokritos.relational.persistence.repositories.UserJpaRepository;
import gr.demokritos.commons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserJpaService implements UserService {

    @Autowired
    private UserJpaRepository repo;

    @Autowired
    private MapperService mapperService;

    public UserDto saveUser(UserDto userDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    public void deleteUser(UserDto userDto) {
        repo.delete(mapperService.getEntity(userDto, User.class));
    }

    public UserDto getUserByUsername(String username) {
        return mapperService.getDto(repo.findByUsername(username), UserDto.class);
    }

    public UserDto getUserByEmail(String email) {
        return mapperService.getDto(repo.findByEmail(email), UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        return mapperService.getDtos(repo.findAll(), UserDto.class);
    }
}
