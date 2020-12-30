package pl.coderslab.charity.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Donation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min (1)
    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    private List <Category> category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Institution institution;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    @Size(min=9 ,max=13)
    private String phoneNumber;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Type (type = "time")
    @DateTimeFormat(pattern = "HH-MM")
    private LocalTime pickUpTime;

    private String pickUpComment;


}
