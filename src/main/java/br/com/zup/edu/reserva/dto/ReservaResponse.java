package br.com.zup.edu.reserva.dto;

import br.com.zup.edu.reserva.model.Reserva;
import br.com.zup.edu.reserva.model.TipoQuarto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaResponse {

    private  String quartoDescricao;
    private  BigDecimal quartoDiaria;
    private TipoQuarto quartoTipoQuarto;
    private LocalDate checkin;
    private LocalDate checkout;
    private LocalDateTime instante;

    @Deprecated
    public ReservaResponse(){}


    public ReservaResponse(Reserva reserva) {
        quartoDescricao = reserva.getQuarto().getDescricao();
        quartoDiaria = reserva.getQuarto().getDiaria();
        quartoTipoQuarto = reserva.getQuarto().getTipoQuarto();
        checkin = reserva.getCheckin();
        checkout = reserva.getCheckout();
        instante = reserva.getInstante();

    }

    public List<ReservaResponse> buscaReservas(List<Reserva> reservas){
        return reservas.stream().map(ReservaResponse::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Descrição do quarto : '" + quartoDescricao + '\n' +
                "Diária do quarto : " + quartoDiaria + '\n' +
                "Tipo do quarto : " + quartoTipoQuarto + '\n' +
                "Checkin : " + checkin + '\n' +
                "Checkout : " + checkout + '\n' +
                "Dia e hora da reserva : " + instante;
    }

    public String getQuartoDescricao() {
        return quartoDescricao;
    }

    public BigDecimal getQuartoDiaria() {
        return quartoDiaria;
    }

    public TipoQuarto getQuartoTipoQuarto() {
        return quartoTipoQuarto;
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
