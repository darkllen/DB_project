package project.db.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class Sale {

    @Id
    @Column(name = "UPC")
    private String UPC;

    @Id
    @Column(name = "check_number")
    private String check_number;

    @Column(name = "product_number")
    private Integer product_number;

    @Column(name = "selling_price")
    private double selling_price;

}
