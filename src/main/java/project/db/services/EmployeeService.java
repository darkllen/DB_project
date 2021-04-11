package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import project.db.dto.Employee;
import project.db.repos.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    private final EmployeeRepo employeeRepo;


    @Transactional
    public List<EmployeeRepo.EmployeeTotalInfo> getEmployeesSalesSum(){
        return employeeRepo.getEmployeesSalesSum();
    }

    @Transactional
    public List<EmployeeRepo.EmployeeCustInfo> getEmployeesClientsNum(){
        return employeeRepo.getEmployeesClientsNum();
    };

    @Transactional
    public Optional<Employee> getEmployeeById(String id){
        return employeeRepo.getEmployeeById(id);
    };

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    @Transactional
    public Employee getEmployeeByIdEmployee(String id_employee) {
        return employeeRepo.getEmployeeByIdEmployee(id_employee);
    }

    @Transactional
    public void removeEmployeeByIdEmployee(String id_employee) {
        employeeRepo.removeEmployeeByIdEmployee(id_employee);
    }

    @Transactional
    public void editEmployee(Employee employee, String prev_id_employee) {
        String pass = passwordEncoder.encode(employee.getPassword());
        employeeRepo.editEmployee(
                prev_id_employee,
                employee.getId_employee(),
                employee.getEmpl_name(),
                employee.getEmpl_surname(),
                employee.getEmpl_patronymic(),
                employee.getRole(),
                employee.getSalary(),
                employee.getDate_of_birth(),
                employee.getDate_of_start(),
                employee.getPhone_number(),
                employee.getCity(),
                employee.getStreet(),
                employee.getZip_code(),
                pass
        );
    }

    @Transactional
    public void addEmployee(Employee employee) {
        String pass = passwordEncoder.encode(employee.getPassword());

        employeeRepo.addEmployee(
                employee.getId_employee(),
                employee.getEmpl_surname(),
                employee.getEmpl_name(),
                employee.getEmpl_patronymic(),
                employee.getRole(),
                employee.getSalary(),
                employee.getDate_of_birth(),
                employee.getDate_of_start(),
                employee.getPhone_number(),
                employee.getCity(),
                employee.getStreet(),
                employee.getZip_code(),
                pass
        );
    }

    @Transactional
    public void editEmployeeWithoutPass(Employee employee, String prev_id_employee) {
        employeeRepo.editEmployee(
                prev_id_employee,
                employee.getId_employee(),
                employee.getEmpl_name(),
                employee.getEmpl_surname(),
                employee.getEmpl_patronymic(),
                employee.getRole(),
                employee.getSalary(),
                employee.getDate_of_birth(),
                employee.getDate_of_start(),
                employee.getPhone_number(),
                employee.getCity(),
                employee.getStreet(),
                employee.getZip_code()
        );
    }
}
