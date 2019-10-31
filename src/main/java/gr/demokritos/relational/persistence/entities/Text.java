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
@Table(name = "TEXTS")
@DynamicUpdate
@DynamicInsert
public class Text extends AbstractEntity {

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "text")
    private List<Annotation> annotations = new ArrayList<>();

    public Text() {

    }

    public Text(String content) {
        this.content = content;
    }

    public Text(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "Text{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
