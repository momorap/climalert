package ar.edu.utn.frba.ddsi.climas.schedulers;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climas.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class lastClimaScheduler {
  private final ClimaService climaService;

  public lastClimaScheduler(ClimaService climaService){
    this.climaService = climaService;

  }
  @Scheduled(fixedRate = 300000) // 300000 ms = 5 minutos
  public void guardarClima(){
    Clima nuevoclima = climaService.buscarTemperaturaBuenosAires();
    climaService.guardar(nuevoclima);

  }
}
