package gr.demokritos.relational.persistence.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
@DynamicUpdate
@DynamicInsert
public class User extends AbstractEntity {

    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Annotation> annotations = new ArrayList<>();

    public User() {

    }

    public User(String name, String lastName, String username, String email, String password) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String name, String lastName, String username, String email,
                String password) {
        super();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
