package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Store_Product")
public class Store_Product {

    @Id
    @Column(name = "UPC")
    private String upc;

    @Column(name = "UPC_prom")
    private String upc_prom;

    @Column(name = "id_product")
    private Integer id_product;

    @Column(name = "selling_price")
    private double selling_price;

    @Column(name = "products_number")
    private Integer products_number;

    @Column(name = "promotional_product")
    private boolean promotional_product;
}
