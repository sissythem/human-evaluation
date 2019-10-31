package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.AnnotationDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.Annotation;
import gr.demokritos.relational.persistence.repositories.AnnotationJpaRepository;
import gr.demokritos.commons.services.AnnotationService;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationJpaService implements AnnotationService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private AnnotationJpaRepository repo;

    public AnnotationDto saveAnnotation(AnnotationDto annotationDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    public AnnotationDto updateAnnotation(AnnotationDto annotationDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    public void deleteAnnotation(AnnotationDto annotationDto) {
        repo.delete(mapperService.getEntity(annotationDto, Annotation.class));
    }

    public AnnotationDto getAnnotationById(Long id) {
        return mapperService.getDto(repo.findById(id), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotations() {
        return mapperService.getDtos(repo.findAll(), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotationsByUserEmail(String email) {
        return mapperService.getDtos(repo.findAllByUserEmail(email), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotationsByTextId(Long textId) {
        return mapperService.getDtos(repo.findAllByTextId(textId), AnnotationDto.class);
    }
}
