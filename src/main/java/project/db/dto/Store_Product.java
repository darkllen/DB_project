package project.db.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class Store_Product {

    @Id
    @Column(name = "UPC")
    private String UPC;

    @Column(name = "UPC_prom")
    private String UPC_prom;

    @Column(name = "id_product")
    private Integer id_product;

    @Column(name = "selling_price")
    private double selling_price;

    @Column(name = "products_number")
    private Integer products_number;

    @Column(name = "promotional_product")
    private boolean promotional_product;
}
