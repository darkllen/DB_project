package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Recipe")
public class Check implements NotEmptyF{

    @Id
    @Column(name = "check_number")
    @NotEmpty
    @NotNull
    private String check_number;

    @Column(name = "id_employee")
    @NotEmpty
    @NotNull
    private String id_employee;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "print_date")
    @NotNull
    private Date print_date;

    @Column(name = "sum_total")
    @NotNull
    @Min(0)
    private double sum_total;

    @Column(name = "vat")
    @NotNull
    @Min(0)
    private double vat;

    public void countVat() {
        vat = (sum_total*0.2)/1.2;
        sum_total+=vat;
    }

    public void changeEmpty(){
        if (card_number.isEmpty()) card_number=null;
    }
}