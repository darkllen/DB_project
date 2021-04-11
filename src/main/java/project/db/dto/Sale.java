package project.db.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Sale")
@IdClass(SaleId.class)
public class Sale {

    @Id
    @Column(name = "UPC")
    private String upc;

    @Id
    @Column(name = "check_number")
    private String check_number;

    @Column(name = "product_number")
    private Integer product_number;

    @Column(name = "selling_price")
    private double selling_price;

}
