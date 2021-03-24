/*
package Application.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@Table(
        name = "\"role\"",
        uniqueConstraints = {
                @UniqueConstraint( name = "users_rolename_unique", columnNames = "user_role")
        }
)
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "user_role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userRole;

    @OneToMany( targetEntity = Users.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Users> users;

    public Role(Long id, String userRole, List<Users> users) {
        this.id = id;
        this.userRole = userRole;
        this.users = users;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
*/
