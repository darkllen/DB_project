package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Category;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT Category.category_number AS category_number, category_name, COUNT(id_product) AS products_count " +
            "FROM (Category INNER JOIN Product ON Category.category_number=Product.category_number) " +
            "GROUP BY Category.category_number", nativeQuery = true)
    List<CategoriesProductsCounted> getCategoriesProductsCount();

    @Query(value = "SELECT * " +
            "FROM Category " +
            "WHERE category_number=?1", nativeQuery = true)
    Category getCategoryByCategoryNumber(int category_number);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Category " +
            "WHERE category_number=?1", nativeQuery = true)
    void removeCategoryByCategoryNumber(int category_number);

    interface CategoriesProductsCounted {
        int getProducts_count();
        int getCategory_number();
        String getCategory_name();
    }


    @Query(value = "SELECT * " +
            "FROM Category ", nativeQuery = true)
    List<Category> getAllCategories();




    @Query(value = "SELECT category_number, category_name " +
            "FROM Category  " +
            "WHERE category_name LIKE :name% " +
            "LIMIT 5", nativeQuery = true)
    List<CategoriesInfo> getCategoriesLike(@Param("name") String name);

    @Query(value = "SELECT category_number, category_name " +
            "FROM Category  ", nativeQuery = true)
    List<CategoriesInfo> getCategories();
    interface CategoriesInfo {
        String getCategory_number();
        String getCategory_name();
    }

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Category (category_name) VALUES (:category_name) ", nativeQuery = true)
    void addCategory(@Param("category_name") String category_name);

}
