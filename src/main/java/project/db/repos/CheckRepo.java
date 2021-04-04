package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Category;
import project.db.dto.Check;

import java.util.Date;
import java.util.List;

public interface CheckRepo extends JpaRepository<Check, Integer> {


    @Query(value = "SELECT R.check_number AS check_number, R.print_date AS print_date, R.sum_total AS sum_total, R.vat as vat " +
                   "FROM Recipe AS R " +
                   "WHERE NOT EXISTS (" +
                   "                   SELECT * " +
                                      "FROM (Category INNER JOIN Product ON Category.category_number=Product.category_number" +
            "                                         INNER JOIN Store_Product ON Product.id_product=Store_Product.id_product" +
            "                                         INNER JOIN Sale ON Store_Product.UPC=Sale.UPC" +
            "                                         INNER JOIN Recipe ON Sale.check_number=Recipe.check_number)" +
            "                           WHERE R.check_number=Recipe.check_number AND Store_Product.promotional_product=0 AND Product.category_number IN (" +
                   "                                                                                            SELECT C.category_number" +
                   "                                                                                            FROM Category AS C" +
                   "                                                                                            WHERE C.category_name=:category))" +
            "             AND EXISTS (" +
            "                           SELECT * " +
                                       "FROM (Category INNER JOIN Product ON Category.category_number=Product.category_number" +
                                       "                                         INNER JOIN Store_Product ON Product.id_product=Store_Product.id_product" +
                                       "                                         INNER JOIN Sale ON Store_Product.UPC=Sale.UPC" +
                                       "                                         INNER JOIN Recipe ON Sale.check_number=Recipe.check_number) " +
                                       "WHERE R.check_number=Recipe.check_number AND Product.category_number IN (" +
                                       "                                                                          SELECT C.category_number" +
                                       "                                                                          FROM Category AS C" +
                                       "                                                                          WHERE C.category_name=:category))", nativeQuery = true)
    List<ChecksInfo> AllChecksWithAllPromoProductsFromCategory(@Param("category") String category);
    interface ChecksInfo {
        String getCheck_number();
        Date getPrint_date();
        double getSum_total();
        double getVat();
    }

}
