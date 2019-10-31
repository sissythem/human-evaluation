package gr.demokritos.relational.persistence.repositories;

import gr.demokritos.relational.persistence.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicJpaRepository extends JpaRepository<Characteristic, Long> {

    Characteristic findByName(@Param("name") String name);

}
