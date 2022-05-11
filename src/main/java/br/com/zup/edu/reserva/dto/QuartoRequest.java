package br.com.zup.edu.reserva.dto;

import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.TipoQuarto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class QuartoRequest {

    @NotBlank @Size(max = 200)
    private String descricao;

    @NotNull
    private BigDecimal diaria;

    @NotNull
    private TipoQuarto tipoQuarto;

    @Deprecated
    public QuartoRequest(){}

    public QuartoRequest(String descricao, BigDecimal diaria, TipoQuarto tipoQuarto) {
        this.descricao = descricao;
        this.diaria = diaria;
        this.tipoQuarto = tipoQuarto;
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

    public Quarto toMOdel() {
        return new Quarto(descricao, diaria, tipoQuarto);
    }
}
