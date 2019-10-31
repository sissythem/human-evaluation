package gr.demokritos.mongodb.persistence.entities;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@DynamicUpdate
public class Choice implements Serializable {

    @Field("number")
    private Integer choiceNumber;
    @Field("description")
    private String choiceDescription;

    public Choice() {

    }

    public Choice(Integer choiceNumber, String choiceDescription) {
        this.choiceNumber = choiceNumber;
        this.choiceDescription = choiceDescription;
    }

    public Integer getChoiceNumber() {
        return choiceNumber;
    }

    public void setChoiceNumber(Integer choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public String getChoiceDescription() {
        return choiceDescription;
    }

    public void setChoiceDescription(String choiceDescription) {
        this.choiceDescription = choiceDescription;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choiceNumber=" + choiceNumber +
                ", choiceDescription='" + choiceDescription + '\'' +
                '}';
    }
}
