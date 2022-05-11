package br.com.zup.edu.reserva.controller;

import br.com.zup.edu.reserva.dto.QuartoRequest;
import br.com.zup.edu.reserva.dto.ReservaRequest;

import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.respository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @PostMapping
    public ResponseEntity<?> cadastraQuarto(@RequestBody @Valid QuartoRequest quartoRequest){

        Quarto quarto = quartoRequest.toMOdel();
        quartoRepository.save(quarto);

        return ResponseEntity.ok().body("Quarto cadastrada com sucesso");

    }
}
