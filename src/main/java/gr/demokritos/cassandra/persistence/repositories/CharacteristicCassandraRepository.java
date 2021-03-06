package gr.demokritos.cassandra.persistence.repositories;

import gr.demokritos.cassandra.persistence.entities.Characteristic;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacteristicCassandraRepository extends CassandraRepository<Characteristic, UUID> {
}
