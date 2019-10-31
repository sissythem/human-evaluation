package gr.demokritos.relational.persistence.repositories;

import gr.demokritos.relational.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
