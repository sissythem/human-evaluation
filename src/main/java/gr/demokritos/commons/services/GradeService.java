package gr.demokritos.commons.services;

import gr.demokritos.commons.dtos.GradeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {

    GradeDto saveGrade(GradeDto gradeDto);
    GradeDto updateGrade(GradeDto gradeDto);
    void deleteGrade(GradeDto gradeDto);
    GradeDto getGradeById(Long id);
    List<GradeDto> getAllGrades();
    List<GradeDto> getAllGradesByCharacteristic(String characteristicName);
    List<GradeDto> getAllGradesByAnnotation(Long annotationId);
}
