package gr.demokritos.redis.persistence.repositories;

import gr.demokritos.redis.persistence.entities.Text;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRedisRepository extends CrudRepository<Text, Long> {

}
