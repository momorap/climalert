package ar.edu.utn.frba.ddsi.climas.models.repositories;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import java.util.List;
import java.util.Optional;

public interface ClimaRepository {
  Clima save(Clima actual);
  Optional<Clima> findLast();
  List<Clima> findAll();
}
