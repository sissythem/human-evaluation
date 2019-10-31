package gr.demokritos.mongodb.persistence.entities;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@DynamicUpdate
public class Grade implements Serializable {

    @Field("characteristic")
    private String characteristic;
    @Field("rating")
    private Integer rating;

}
