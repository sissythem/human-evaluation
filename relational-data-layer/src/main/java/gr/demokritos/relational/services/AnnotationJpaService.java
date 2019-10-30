package gr.demokritos.relational.services;

import gr.demokritos.dtos.AnnotationDto;
import gr.demokritos.relational.persistence.entities.Annotation;
import gr.demokritos.relational.persistence.repositories.AnnotationJpaRepository;
import gr.demokritos.relational.utils.Constants;
import gr.demokritos.serviceInterfaces.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotationJpaService implements AnnotationService {

    @Autowired
    @Qualifier(Constants.RELATIONAL_MAPPER_SERVICE)
    private RelationalMapperService relationalMapperService;

    @Autowired
    private AnnotationJpaRepository repo;

    public AnnotationDto saveAnnotation(AnnotationDto annotationDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    public AnnotationDto updateAnnotation(AnnotationDto annotationDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(annotationDto, Annotation.class)), AnnotationDto.class);
    }

    public void deleteAnnotation(AnnotationDto annotationDto) {
        repo.delete(relationalMapperService.getEntity(annotationDto, Annotation.class));
    }

    public AnnotationDto getAnnotationById(Long id) {
        return relationalMapperService.getDto(repo.findById(id), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotations() {
        return relationalMapperService.getDtos(repo.findAll(), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotationsByUserEmail(String email) {
        return relationalMapperService.getDtos(repo.findAllByUserEmail(email), AnnotationDto.class);
    }

    public List<AnnotationDto> getAllAnnotationsByTextId(Long textId) {
        return relationalMapperService.getDtos(repo.findAllByTextId(textId), AnnotationDto.class);
    }
}
