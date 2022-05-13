package br.com.zup.edu.reserva.service;

import br.com.zup.edu.reserva.dto.ReservaRequest;
import br.com.zup.edu.reserva.dto.QuartoResponse;
import br.com.zup.edu.reserva.model.Quarto;
import br.com.zup.edu.reserva.model.Reserva;
import br.com.zup.edu.reserva.respository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    @Autowired
    private QuartoRepository quartoRepository;

    public ResponseEntity<?> cadastraService(ReservaRequest reservaRequest, Long id, UriComponentsBuilder uriComponentsBuilder) {
        Quarto quarto = quartoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Quarto não encontrado"));

        if(quarto.getReservado()){
            return ResponseEntity.unprocessableEntity().body("Este quarto já foi reservado");
        }

        Reserva reserva = reservaRequest.toMOdel(quarto);
        quarto.adicionaReserva(reserva);
        reserva.getQuarto().setReservado(true);
        quartoRepository.save(quarto);

        URI location =uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reserva.getId()).toUri();

        return ResponseEntity.created(location).body("Reserva criada com sucesso");
    }

    public ResponseEntity<?> consultaQuarto(Long id) {

        Quarto quarto = quartoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
        return ResponseEntity.ok().body(new QuartoResponse(quarto));
    }

    public ResponseEntity<?> consultaTodosQuartos() {
        List<Quarto> quartos = quartoRepository.findAll();
        return quartos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(quartos.stream()
                .map(QuartoResponse::new).collect(Collectors.toList()));
    }
}
