package ar.edu.utn.frba.ddsi.climas.services;

import ar.edu.utn.frba.ddsi.climas.config.RestClimaProperties;
import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AlertaClima {
  private final RestTemplate restTemplate;
  private final RestClimaProperties restClimaProperties;
  private final ClimaRepository climaRepository;
  public AlertaClima(RestClimaProperties restClimaProperties, RestTemplate restTemplate, ClimaRepository climaRepository){
    this.restTemplate = restTemplate;
    this.restClimaProperties = restClimaProperties;
    this.climaRepository = climaRepository;
  }

  public Clima verificarUltimoClima(){
    Clima lastClima = climaRepository.findLast().orElse(null);
    if (lastClima!= null && lastClima.getTemperatura() > 35 && lastClima.getHumedad()>60){
      this.notificarAlerta();
    }
    return lastClima;
  }
  public void notificarAlerta(){
    // TODO
  }
}
