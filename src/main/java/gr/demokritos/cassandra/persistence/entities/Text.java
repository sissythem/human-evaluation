package gr.demokritos.cassandra.persistence.entities;

import gr.demokritos.utils.CassandraConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = CassandraConstants.TEXTS)
public class Text extends AbstractEntity {

    @Column(name = "CONTENT")
    private String content;

    public Text() {

    }

    public Text(String content) {
        this.content = content;
    }

    public Text(UUID id, String content) {
        this.id = id;
        this.content = content;
    }
}
