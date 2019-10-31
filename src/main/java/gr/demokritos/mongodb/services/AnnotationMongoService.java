package gr.demokritos.mongodb.services;

import gr.demokritos.commons.dtos.AnnotationDto;
import gr.demokritos.commons.services.AnnotationService;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.mongodb.persistence.entities.Annotation;
import gr.demokritos.mongodb.persistence.repositories.AnnotationMongoRepository;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationMongoService implements AnnotationService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private AnnotationMongoRepository repo;

    @Override
    public AnnotationDto saveAnnotation(AnnotationDto annotationDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    @Override
    public AnnotationDto updateAnnotation(AnnotationDto annotationDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    @Override
    public void deleteAnnotation(AnnotationDto annotationDto) {
        repo.delete(mapperService.getEntity(annotationDto, Annotation.class));
    }

    @Override
    public AnnotationDto getAnnotationById(Object id) {
        return mapperService.getDto(repo.findById((String)id), AnnotationDto.class);
    }

    @Override
    public List<AnnotationDto> getAllAnnotations() {
        return mapperService.getDtos(repo.findAll(), AnnotationDto.class);
    }

    @Override
    public List<AnnotationDto> getAllAnnotationsByUserEmail(String email) {
        return mapperService.getDtos(repo.findAllByUserEmail(email), AnnotationDto.class);
    }

    @Override
    public List<AnnotationDto> getAllAnnotationsByTextId(Object textId) {
        return mapperService.getDtos(repo.findAllByTextId((String)textId), AnnotationDto.class);
    }
}
