package gr.demokritos.redis.persistence.repositories;

import gr.demokritos.redis.persistence.entities.Characteristic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRedisRepository extends CrudRepository<Characteristic, Long> {

}
