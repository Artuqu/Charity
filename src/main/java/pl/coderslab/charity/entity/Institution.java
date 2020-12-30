package pl.coderslab.charity.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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



}
