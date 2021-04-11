package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Check;
import project.db.repos.CheckRepo;

import javax.transaction.Transactional;
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
}
