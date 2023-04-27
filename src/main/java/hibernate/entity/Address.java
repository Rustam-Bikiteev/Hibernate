package hibernate.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Address entity - represents the bd table.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country;
    private String city;
    private String street;
    private int buildingNum;
    private int flatNum;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ToString.Exclude
    private List<Person> persons;
}
