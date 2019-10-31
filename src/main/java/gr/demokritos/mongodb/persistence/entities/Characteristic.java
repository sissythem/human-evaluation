package gr.demokritos.mongodb.persistence.entities;

import gr.demokritos.utils.MongoDbConstants;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Document(MongoDbConstants.CHARACTERISTICS)
public class Characteristic extends AbstractEntity {

    @Field("name")
    private String name;
    @Field("description")
    private String description;
    @ElementCollection
    @Field("choices")
    private List<Choice> choices;

    public Characteristic() {

    }

    public Characteristic(String name, String description, List<Choice> choices) {
        this.name = name;
        this.description = description;
        this.choices = choices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "Characteristic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", choices=" + choices +
                ", id='" + id + '\'' +
                '}';
    }
}
