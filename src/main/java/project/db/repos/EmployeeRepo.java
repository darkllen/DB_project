package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Employee;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


    @Query(value = "SELECT Employee.empl_name AS empl_name, Employee.empl_surname AS empl_surname, Employee.id_employee AS id_employee, SUM(Recipe.sum_total) AS total " +
            "FROM Employee INNER JOIN Recipe ON Employee.id_employee=Recipe.id_employee " +
            "GROUP BY Employee.id_employee", nativeQuery = true)
    List<EmployeeTotalInfo> getEmployeesSalesSum();

    @Query(value = "SELECT * " +
            "FROM Employee " +
            "WHERE id_employee=?1", nativeQuery = true)
    Employee getEmployeeByIdEmployee(String id_employee);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Employee " +
            "WHERE id_employee=?1", nativeQuery = true)
    void removeEmployeeByIdEmployee(String id_employee);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Employee " +
            "SET  id_employee=?2, empl_name=?3, empl_surname=?4, empl_patronymic=?5, role=?6, salary=?7, date_of_birth=?8, date_of_start=?9, phone_number=?10, city=?11, street=?12, zip_code=?13, password=?14 " +
            "WHERE id_employee=?1", nativeQuery = true)
    void editEmployee(String prev_id_employee, String id_employee, String empl_name, String empl_surname, String empl_patronymic, String role, double salary, Date date_of_birth, Date date_of_start, String phone_number, String city, String street, String zip_code, String password);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Employee VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13)", nativeQuery = true)
    void addEmployee(String id_employee, String empl_surname, String empl_name, String empl_patronymic, String role, double salary, Date date_of_birth, Date date_of_start, String phone_number, String city, String street, String zip_code, String password);

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