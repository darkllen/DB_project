package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Sale;
import project.db.repos.SaleRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepo saleRepo;
    public List<Sale> getAllSales() {
        return saleRepo.getAllSales();
    }

}
