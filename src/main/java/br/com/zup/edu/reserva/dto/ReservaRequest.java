package br.com.zup.edu.reserva.dto;

import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.Reserva;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReservaRequest {

    @Future @NotNull
    private LocalDate checkin;

    @Future @NotNull
    private LocalDate checkout;

    @Deprecated
    public ReservaRequest(){}

    public ReservaRequest(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public Reserva toMOdel(Quarto quarto) {
        return new Reserva(quarto, checkin, checkout);
    }


}
