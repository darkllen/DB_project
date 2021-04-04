package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Category;
import project.db.dto.Check;

import java.util.Date;
import java.util.List;

public interface CheckRepo extends JpaRepository<Check, Integer> {


    @Query(value = "SELECT * " +
                   "FROM Recipe " +
                   "WHERE NOT EXISTS (" +
                   "                   SELECT *" +
                   "                   FROM (Store_Product INNER JOIN Product ON Store_Product.id_product=Product.id_product" +
                   "                                       INNER JOIN Category ON Product.category_number=Category.category_number" +
                   "                                       INNER JOIN Sale ON Store_Product.UPC=Sale.UPC" +
                   "                                       INNER JOIN Recipe ON Sale.check_number=Recipe.check_number) AS Temp " +
                   "                   WHERE Temp.promotional_product=0 AND Recipe.check_number=Temp.check_number)",nativeQuery = true)
//                   "      AND EXISTS (" +
//                   "                   SELECT *" +
//                   "                   FROM (Store_Product INNER JOIN Product ON Store_Product.id_product=Product.id_product" +
//                   "                                       INNER JOIN Category ON Product.category_number=Category.category_number" +
//                   "                                       INNER JOIN Sale ON Store_Product.UPC=Sale.UPC" +
//                   "                                       INNER JOIN Recipe ON Sale.check_number=Recipe.check_number) AS Temp " +
//                   "                   WHERE Recipe.check_number=Temp.check_number ABD Temp.category_number IN (" +
//                   "                                                                                            SELECT C.category_number" +
//                   "                                                                                            FROM Category AS C" +
//                   "                                                                                            WHERE C.name=:category))", nativeQuery = true)
    List<ChecksInfo> AllChecksWithAllPromoProductsFromCategory(@Param("category") String category);
    interface ChecksInfo {
        String getCheck_number();
        Date getPrint_date();
        double getSum_total();
        double getVat();
    }

}
