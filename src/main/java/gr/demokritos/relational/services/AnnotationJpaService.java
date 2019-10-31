package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.AnnotationDto;
import gr.demokritos.commons.dtos.GradeDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.Annotation;
import gr.demokritos.relational.persistence.entities.Grade;
import gr.demokritos.relational.persistence.repositories.AnnotationJpaRepository;
import gr.demokritos.commons.services.AnnotationService;
import gr.demokritos.relational.persistence.repositories.GradeJpaRepository;
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
    private GradeJpaRepository gradeRepo;

    @Autowired
    private AnnotationJpaRepository repo;

    /** Annotations **/
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

    /** Grades **/

    public GradeDto saveGrade(GradeDto gradeDto) {
        return mapperService.getDto(gradeRepo.save(mapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public GradeDto updateGrade(GradeDto gradeDto) {
        return mapperService.getDto(gradeRepo.save(mapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public void deleteGrade(GradeDto gradeDto) {
        gradeRepo.delete(mapperService.getEntity(gradeDto, Grade.class));
    }

    public GradeDto getGradeById(Long id) {
        return mapperService.getDto(gradeRepo.findById(id), GradeDto.class);
    }

    public List<GradeDto> getAllGrades() {
        return mapperService.getDtos(gradeRepo.findAll(), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByCharacteristic(String characteristicName) {
        return mapperService.getDtos(gradeRepo.findAllByCharacteristic(characteristicName), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByAnnotation(Long annotationId) {
        return mapperService.getDtos(gradeRepo.findAllByAnnotation(annotationId), GradeDto.class);
    }
}
