package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.db.dto.Employee;
import project.db.repos.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(final String id_employee) throws UsernameNotFoundException {
        final Employee employee = employeeRepo.getEmployeeById(id_employee)
                .orElseThrow(() -> new UsernameNotFoundException("No employee with id: " + id_employee));

        return User.builder()
                .username(employee.getId_employee())
                .password(employee.getPassword())
                .authorities(mapAuthorities(employee.getRole()))
                .build();
    }

    private static List<GrantedAuthority> mapAuthorities(final String role) {
        return Stream.of(role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableList());
    }


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
}
