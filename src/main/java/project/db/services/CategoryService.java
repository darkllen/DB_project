package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Category;
import project.db.repos.CategoryRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Transactional
    public List<CategoryRepo.CategoriesProductsCounted> getCategoriesProductsCount(){
        return categoryRepo.getCategoriesProductsCount();
    };

    @Transactional
    public List<CategoryRepo.CategoriesInfo> getCategoriesLike(String name){
        return categoryRepo.getCategoriesLike(name);
    };

    @Transactional
    public List<CategoryRepo.CategoriesInfo> getCategories(){
        return categoryRepo.getCategories();
    };

    @Transactional
    public void addCategory(Category category){
        category.changeEmpty();
        categoryRepo.addCategory(category.getCategory_name());
    };

    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepo.getAllCategories();
    }

    @Transactional
    public Category getCategoryByCategoryNumber(int category_number) {
        return categoryRepo.getCategoryByCategoryNumber(category_number);
    }

    @Transactional
    public void removeCategoryByCategoryNumber(int category_number) {
        categoryRepo.removeCategoryByCategoryNumber(category_number);
    }

    @Transactional
    public void editCategory(Category category) {
        category.changeEmpty();
        categoryRepo.editCategory(category.getCategory_number(), category.getCategory_name());
    }

    @Transactional
    public List<Category> get_all_categories_sorted_name() {
        return categoryRepo.get_all_categories_sorted_name();
    }
}
