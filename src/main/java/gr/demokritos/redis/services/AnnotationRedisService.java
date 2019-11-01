package gr.demokritos.redis.services;

import gr.demokritos.commons.dtos.AnnotationDto;
import gr.demokritos.commons.services.AnnotationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationRedisService implements AnnotationService {

    @Override
    public AnnotationDto saveAnnotation(AnnotationDto annotationDto) {
        return null;
    }

    @Override
    public AnnotationDto updateAnnotation(AnnotationDto annotationDto) {
        return null;
    }

    @Override
    public void deleteAnnotation(AnnotationDto annotationDto) {

    }

    @Override
    public AnnotationDto getAnnotationById(Object id) {
        return null;
    }

    @Override
    public List<AnnotationDto> getAllAnnotations() {
        return null;
    }

    @Override
    public List<AnnotationDto> getAllAnnotationsByUserEmail(String email) {
        return null;
    }

    @Override
    public List<AnnotationDto> getAllAnnotationsByTextId(Object textId) {
        return null;
    }
}
