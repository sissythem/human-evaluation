package gr.demokritos.mongodb.persistence.entities;

import gr.demokritos.utils.MongoDbConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.Entity;

@Entity
@Document(MongoDbConstants.USERS)
@DynamicUpdate
@DynamicInsert
public class User extends AbstractEntity {

    @Field("name")
    private String name;
    @Field("lastName")
    private String lastName;
    @Field("email")
    private String email;
    @Field("username")
    private String username;
    @Field("password")
    private String password;

    public User() {

    }

    public User(String name, String lastName, String email,
                String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String id, String name, String lastName,
                String email, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", _id='" + id + '\'' +
                '}';
    }
}
