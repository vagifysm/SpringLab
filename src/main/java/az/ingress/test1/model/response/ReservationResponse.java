package az.ingress.test1.model.response;

import az.ingress.test1.model.enums.ReservationStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private String tableName;
    private String customer;
    private LocalDate date;
    private Integer membersCount;
}
