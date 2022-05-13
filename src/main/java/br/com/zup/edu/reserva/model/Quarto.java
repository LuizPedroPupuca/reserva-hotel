package br.com.zup.edu.reserva.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quarto", cascade = {PERSIST,MERGE})
    private List<Reserva> reservas = new ArrayList<>();


    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal diaria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQuarto tipoQuarto;

    @Column(nullable = false)
    private Boolean isReservado = false;

    @Version
    int version;

    @Deprecated
    public Quarto(){

    }

    public Quarto(String descricao, BigDecimal diaria, TipoQuarto tipoQuarto) {
        this.descricao = descricao;
        this.diaria = diaria;
        this.tipoQuarto = tipoQuarto;
    }

    public Long getId() {
        return id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void adicionaReserva(Reserva reserva){
        this.reservas.add(reserva);
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

    public Boolean getReservado() {
        return isReservado;
    }

    public void setReservado(Boolean reservado) {
        isReservado = reservado;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "descricao='" + descricao + '\'' +
                ", diaria=" + diaria +
                ", tipoQuarto=" + tipoQuarto +
                ", isReservado=" + isReservado +
                '}';
    }
}
