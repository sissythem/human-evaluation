package gr.demokritos.mongodb.persistence.repositories;

import gr.demokritos.mongodb.persistence.entities.Annotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotationMongoRepository extends MongoRepository<Annotation, String> {

    @Query("{'user.email' : ?0}")
    List<Annotation> findAllByUserEmail(@Param("email") String email);
    @Query("{'text.id' : ?0}")
    List<Annotation> findAllByTextId(@Param("textId") String textId);
}
