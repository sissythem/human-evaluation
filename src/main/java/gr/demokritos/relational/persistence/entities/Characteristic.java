package gr.demokritos.relational.persistence.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CHARACTERISTICS")
@DynamicUpdate
@DynamicInsert
public class Characteristic extends AbstractEntity {

    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CHOICES")
    private String choices;

    public Characteristic() {

    }

    public Characteristic(String name, String description, String choices) {
        this.name = name;
        this.description = description;
        this.choices = choices;
    }

    public Characteristic(Long id, String name, String description, String choices) {
        this.id = id;
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

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }
}
