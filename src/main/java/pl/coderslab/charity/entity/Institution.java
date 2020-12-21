package pl.coderslab.charity.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
public class Institution {
@Setter
@Getter

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public Institution setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Institution setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Institution setDescription(String description) {
        this.description = description;
        return this;
    }
}
