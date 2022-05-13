package br.com.zup.edu.reserva.controller;

import br.com.zup.edu.reserva.dto.QuartoRequest;

import br.com.zup.edu.reserva.service.QuartoService;
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
    private QuartoService quartoService;

    @PostMapping
    public ResponseEntity<?> salvaQuarto(@RequestBody @Valid QuartoRequest quartoRequest){
        return quartoService.cadastraQuarto(quartoRequest);
    }
}
