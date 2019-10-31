package gr.demokritos.restapi.restcontrollers;

import gr.demokritos.commons.dtos.AnnotationDto;
import gr.demokritos.commons.services.AnnotationService;
import gr.demokritos.utils.RestApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annotations")
public class AnnotationController {

    @Autowired
    @Qualifier(RestApiConstants.ANNOTATION_SERVICE)
    private AnnotationService annotationService;

    @PostMapping(value = "/saveAnnotation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotationDto saveAnnotation(@RequestBody AnnotationDto annotationDto) {
        return annotationService.saveAnnotation(annotationDto);
    }

    @PutMapping(value = "/updateAnnotation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotationDto updateAnnotation(@RequestBody AnnotationDto annotationDto) {
        return annotationService.updateAnnotation(annotationDto);
    }

    @DeleteMapping(value = "/deleteAnnotation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteAnnotation(AnnotationDto annotationDto) {
        try {
            annotationService.deleteAnnotation(annotationDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AnnotationDto> getAllAnnotations() {
        return annotationService.getAllAnnotations();
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotationDto getAnnotationById(@RequestParam("id") Object id) {
        return annotationService.getAnnotationById(id);
    }

    @GetMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AnnotationDto> getAllAnnotationsByUserEmail(@RequestParam("email") String email) {
        return annotationService.getAllAnnotationsByUserEmail(email);
    }

    @GetMapping(value = "/textId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AnnotationDto> getAllAnnotationsByTextId(@RequestParam("textId") Object textId) {
        return annotationService.getAllAnnotationsByTextId(textId);
    }
}
