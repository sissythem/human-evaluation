package gr.demokritos.mongodb.persistence.repositories;

import gr.demokritos.mongodb.persistence.entities.Characteristic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicMongoRepository extends MongoRepository<Characteristic, String> {
    @Query("{'name' : ?0}")
    Characteristic findByName(@Param("name") String name);
}
