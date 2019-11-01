package gr.demokritos.redis.persistence.repositories;

import gr.demokritos.redis.persistence.entities.Annotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRedisRepository extends CrudRepository<Annotation, Long> {

}
