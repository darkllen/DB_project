package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


    @Query(value = "SELECT Employee.empl_name AS empl_name, Employee.empl_surname AS empl_surname, Employee.id_employee AS id_employee, SUM(Recipe.sum_total) AS total " +
            "FROM Employee INNER JOIN Recipe ON Employee.id_employee=Recipe.id_employee " +
            "GROUP BY Employee.id_employee", nativeQuery = true)
    List<EmployeeTotalInfo> getEmployeesSalesSum();

    interface EmployeeTotalInfo {
        String getEmpl_surname();
        String getEmpl_name();
        String getId_employee();
        String getTotal();
    }
    @Query(value = "SELECT * " +
            "FROM Employee ", nativeQuery = true)
    List<Employee> getAllEmployees();

    @Query(value = "SELECT Employee.empl_name AS empl_name, Employee.empl_surname AS empl_surname, Employee.id_employee AS id_employee, COUNT(Recipe.card_number) AS cust_number " +
            "FROM Employee INNER JOIN Recipe ON Employee.id_employee=Recipe.id_employee " +
            "GROUP BY Employee.id_employee", nativeQuery = true)
    List<EmployeeCustInfo> getEmployeesClientsNum();
    interface EmployeeCustInfo {
        String getEmpl_surname();
        String getEmpl_name();
        String getId_employee();
        String getCust_number();
    }

    @Query(value = "SELECT * " +
            "FROM Employee " +
            "WHERE id_employee=:id", nativeQuery = true)
    Optional<Employee> getEmployeeById(@Param("id") String id);


}