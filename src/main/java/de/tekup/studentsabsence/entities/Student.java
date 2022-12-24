package de.tekup.studentsabsence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"image","group","absences"})
public class Student implements Serializable {
    //TODO Complete Validations of fields


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sid;
    @Column(name= "FirstName",length = 50)
    @NotBlank(message="firstname is required")
    private String firstName;
    @Column(name= "LasttName",length = 50)
    @NotBlank(message="lastname is required")
    private String lastName;
    @NotBlank(message="email is required")
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;

    //TODO Complete Relations with other entities

  @OneToMany(mappedBy = "student")
    private List<Absence> absence;
  @ManyToOne
    private Group group;
  @OneToOne(mappedBy = "student")
    private Image image;

}
