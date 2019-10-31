package gr.demokritos.restapi.restcontrollers;

import gr.demokritos.commons.dtos.UserDto;
import gr.demokritos.utils.RestApiConstants;
import gr.demokritos.commons.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier(RestApiConstants.USER_SERVICE)
    private UserService userService;

    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping(value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteUser(UserDto userDto) {
        try {
            userService.deleteUser(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/username", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }
}
