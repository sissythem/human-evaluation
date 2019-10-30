package gr.demokritos.relational.services;

import gr.demokritos.dtos.GradeDto;
import gr.demokritos.relational.persistence.entities.Grade;
import gr.demokritos.relational.persistence.repositories.GradeJpaRepository;
import gr.demokritos.relational.utils.Constants;
import gr.demokritos.serviceInterfaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeJpaService implements GradeService {

    @Autowired
    @Qualifier(Constants.RELATIONAL_MAPPER_SERVICE)
    private RelationalMapperService relationalMapperService;

    @Autowired
    private GradeJpaRepository repo;

    public GradeDto saveGrade(GradeDto gradeDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public GradeDto updateGrade(GradeDto gradeDto) {
        return relationalMapperService.getDto(repo.save(relationalMapperService.getEntity(gradeDto, Grade.class)), GradeDto.class);
    }

    public void deleteGrade(GradeDto gradeDto) {
        repo.delete(relationalMapperService.getEntity(gradeDto, Grade.class));
    }

    public GradeDto getGradeById(Long id) {
        return relationalMapperService.getDto(repo.findById(id), GradeDto.class);
    }

    public List<GradeDto> getAllGrades() {
        return relationalMapperService.getDtos(repo.findAll(), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByCharacteristic(String characteristicName) {
        return relationalMapperService.getDtos(repo.findAllByCharacteristic(characteristicName), GradeDto.class);
    }

    public List<GradeDto> getAllGradesByAnnotation(Long annotationId) {
        return relationalMapperService.getDtos(repo.findAllByAnnotation(annotationId), GradeDto.class);
    }
}
