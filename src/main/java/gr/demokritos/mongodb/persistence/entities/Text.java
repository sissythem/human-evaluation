package gr.demokritos.mongodb.persistence.entities;

import gr.demokritos.utils.MongoDbConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;

@Entity
@Document(MongoDbConstants.TEXTS)
@DynamicUpdate
@DynamicInsert
public class Text extends AbstractEntity {

    @Field(name = "Content")
    private String content;

    public Text() {

    }

    public Text(String content) {
        this.content = content;
    }

    public Text(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Text{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
