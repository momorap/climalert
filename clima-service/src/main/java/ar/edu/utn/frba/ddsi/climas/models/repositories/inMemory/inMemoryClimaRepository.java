package ar.edu.utn.frba.ddsi.climas.models.repositories.inMemory;


import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climas.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class inMemoryClimaRepository implements ClimaRepository {
  private final List<Clima> climas = new ArrayList<>();
  private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

  @Override
  public Clima save(Clima clima){
    if (clima.getId() == null) {
      clima.setId(generadorId.siguiente());
      climas.add(clima);
      return clima;
    }
    delete(clima);
    climas.add(clima);
    return clima;
  };

  public void delete(Clima clima){climas.removeIf(d -> d.getId().equals(clima.getId()));};

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
