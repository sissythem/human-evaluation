package gr.demokritos.relational.services;

import gr.demokritos.commons.dtos.GradeDto;
import gr.demokritos.commons.services.MapperService;
import gr.demokritos.relational.persistence.entities.Grade;
import gr.demokritos.relational.persistence.repositories.GradeJpaRepository;
import gr.demokritos.commons.services.GradeService;
import gr.demokritos.utils.RelationalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeJpaService implements GradeService {

    @Autowired
    @Qualifier(RelationalConstants.MAPPER_SERVICE)
    private MapperService mapperService;

    @Autowired
    private GradeJpaRepository repo;

    public GradeDto saveGrade(GradeDto gradeDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public GradeDto updateGrade(GradeDto gradeDto) {
        return mapperService.getDto(repo.save(mapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public void deleteGrade(GradeDto gradeDto) {
        repo.delete(mapperService.getEntity(gradeDto, Grade.class));
    }

    public GradeDto getGradeById(Long id) {
        return mapperService.getDto(repo.findById(id), GradeDto.class);
    }

    public List<GradeDto> getAllGrades() {
        return mapperService.getDtos(repo.findAll(), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByCharacteristic(String characteristicName) {
        return mapperService.getDtos(repo.findAllByCharacteristic(characteristicName), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByAnnotation(Long annotationId) {
        return mapperService.getDtos(repo.findAllByAnnotation(annotationId), GradeDto.class);
    }
}
