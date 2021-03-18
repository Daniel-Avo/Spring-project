package Model;

import javax.persistence.*;

@Entity(name = "Users")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint( name = "users_username_unique", columnNames = "user_name"),
                @UniqueConstraint( name = "users_email_unique", columnNames = "email")
        }
)
public class Users {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_name",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String userName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String password;


    public Users(Long id,
                 String userName,
                 String email,
                 String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }
}
