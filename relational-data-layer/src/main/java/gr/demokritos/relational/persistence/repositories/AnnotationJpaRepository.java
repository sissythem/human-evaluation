package gr.demokritos.relational.persistence.repositories;

import gr.demokritos.relational.persistence.entities.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationJpaRepository extends JpaRepository<Annotation, Long> {

    @Query("select a from Annotation a where a.user.email = :email")
    List<Annotation> findAllByUserEmail(@Param("email") String email);
    @Query("select a from Annotation a where a.text.id = :textId")
    List<Annotation> findAllByTextId(@Param("textId") Long textId);
}
