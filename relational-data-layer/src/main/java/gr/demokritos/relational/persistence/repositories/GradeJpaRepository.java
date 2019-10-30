package gr.demokritos.relational.persistence.repositories;

import gr.demokritos.relational.persistence.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeJpaRepository extends JpaRepository<Grade, Long> {

    @Query("select g from Grade g where g.characteristic.name = :characteristicName")
    List<Grade> findAllByCharacteristic(@Param("characteristicName") String characteristicName);
    @Query("select g from Grade g where g.annotation.id = :annotationId")
    List<Grade> findAllByAnnotation(@Param("annotationId") Long annotationId);
}
