package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "id_employee")
    private String id_employee;

    @Column(name = "empl_surname")
    private String empl_surname;

    @Column(name = "empl_name")
    private String empl_name;

    @Column(name = "empl_patronymic")
    private String empl_patronymic;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private double salary;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "date_of_start")
    private Date date_of_start;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "password")
    private String password;
}
