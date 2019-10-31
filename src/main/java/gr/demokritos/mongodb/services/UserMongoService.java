package gr.demokritos.mongodb.services;

import gr.demokritos.commons.dtos.UserDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.commons.services.UserService;
import gr.demokritos.mongodb.persistence.entities.User;
import gr.demokritos.mongodb.persistence.repositories.UserMongoRepository;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMongoService implements UserService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private UserMongoRepository repo;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(userDto, User.class)), UserDto.class);
    }

    @Override
    public void deleteUser(UserDto userDto) {
        repo.delete(mapperService.getEntity(userDto, User.class));
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return mapperService.getDto(repo.findByUsername(username), UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return mapperService.getDto(repo.findByEmail(email), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return mapperService.getDtos(repo.findAll(), UserDto.class);
    }
}
