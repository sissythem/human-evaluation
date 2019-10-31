package gr.demokritos.mongodb.persistence.repositories;

import gr.demokritos.mongodb.persistence.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {

    @Query("{'username' : ?0}")
    User findByUsername(@Param("username") String username);
    @Query("{'email' : ?0}")
    User findByEmail(String email);

}
