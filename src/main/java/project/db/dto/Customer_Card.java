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
@Table(name = "Customer_Card")
public class Customer_Card {

    @Id
    @Column(name = "card_number")
    @NotEmpty
    private String card_number;

    @Column(name = "cust_surname")
    @NotEmpty
    @NotNull
    private String cust_surname;

    @Column(name = "cust_name")
    @NotEmpty
    @NotNull
    private String cust_name;

    @Column(name = "cust_patronymic")
    @NotEmpty
    @NotNull
    private String cust_patronymic;

    @Column(name = "phone_number")
    @NotEmpty
    @NotNull
    private String phone_number;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "percent")
    @NotNull
    private Integer percent;
}

