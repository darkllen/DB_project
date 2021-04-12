package project.db.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product;

    @Column(name = "category_number")
    @NotNull
    private Integer category_number;

    @Column(name = "product_name")
    @NotEmpty
    @NotNull
    private String product_name;

    @Column(name = "characteristics")
    @NotEmpty
    @NotNull
    private String characteristics;
}
