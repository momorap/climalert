package ar.edu.utn.frba.ddsi.climas.models.repositories.inMemory;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class inMemoryClimaRepository implements ClimaRepository {
  private final List<Clima> climas = new ArrayList<>();
  @Override
  public Clima save(Clima clima) {
    climas.add(clima);
    return clima;
  }
  @Override
  public Optional<Clima> findLast() {
    if (climas.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(climas.get(climas.size() - 1));
  }
  @Override
  public List<Clima> findAll(){
    return new ArrayList<>(climas);
  }
}
