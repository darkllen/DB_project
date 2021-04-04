package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Recipe")
public class Check {

    @Id
    @Column(name = "check_number")
    private String check_number;

    @Column(name = "id_employee")
    private String id_employee;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "print_date")
    private Date print_date;

    @Column(name = "sum_total")
    private double sum_total;

    @Column(name = "vat")
    private double vat;

}