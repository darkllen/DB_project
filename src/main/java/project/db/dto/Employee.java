package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import project.db.security.AgeValidator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Employee")
public class Employee implements NotEmptyF{

    @Id
    @Column(name = "id_employee")
    @NotEmpty
    @NotNull
    private String id_employee;

    @Column(name = "empl_surname")
    @NotEmpty
    @NotNull
    private String empl_surname;

    @Column(name = "empl_name")
    @NotEmpty
    @NotNull
    private String empl_name;

    @Column(name = "empl_patronymic")
    @NotEmpty
    @NotNull
    private String empl_patronymic;

    @Column(name = "role")
    @NotEmpty
    @NotNull
    private String role;

    @Column(name = "salary")
    @NotNull
    @Min(0)
    private double salary;

    @Column(name = "date_of_birth")
    @NotNull
    @AgeValidator
    private Date date_of_birth;

    @Column(name = "date_of_start")
    @NotNull
    private Date date_of_start;

    @Column(name = "phone_number")
    @NotEmpty
    @NotNull
    @Length(min = 10, max = 13)
    private String phone_number;

    @Column(name = "city")
    @NotEmpty
    @NotNull
    private String city;

    @Column(name = "street")
    @NotEmpty
    @NotNull
    private String street;

    @Column(name = "zip_code")
    @NotEmpty
    @NotNull
    private String zip_code;

    @Column(name = "password")
    private String password;


}
