package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Employee;
import project.db.repos.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;


    public List<EmployeeRepo.EmployeeTotalInfo> getEmployeesSalesSum(){
        return employeeRepo.getEmployeesSalesSum();
    }

    public List<EmployeeRepo.EmployeeCustInfo> getEmployeesClientsNum(){
        return employeeRepo.getEmployeesClientsNum();
    };

    public Optional<Employee> getEmployeeById(String id){
        return employeeRepo.getEmployeeById(id);
    };

    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    public Employee getEmployeeByIdEmployee(String id_employee) {
        return employeeRepo.getEmployeeByIdEmployee(id_employee);
    }

    public void removeEmployeeByIdEmployee(String id_employee) {
        employeeRepo.removeEmployeeByIdEmployee(id_employee);
    }
}
