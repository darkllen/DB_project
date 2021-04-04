package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Category;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


    @Query(value = "SELECT Category.category_number as category_number, category_name, COUNT(id_product) as products_count " +
            "FROM (Category INNER JOIN Product ON Category.category_number=Product.category_number) " +
            "GROUP BY Category.category_number", nativeQuery = true)
    List<CategoriesProductsCounted> getCategoriesProductsCount();

    interface CategoriesProductsCounted {
        int getProducts_count();
        String getCategory_number();
        String getCategory_name();
    }

}
