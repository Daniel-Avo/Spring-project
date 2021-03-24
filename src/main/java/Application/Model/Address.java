/*
package Application.Model;

import javax.persistence.*;

@Entity
@Table(name = "\"address\"")
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String city;

    @Column(
            name = "state",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String state;

    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT",
            updatable = false
    )
    private String country;

    @ManyToOne
    private Users users;

    public Address(Long id, String city, String state, String country) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
 */
