package gr.demokritos.serviceInterfaces;

import gr.demokritos.dtos.AnnotationDto;

import java.util.List;

public interface AnnotationService {

    AnnotationDto saveAnnotation(AnnotationDto annotationDto);
    AnnotationDto updateAnnotation(AnnotationDto annotationDto);
    void deleteAnnotation(AnnotationDto annotationDto);
    AnnotationDto getAnnotationById(Long id);
    List<AnnotationDto> getAllAnnotations();
    List<AnnotationDto> getAllAnnotationsByUserEmail(String email);
    List<AnnotationDto> getAllAnnotationsByTextId(Long textId);
}
