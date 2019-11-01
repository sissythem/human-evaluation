package gr.demokritos.cassandra.persistence.repositories;

import gr.demokritos.cassandra.persistence.entities.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCassandraRepository extends CassandraRepository<User, UUID> {

    @Query("SELECT * FROM users where username=?0")
    User findByUsername(String username);
    @Query("SELECT * FROM users where email=?0")
    User findByEmail(String email);
}
