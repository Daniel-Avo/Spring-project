package Application.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity(name = "Users")
@Table(
        name = "\"users\"",
        uniqueConstraints = {
                @UniqueConstraint( name = "users_username_unique", columnNames = "user_name"),
                @UniqueConstraint( name = "users_email_unique", columnNames = "email")
        }
)
public class Users {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
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
    @Length(min = 5, message = "*User name is too short")
    @NotEmpty(message = "*Enter user name")
    private String userName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    @Email(message = "*Provide a valid email")
    @NotEmpty(message = "*Enter email")
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    @Length(min = 5, message = "*Password is too short")
    @NotEmpty(message = "*Enter password")
    private String password;

    @ManyToOne
    private Role role;

    @OneToMany( targetEntity = Topics.class, mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Topics> topics;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
