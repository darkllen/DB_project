package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Customer_Card;
import project.db.repos.CustomerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public List<CustomerRepo.CustomerSpends> getCustomersSpends(){
        return customerRepo.getCustomersSpends();
    };

    public List<String> getAllCities(){
        return customerRepo.getAllCities();
    };

    public List<CustomerRepo.Customer_info> getClientsWhoBuysOnlyPromoProducts(){
        return customerRepo.getClientsWhoBuysOnlyPromoProducts();
    };

    public List<CustomerRepo.Customer_info> ClientsWhoBuysAllCategoriesProducts(){
        return  customerRepo.ClientsWhoBuysAllCategoriesProducts();
    };

    public List<Customer_Card> getAllCustomerCards() {
        return customerRepo.getAllCustomerCards();
    }
}
