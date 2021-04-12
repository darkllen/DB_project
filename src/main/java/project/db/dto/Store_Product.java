package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Store_Product")
public class Store_Product implements NotEmptyF{

    @Id
    @Column(name = "UPC")
    @NotEmpty
    @NotNull
    private String upc;

    @Column(name = "UPC_prom")
    private String upc_prom;

    @Column(name = "id_product")
    @NotNull
    private Integer id_product;

    @Column(name = "selling_price")
    @NotNull
    private double selling_price;

    @Column(name = "products_number")
    @NotNull
    private Integer products_number;

    @Column(name = "promotional_product")
    @NotNull
    private boolean promotional_product;

    public void changeEmpty(){
        if (upc_prom.isEmpty()) upc_prom=null;
    }
}
