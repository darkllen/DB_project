package project.db.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "Category")
public class Category implements NotEmptyF{

    @Id
    @Column(name = "category_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_number;

    @Column(name = "category_name")
    @NotEmpty
    @NotNull
    private String category_name;



}
