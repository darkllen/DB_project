package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Check;
import project.db.repos.CheckRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckService {
    private final CheckRepo checkRepo;

    public List<CheckRepo.ChecksInfo> AllChecksWithAllPromoProductsFromCategory(String category){
        return checkRepo.AllChecksWithAllPromoProductsFromCategory(category);
    };

    public List<Check> getAllChecks() {
        return checkRepo.getAllChecks();
    }

}
