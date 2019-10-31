package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.AnnotationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnotationService {

    AnnotationDto saveAnnotation(AnnotationDto annotationDto);
    AnnotationDto updateAnnotation(AnnotationDto annotationDto);
    void deleteAnnotation(AnnotationDto annotationDto);
    AnnotationDto getAnnotationById(Object id);
    List<AnnotationDto> getAllAnnotations();
    List<AnnotationDto> getAllAnnotationsByUserEmail(String email);
    List<AnnotationDto> getAllAnnotationsByTextId(Object textId);
}
