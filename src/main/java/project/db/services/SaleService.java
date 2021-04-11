package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Check;
import project.db.dto.Sale;
import project.db.repos.CheckRepo;
import project.db.repos.SaleRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepo saleRepo;
    private final CheckRepo checkRepo;
    private final CheckService service;

    public List<Sale> getAllSales() {
        return saleRepo.getAllSales();
    }

    public Sale getSaleByUpcCheckNumber(String upc, String check_number) {
        return saleRepo.getSaleByUpcCheckNumber(upc, check_number);
    }

    public void removeSaleByUpcCheckNumber(String upc, String check_number) {
        saleRepo.removeSaleByUpcCheckNumber(upc, check_number);
    }


    public void editSale(Sale sale) {
        Sale old = saleRepo.getSaleByUpcCheckNumber(sale.getUPC(), sale.getCheck_number());
        double diff =sale.getProduct_number()*sale.getSelling_price() - old.getProduct_number()*old.getSelling_price();
        Check check = checkRepo.getCheckByCheckNumber(sale.getCheck_number());

        check.setSum_total(check.getSum_total()-check.getVat()+diff);
        check.countVat();
        service.editCheck(check, sale.getCheck_number());

        saleRepo.editSale(
                sale.getUPC(),
                sale.getCheck_number(),
                sale.getProduct_number(),
                sale.getSelling_price());
    }

    public void addSale(Sale sale) {
        double diff =sale.getProduct_number()*sale.getSelling_price();
        Check check = checkRepo.getCheckByCheckNumber(sale.getCheck_number());
        check.setSum_total(check.getSum_total()-check.getVat()+diff);
        check.countVat();
        service.editCheck(check, sale.getCheck_number());

        saleRepo.addSale(
                sale.getUPC(),
                sale.getCheck_number(),
                sale.getProduct_number(),
                sale.getSelling_price()
        );
    }
}
