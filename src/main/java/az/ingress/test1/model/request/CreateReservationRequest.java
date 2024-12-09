package az.ingress.test1.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {
    private String tableName;
    private String customer;
    private Integer membersCount;
}
