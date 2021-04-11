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

    public Customer_Card getCustomerCardByCardNumber(String card_number) {
        return customerRepo.getCustomerCardByCardNumber(card_number);
    }

    public void removeCustomerCardByCardNumber(String card_number) {
        customerRepo.removeCustomerCardByCardNumber(card_number);
    }

    public void editCustomerCard(Customer_Card customer_card, String prev_card_number) {
        customerRepo.editCustomerCard(prev_card_number,
                customer_card.getCard_number(),
                customer_card.getCust_name(),
                customer_card.getCust_surname(),
                customer_card.getCust_patronymic(),
                customer_card.getPhone_number(),
                customer_card.getCity(),
                customer_card.getStreet(),
                customer_card.getZip_code(),
                customer_card.getPercent());
    }
}
