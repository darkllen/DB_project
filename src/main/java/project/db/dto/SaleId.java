package project.db.dto;

import java.io.Serializable;
import java.util.Objects;

public class SaleId  implements Serializable {
    private String upc;
    private String check_number;

    public SaleId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleId saleId = (SaleId) o;
        return upc.equals(saleId.upc) && check_number.equals(saleId.check_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upc, check_number);
    }
}
