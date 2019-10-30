package gr.demokritos.serviceInterfaces;

import gr.demokritos.dtos.GradeDto;

import java.util.List;

public interface GradeService {

    GradeDto saveGrade(GradeDto gradeDto);
    GradeDto updateGrade(GradeDto gradeDto);
    void deleteGrade(GradeDto gradeDto);
    GradeDto getGradeById(Long id);
    List<GradeDto> getAllGrades();
    List<GradeDto> getAllGradesByCharacteristic(String characteristicName);
    List<GradeDto> getAllGradesByAnnotation(Long annotationId);
}
