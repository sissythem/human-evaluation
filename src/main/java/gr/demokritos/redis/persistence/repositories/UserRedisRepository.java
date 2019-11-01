package gr.demokritos.redis.persistence.repositories;

import gr.demokritos.redis.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRedisRepository extends CrudRepository<User, Long> {
}
