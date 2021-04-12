package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Check;
import project.db.dto.Product;
import project.db.dto.Sale;
import project.db.dto.Store_Product;
import project.db.repos.CheckRepo;
import project.db.repos.SaleRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepo saleRepo;
    private final CheckRepo checkRepo;
    private final CheckService service;
    private final StoreProductService store_product;

    @Transactional
    public List<Sale> getAllSales() {
        return saleRepo.getAllSales();
    }

    @Transactional
    public Sale getSaleByUpcCheckNumber(String upc, String check_number) {
        return saleRepo.getSaleByUpcCheckNumber(upc, check_number);
    }

    @Transactional
    public void removeSaleByUpcCheckNumber(String upc, String check_number) {
        Store_Product product = store_product.getStoreProductByUPC(upc);
        Sale old = saleRepo.getSaleByUpcCheckNumber(upc, check_number);

        int diff_num = -old.getProduct_number();
        int numLeft = product.getProducts_number()-diff_num;
        if (numLeft<0){
            throw new IllegalArgumentException("too many products");
        } else {
            product.setProducts_number(numLeft);
            store_product.editStoreProduct(product, product.getUpc());
        }

        double diff =- (old.getProduct_number()*old.getSelling_price());
        Check check = checkRepo.getCheckByCheckNumber(check_number);
        check.setSum_total(check.getSum_total()-check.getVat()+diff);
        check.countVat();
        service.editCheck(check, check_number);

        saleRepo.removeSaleByUpcCheckNumber(upc, check_number);
    }

    @Transactional
    public void editSale(Sale sale) {
        Store_Product product = store_product.getStoreProductByUPC(sale.getUpc());
        Sale old = saleRepo.getSaleByUpcCheckNumber(sale.getUpc(), sale.getCheck_number());

        int diff_num = sale.getProduct_number()-old.getProduct_number();
        int numLeft = product.getProducts_number()-diff_num;
        if (numLeft<0){
            throw new IllegalArgumentException("too many products");
        } else {
            product.setProducts_number(numLeft);
            store_product.editStoreProduct(product, product.getUpc());
        }

        double diff =sale.getProduct_number()*sale.getSelling_price() - old.getProduct_number()*old.getSelling_price();
        Check check = checkRepo.getCheckByCheckNumber(sale.getCheck_number());
        check.setSum_total(check.getSum_total()-check.getVat()+diff);
        check.countVat();
        service.editCheck(check, sale.getCheck_number());

        saleRepo.editSale(
                sale.getUpc(),
                sale.getCheck_number(),
                sale.getProduct_number(),
                sale.getSelling_price());
    }

    @Transactional
    public void addSale(Sale sale) {
        Store_Product product = store_product.getStoreProductByUPC(sale.getUpc());
        int numLeft = product.getProducts_number()-sale.getProduct_number();
        if (numLeft<0){
            throw new IllegalArgumentException("too many products");
        } else {
            product.setProducts_number(numLeft);
            store_product.editStoreProduct(product, product.getUpc());
        }

        sale.setSelling_price(product.getSelling_price());

        double diff =sale.getProduct_number()*sale.getSelling_price();
        System.out.println(diff);
        Check check = checkRepo.getCheckByCheckNumber(sale.getCheck_number());
        System.out.println(check.getSum_total());
        check.setSum_total(check.getSum_total()-check.getVat()+diff);
        check.countVat();
        System.out.println(check.getSum_total());
        service.editCheck(check, sale.getCheck_number());

        saleRepo.addSale(
                sale.getUpc(),
                sale.getCheck_number(),
                sale.getProduct_number(),
                sale.getSelling_price()
        );
    }

    @Transactional
    public List<SaleRepo.SalesWithProductName> getAllSalesWithProductNameByCheckNumber(String check_number) {
        return saleRepo.getAllSalesWithProductNameByCheckNumber(check_number);
    }

    public SaleRepo.SalesWithProductName get_sale_with_name_by_upc_check_number(String upc, String check_number) {
        return  saleRepo.get_sale_with_name_by_upc_check_number(upc, check_number);
    }
}
