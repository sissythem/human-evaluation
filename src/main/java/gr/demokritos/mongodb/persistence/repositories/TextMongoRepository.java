package gr.demokritos.mongodb.persistence.repositories;

import gr.demokritos.mongodb.persistence.entities.Text;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMongoRepository extends MongoRepository<Text, String> {

}
