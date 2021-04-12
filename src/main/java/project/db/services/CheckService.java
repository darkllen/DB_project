package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Check;
import project.db.dto.Customer_Card;
import project.db.repos.CheckRepo;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckService {
    private final CheckRepo checkRepo;

    @Transactional
    public List<CheckRepo.ChecksInfo> AllChecksWithAllPromoProductsFromCategory(String category){
        return checkRepo.AllChecksWithAllPromoProductsFromCategory(category);
    };

    @Transactional
    public List<Check> getAllChecks() {
        return checkRepo.getAllChecks();
    }

    @Transactional
    public Check getCheckByCheckNumber(String check_number) {
        return checkRepo.getCheckByCheckNumber(check_number);
    }

    @Transactional
    public void removeCheckByCheckNumber(String check_number) {
        checkRepo.removeCheckByCheckNumber(check_number);
    }

    @Transactional
    public void editCheck(Check check, String prev_check_number) {
        check.changeEmpty();
        checkRepo.editCheck(prev_check_number,
                check.getCheck_number(),
                check.getId_employee(),
                check.getCard_number(),
                check.getPrint_date(),
                check.getSum_total(),
                check.getVat());
    }

    @Transactional
    public void addCheck(Check check) {
        check.changeEmpty();
        checkRepo.addCheck(
                check.getCheck_number(),
                check.getId_employee(),
                check.getCard_number(),
                check.getPrint_date(),
                check.getSum_total(),
                check.getVat()
        );
    }

    @Transactional
    public List<CheckRepo.ChecksWithEmpl> getAllChecksWithEmpl() {
        return checkRepo.getAllChecksWithEmpl();
    }

    @Transactional
    public List<Check> get_checks_with_sales_by_employee_between_time(String id_employee, String date_start, String date_end) throws ParseException {
        Date date_s = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
        Date date_e = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
        return checkRepo.get_checks_with_sales_by_employee_between_time(id_employee, date_s, date_e);
    }

    @Transactional
    public List<Check> get_checks_with_sales_between_time(String date_start, String date_end) throws ParseException {
        Date date_s = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
        Date date_e = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
        return  checkRepo.get_checks_with_sales_between_time(date_s,date_e);
    }

    @Transactional
    public Double get_sum_recipes_by_employee_between_time(String id_employee, String date_start, String date_end) throws ParseException {
        Date date_s = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
        Date date_e = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
        return checkRepo.get_sum_recipes_by_employee_between_time(id_employee, date_s, date_e);
    }

    @Transactional
    public Double get_sum_all_recipes_between_time(String date_start, String date_end) throws ParseException {
        Date date_s = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
        Date date_e = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
        return checkRepo.get_sum_all_recipes_between_time(date_s,date_e);
    }

    @Transactional
    public Integer get_num_product_saled_between_time(int id_product, String date_start, String date_end) throws ParseException {
        Date date_s = new SimpleDateFormat("yyyy-MM-dd").parse(date_start);
        Date date_e = new SimpleDateFormat("yyyy-MM-dd").parse(date_end);
        return  checkRepo.get_num_product_saled_between_time(id_product, date_s, date_e);
    }


}
