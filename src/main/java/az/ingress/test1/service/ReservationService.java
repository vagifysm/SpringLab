package az.ingress.test1.service;

import az.ingress.test1.dao.entity.ReservationEntity;
import az.ingress.test1.dao.repository.ReservationRepository;
import az.ingress.test1.model.enums.ReservationStatus;
import az.ingress.test1.model.request.CreateReservationRequest;
import az.ingress.test1.model.request.UpdateReservationRequest;
import az.ingress.test1.model.response.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public void saveReservation (CreateReservationRequest reservation){
        reservationRepository.save(
                ReservationEntity.builder()
                        .date(LocalDate.now())
                        .customer(reservation.getCustomer())
                        .tableName(reservation.getTableName())
                        .membersCount(reservation.getMembersCount())
                .build());


    }

    public void updateReservation (Long id, UpdateReservationRequest request){
        var reservation = reservationRepository.findByIdAndStatusNot(id,ReservationStatus.INACTIVE).orElseThrow(RuntimeException::new);
        reservation.setMembersCount(request.getMembersCount());
        reservationRepository.save(reservation);
    }
    public void deleteReservation (Long id){
        var reservation = reservationRepository.findByIdAndStatusNot(id,ReservationStatus.INACTIVE).orElseThrow(RuntimeException::new);
        reservation.setStatus(ReservationStatus.INACTIVE);
        reservationRepository.save(reservation);
    }

    public ReservationResponse getReservation (Long id){
        var reservation = reservationRepository.findByIdAndStatusNot(id,ReservationStatus.INACTIVE).orElseThrow(RuntimeException::new);
        return new ReservationResponse(reservation.getTableName(), reservation.getCustomer(),reservation.getDate(),reservation.getMembersCount());
    }

    public ReservationResponse searchReservation (LocalDate date){
        reservationRepository.findByStatusAndDate(ReservationStatus.ACTIVE, date);
        return new ReservationResponse();
    }



}

