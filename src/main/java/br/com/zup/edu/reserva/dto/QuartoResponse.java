package br.com.zup.edu.reserva.dto;

import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.Reserva;
import br.com.zup.edu.reserva.model.TipoQuarto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class QuartoResponse {

    private  String descricao;
    private  BigDecimal diaria;
    private TipoQuarto tipoQuarto;
    private List<ReservaResponse> reservas;

    @Deprecated
    public QuartoResponse(){}


    public QuartoResponse(Quarto quarto) {
        descricao = quarto.getDescricao();
        diaria = quarto.getDiaria();
        tipoQuarto = quarto.getTipoQuarto();
        reservas = quarto.getReservas().stream().map(ReservaResponse::new).collect(Collectors.toList());
    }


    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public List<ReservaResponse> getReservas() {
        return reservas;
    }
}
