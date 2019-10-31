package gr.demokritos.relational.persistence.repositories;

import gr.demokritos.relational.persistence.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextJpaRepository extends JpaRepository<Text, Long> {

}
