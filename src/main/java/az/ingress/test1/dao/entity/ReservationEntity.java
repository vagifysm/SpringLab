package az.ingress.test1.dao.entity;

import az.ingress.test1.model.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "reservations")
@Builder
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String customer;
    private LocalDate date;
    private Integer membersCount;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
