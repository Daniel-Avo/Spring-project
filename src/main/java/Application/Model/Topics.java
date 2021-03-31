package Application.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "topics")
@Table(
        name = "\"topics\"",
        uniqueConstraints = {
                @UniqueConstraint( name = "topic_name_unique", columnNames = "topic_name")
        }
)
public class Topics {

    @Id
    @SequenceGenerator(
            name = "topic_sequence",
            sequenceName = "topic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "topic_name",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    @Length(min = 5, message = "*Topic name is too short")
    @NotEmpty(message = "*Enter topic")
    private String topicName;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    @Length(min = 10, message = "*Description is too short")
    @NotEmpty(message = "*Enter description")
    private String description;

    @Column(
            name = "comment",
            columnDefinition = "TEXT"
    )
    @Length(min = 10, message = "*Comment is too short")
    private String comment;

    @ManyToOne
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
