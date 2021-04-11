package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Category;
import project.db.dto.Check;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface CheckRepo extends JpaRepository<Check, String> {


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

    @Query(value = "SELECT * " +
            "FROM Recipe",nativeQuery = true)
    List<Check> getAllChecks();

    @Query(value = "SELECT * " +
            "FROM Recipe " +
            "WHERE check_number=?1",nativeQuery = true)
    Check getCheckByCheckNumber(String check_number);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Recipe " +
            "WHERE check_number=?1",nativeQuery = true)
    void removeCheckByCheckNumber(String check_number);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Recipe " +
            "SET check_number=?2, id_employee=?3, card_number=?4, print_date=?5, sum_total=?6, vat=?7  " +
            "WHERE check_number=?1",nativeQuery = true)
    void editCheck(String prev_check_number, String check_number, String id_employee, String card_number, Date print_date, double sum_total, double vat);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Recipe VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void addCheck(String check_number, String id_employee, String card_number, Date print_date, double sum_total, double vat);

    @Query(value = "SELECT Recipe.check_number AS check_number, Recipe.id_employee AS id_employee, Recipe.card_number AS card_number, Recipe.print_date AS print_date, Recipe.sum_total AS sum_total, Recipe.vat AS vat, Employee.empl_surname AS empl_surname, Employee.empl_name AS empl_name    " +
            "FROM Recipe INNER JOIN Employee ON Recipe.id_employee=Employee.id_employee",nativeQuery = true)
    List<ChecksWithEmpl> getAllChecksWithEmpl();


    @Query(value = "SELECT *  " +
            "FROM Recipe " +
            "WHERE id_employee=?1 AND print_date>?2 AND print_date<?3",nativeQuery = true)
    List<Check> get_checks_with_sales_by_employee_between_time(String id_employee, Date date_start, Date date_end);

    @Query(value = "SELECT *  " +
            "FROM Recipe " +
            "WHERE print_date>?1 AND print_date<?2",nativeQuery = true)
    List<Check> get_checks_with_sales_between_time(Date date_start, Date date_end);

    @Query(value = "SELECT SUM(sum_total)  " +
            "FROM Recipe " +
            "GROUP BY id_employee " +
            "HAVING id_employee=?1 " +
            "WHERE print_date>?2 AND print_date<?3 " ,nativeQuery = true)
    Double get_sum_recipes_by_employee_between_time(String id_employee, Date date_start, Date date_end);

    @Query(value = "SELECT SUM(sum_total)  " +
            "FROM Recipe " +
            "WHERE print_date>?2 AND print_date<?3 " ,nativeQuery = true)
    Double get_sum_all_recipes_between_time(Date date_start, Date date_end);

    @Query(value = "SELECT SUM(product_number)  " +
            "FROM Recipe INNER JOIN Sale ON Sale.check_number=Recipe.check_number " +
            "WHERE print_date>?2 AND print_date<?3 " ,nativeQuery = true)
    Integer get_num_product_saled_between_time(Date date_start, Date date_end);

    interface ChecksWithEmpl {
        String getCheck_number();
        String getId_employee();
        String getCard_number();
        Date getPrint_date();
        double getSum_total();
        double getVat();
        String getEmpl_name();
        String getEmpl_surname();
    }

    interface ChecksInfo {
        String getCheck_number();
        Date getPrint_date();
        double getSum_total();
        double getVat();
    }

}
