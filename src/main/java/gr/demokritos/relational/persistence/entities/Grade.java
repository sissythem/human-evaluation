package gr.demokritos.relational.persistence.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "GRADES")
@DynamicUpdate
@DynamicInsert
public class Grade extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "CHARACTERISTIC_ID")
    private Characteristic characteristic;
    @Column(name = "RATING")
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "ANNOTATION_ID")
    private Annotation annotation;

    public Grade() {

    }

    public Grade(Characteristic characteristic, Integer rating, Annotation annotation) {
        this.characteristic = characteristic;
        this.rating = rating;
        this.annotation = annotation;
    }

    public Grade(Long id, Characteristic characteristic, Integer rating, Annotation annotation) {
        this.id = id;
        this.characteristic = characteristic;
        this.rating = rating;
        this.annotation = annotation;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "characteristic=" + characteristic +
                "annotation=" + annotation +
                ", rating=" + rating +
                ", id=" + id +
                '}';
    }
}
