package ar.edu.utn.frba.ddsi.climas.services;

import ar.edu.utn.frba.ddsi.climas.config.RestClimaProperties;
import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;

@Service
public class AlertaClima {
  private final RestTemplate restTemplate;

  private final ClimaRepository climaRepository;
  public AlertaClima( RestTemplate restTemplate, ClimaRepository climaRepository){
    this.restTemplate = restTemplate;
    this.climaRepository = climaRepository;
  }
  private Clima ultimoClimaAlertado;
  public Clima verificarUltimoClima(){
    Clima lastClima = climaRepository.findLast().orElse(null);
    if (lastClima!= null && !lastClima.equals(ultimoClimaAlertado) && lastClima.getTemperatura() > 35 && lastClima.getHumedad()>60){
      this.ultimoClimaAlertado = lastClima;
      this.notificarAlerta();
    }
    return lastClima;
  }
  public void notificarAlerta(){
    // TODO
  }
}
