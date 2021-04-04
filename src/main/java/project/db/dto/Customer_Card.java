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
@Table(name = "Customer_Card")
public class Customer_Card {

    @Id
    @Column(name = "card_number")
    private String card_number;

    @Column(name = "cust_surname")
    private String cust_surname;

    @Column(name = "cust_name")
    private String cust_name;

    @Column(name = "cust_patronymic")
    private String cust_patronymic;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "percent")
    private Integer percent;
}

