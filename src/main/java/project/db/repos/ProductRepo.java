package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(
            value = "SELECT * " +
                    "FROM Product",
            nativeQuery = true)
    List<Product> getAllProducts();
}
