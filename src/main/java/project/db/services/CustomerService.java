package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Customer_Card;
import project.db.repos.CustomerRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Transactional
    public List<CustomerRepo.CustomerSpends> getCustomersSpends(){
        return customerRepo.getCustomersSpends();
    };

    @Transactional
    public List<String> getAllCities(){
        return customerRepo.getAllCities();
    };

    @Transactional
    public List<CustomerRepo.Customer_info> getClientsWhoBuysOnlyPromoProducts(){
        return customerRepo.getClientsWhoBuysOnlyPromoProducts();
    };

    @Transactional
    public List<CustomerRepo.Customer_info> ClientsWhoBuysAllCategoriesProducts(){
        return  customerRepo.ClientsWhoBuysAllCategoriesProducts();
    };

    @Transactional
    public List<Customer_Card> getAllCustomerCards() {
        return customerRepo.getAllCustomerCards();
    }

    @Transactional
    public Customer_Card getCustomerCardByCardNumber(String card_number) {
        return customerRepo.getCustomerCardByCardNumber(card_number);
    }

    @Transactional
    public void removeCustomerCardByCardNumber(String card_number) {
        customerRepo.removeCustomerCardByCardNumber(card_number);
    }

    @Transactional
    public void editCustomerCard(Customer_Card customer_card, String prev_card_number) {
        customer_card.changeEmpty();
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

    @Transactional
    public void addCustomerCard(Customer_Card customer) {
        customer.changeEmpty();
        customerRepo.addCustomerCard(
                customer.getCard_number(),
                customer.getCust_surname(),
                customer.getCust_name(),
                customer.getCust_patronymic(),
                customer.getPhone_number(),
                customer.getCity(),
                customer.getStreet(),
                customer.getZip_code(),
                customer.getPercent()
        );
    }

    public List<Customer_Card> get_customers_by_percent(int percent) {
        return customerRepo.get_customers_by_percent(percent);
    }

    @Transactional
    public List<Customer_Card> get_customers_by_surname(String cust_surname) {
        return customerRepo.get_customers_by_surname(cust_surname.toLowerCase(Locale.ROOT));
    }

    @Transactional
    public List<String> get_all_cust_surname() {
        return customerRepo.get_all_cust_surname();
    }
}
