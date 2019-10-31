package gr.demokritos.restapi.restcontrollers;

import gr.demokritos.commons.dtos.TextDto;
import gr.demokritos.commons.services.TextService;
import gr.demokritos.utils.RestApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/texts")
public class TextController {

    @Autowired
    @Qualifier(RestApiConstants.TEXT_SERVICE)
    private TextService textService;

    @PostMapping(value = "/saveText", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TextDto saveText(@RequestBody TextDto textDto) {
        return textService.saveText(textDto);
    }

    @PutMapping(value = "/updateText", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TextDto updateText(@RequestBody TextDto textDto) {
        return textService.updateText(textDto);
    }

    @DeleteMapping(value = "/deleteText", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteText(TextDto textDto) {
        try {
            textService.deleteText(textDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TextDto> getAllTexts() {
        return textService.getAllTexts();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TextDto getTextById(@RequestParam("id") Object id) {
        return textService.getTextById(id);
    }
}
