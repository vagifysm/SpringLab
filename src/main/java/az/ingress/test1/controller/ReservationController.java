package az.ingress.test1.controller;

import az.ingress.test1.model.enums.ReservationStatus;
import az.ingress.test1.model.request.CreateReservationRequest;
import az.ingress.test1.model.request.UpdateReservationRequest;
import az.ingress.test1.model.response.ReservationResponse;
import az.ingress.test1.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation (@RequestBody CreateReservationRequest request){
        reservationService.saveReservation(request);
    }

    @PatchMapping("/{id}/reservations")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReservation (@PathVariable Long id,@RequestBody UpdateReservationRequest request){
        reservationService.updateReservation(id, request);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation (@PathVariable Long id){
        reservationService.deleteReservation(id);
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservation (@PathVariable Long id){
        return reservationService.getReservation(id);
    }

    @GetMapping("/search")
    public ReservationResponse searchReservation(@RequestParam("date") LocalDate date) {
        return reservationService.searchReservation(date);
    }
}
