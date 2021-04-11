package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Category;
import project.db.repos.CategoryRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<CategoryRepo.CategoriesProductsCounted> getCategoriesProductsCount(){
        return categoryRepo.getCategoriesProductsCount();
    };

    public List<CategoryRepo.CategoriesInfo> getCategoriesLike(String name){
        return categoryRepo.getCategoriesLike(name);
    };

    public List<CategoryRepo.CategoriesInfo> getCategories(){
        return categoryRepo.getCategories();
    };

    public void addCategory(String category_name){
        categoryRepo.addCategory(category_name);
    };

    public List<Category> getAllCategories() {
        return categoryRepo.getAllCategories();
    }

    public Category getCategoryByCategoryNumber(int category_number) {
        return categoryRepo.getCategoryByCategoryNumber(category_number);
    }

    public void removeCategoryByCategoryNumber(int category_number) {
        categoryRepo.removeCategoryByCategoryNumber(category_number);
    }
}
