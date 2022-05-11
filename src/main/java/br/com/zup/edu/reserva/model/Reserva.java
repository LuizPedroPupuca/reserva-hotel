package br.com.zup.edu.reserva.model;

import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Quarto quarto;

    @Column(nullable = false)
    private LocalDate checkin;

    @Column(nullable = false)
    private LocalDate checkout;

    @Column(nullable = false)
    private LocalDateTime instante = LocalDateTime.now();

    @Deprecated
    public Reserva(){}

    public Reserva(Quarto quarto, LocalDate checkin, LocalDate checkout) {
        this.quarto = quarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public Quarto getQuarto() {
        return quarto;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", quarto=" + quarto +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", instante=" + instante +
                '}';
    }
}
