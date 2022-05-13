package br.com.zup.edu.reserva.controller;

import br.com.zup.edu.reserva.dto.ReservaRequest;
import br.com.zup.edu.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;


    @Transactional
    @PostMapping("/{id}")
    public ResponseEntity<?> salvaReserva(@RequestBody @Valid ReservaRequest reservaRequest, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder){
         return reservaService.cadastraService(reservaRequest, id, uriComponentsBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaReserva(@PathVariable Long id){
        return reservaService.consultaReserva(id);
    }

    @GetMapping()
    public ResponseEntity<?> buscaTodasReservas(){
       return reservaService.consultaTodasReservas();
    }
}
