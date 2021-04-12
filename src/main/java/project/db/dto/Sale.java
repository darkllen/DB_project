package project.db.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "Sale")
@IdClass(SaleId.class)
public class Sale implements NotEmptyF{

    @Id
    @Column(name = "UPC")
    @NotEmpty
    @NotNull
    private String upc;

    @Id
    @Column(name = "check_number")
    @NotEmpty
    @NotNull
    private String check_number;

    @Column(name = "product_number")
    @NotNull
    private Integer product_number;

    @Column(name = "selling_price")
    @NotNull
    private double selling_price;

}
