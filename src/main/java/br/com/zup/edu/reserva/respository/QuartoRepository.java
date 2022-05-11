package br.com.zup.edu.reserva.respository;

import br.com.zup.edu.reserva.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Quarto> findById(Long id);
}
