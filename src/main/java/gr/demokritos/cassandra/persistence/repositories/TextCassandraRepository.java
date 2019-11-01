package gr.demokritos.cassandra.persistence.repositories;

import gr.demokritos.cassandra.persistence.entities.Text;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TextCassandraRepository extends CassandraRepository<Text, UUID> {

}
