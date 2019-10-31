package gr.demokritos.restapi.restcontrollers;

import gr.demokritos.commons.dtos.CharacteristicDto;
import gr.demokritos.commons.services.CharacteristicService;
import gr.demokritos.utils.RestApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characteristics")
public class CharacteristicController {

    @Autowired
    @Qualifier(RestApiConstants.CHARACTERISTIC_SERVICE)
    private CharacteristicService characteristicService;

    @PostMapping(value = "/saveCharacteristic", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CharacteristicDto saveText(@RequestBody CharacteristicDto characteristicDto) {
        return characteristicService.saveCharacteristic(characteristicDto);
    }

    @PutMapping(value = "/updateCharacteristic", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CharacteristicDto updateCharacteristic(@RequestBody CharacteristicDto characteristicDto) {
        return characteristicService.updateCharacteristic(characteristicDto);
    }

    @DeleteMapping(value = "/deleteCharacteristic", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteCharacteristic(CharacteristicDto characteristicDto) {
        try {
            characteristicService.deleteCharacteristic(characteristicDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CharacteristicDto> getAllCharacteristics() {
        return characteristicService.getAllCharacteristics();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CharacteristicDto getCharacteristicById(@RequestParam("id") Object id) {
        return characteristicService.getCharacteristicById(id);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CharacteristicDto getCharacteristicByName(@RequestParam("name") String name) {
        return characteristicService.getCharacteristicByName(name);
    }
}
