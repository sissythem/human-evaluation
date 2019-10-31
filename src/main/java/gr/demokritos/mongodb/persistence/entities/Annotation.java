package gr.demokritos.mongodb.persistence.entities;

import gr.demokritos.utils.MongoDbConstants;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Document(MongoDbConstants.ANNOTATIONS)
public class Annotation extends AbstractEntity {

    @DBRef
    @Field("user")
    private User user;
    @DBRef
    @Field("text")
    private Text text;
    @ElementCollection
    @Field("grades")
    private List<Grade> grades = new ArrayList<>();

    public Annotation() {

    }

    public Annotation(User user, Text text, List<Grade> grades) {
        this.user = user;
        this.text = text;
        this.grades = grades;
    }

    public Annotation(String id, User user, Text text, List<Grade> grades) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.grades = grades;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
