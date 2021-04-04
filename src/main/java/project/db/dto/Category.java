package project.db.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "category_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_number;

    @Column(name = "category_name")
    private String category_name;
}
