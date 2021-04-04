package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Category;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query(
            value = "SELECT * FROM Category",
            nativeQuery = true)
    List<Category> getAllCategories();
}
