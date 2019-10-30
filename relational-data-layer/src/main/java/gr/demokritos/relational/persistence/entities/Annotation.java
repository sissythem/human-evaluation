package gr.demokritos.relational.persistence.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ANNOTATIONS")
@DynamicUpdate
@DynamicInsert
public class Annotation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "TEXT_ID")
    private Text text;

    @OneToMany(mappedBy = "annotation")
    private List<Grade> grades = new ArrayList<>();

    public Annotation() {

    }

    public Annotation(User user, Text text) {
        this.user = user;
        this.text = text;
    }

    public Annotation(Long id, User user, Text text) {
        this.id = id;
        this.user = user;
        this.text = text;
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

    @Override
    public String toString() {
        return "Annotation{" +
                "user=" + user +
                ", text=" + text +
                ", id=" + id +
                '}';
    }
}
