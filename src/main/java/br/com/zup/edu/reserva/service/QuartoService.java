package br.com.zup.edu.reserva.service;

import br.com.zup.edu.reserva.dto.QuartoRequest;
import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.respository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public ResponseEntity<?> cadastraQuarto(QuartoRequest quartoRequest) {
        Quarto quarto = quartoRequest.toMOdel();
        quartoRepository.save(quarto);

        return ResponseEntity.ok().body("Quarto cadastrada com sucesso");
    }
}
