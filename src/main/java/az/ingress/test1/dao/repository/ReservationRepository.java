package az.ingress.test1.dao.repository;

import az.ingress.test1.dao.entity.ReservationEntity;
import az.ingress.test1.model.enums.ReservationStatus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<ReservationEntity,Long> {

    Optional<ReservationEntity> findByIdAndStatusNot(Long id
            ,ReservationStatus status);

    List<ReservationEntity> findByStatusAndDate(ReservationStatus status
            , LocalDate creationDate);
}
