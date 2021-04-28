package pl.coderslab.charity.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@ToString

public class Institution {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String description;

    @OneToMany (mappedBy = "institution")
    private List<Donation> donation;



}
