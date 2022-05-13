package br.com.zup.edu.reserva.dto;

import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.Reserva;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaResponse {

    private LocalDate checkin;

    private LocalDate checkout;

    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public ReservaResponse() {
    }

    public ReservaResponse(Reserva reserva){
        checkin = reserva.getCheckin();
        checkout = reserva.getCheckout();
        instante = reserva.getInstante();
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
