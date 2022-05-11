package br.com.zup.edu.reserva.controller;

import br.com.zup.edu.reserva.dto.ReservaRequest;
import br.com.zup.edu.reserva.dto.ReservaResponse;
import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.Reserva;
import br.com.zup.edu.reserva.respository.QuartoRepository;
import br.com.zup.edu.reserva.respository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Transactional
    @PostMapping("/{id}")
    public ResponseEntity<?> cadastraReserva(@RequestBody @Valid ReservaRequest reservaRequest, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder){

        Optional<Quarto> possivelQuarto = quartoRepository.findById(id);

        if(possivelQuarto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Quarto quarto = possivelQuarto.get();

        if(quarto.getReservado()){
            return ResponseEntity.unprocessableEntity().body("Este quarto já foi reservado");
        }

        Reserva reserva = reservaRequest.toMOdel(quarto);
        reserva.getQuarto().setReservado(true);
        reservaRepository.save(reserva);

        URI location =uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reserva.getId()).toUri();

        return ResponseEntity.created(location).body("Reserva criada com sucesso");


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaReserva(@PathVariable Long id){
        Reserva reserva = reservaRepository.findById(id).get();
        return ResponseEntity.ok().body(new ReservaResponse(reserva));
    }

    @GetMapping()
    public ResponseEntity<?> consultaTodasReservas(){
        List<Reserva> reservas = reservaRepository.findAll();
        return ResponseEntity.ok().body(new ReservaResponse().buscaReservas(reservas));
    }
}
