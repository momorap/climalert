package ar.edu.utn.frba.ddsi.climas.services;

import ar.edu.utn.frba.ddsi.climas.config.RestClimaProperties;
import ar.edu.utn.frba.ddsi.climas.dto.WeatherDTO;
import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ClimaService {
  private final RestTemplate restTemplate;
  private final RestClimaProperties restClimaProperties;
  private final ClimaRepository climaRepository;
  public ClimaService(RestClimaProperties restClimaProperties, RestTemplate restTemplate, ClimaRepository climaRepository){
    this.restTemplate = restTemplate;
    this.restClimaProperties = restClimaProperties;
    this.climaRepository = climaRepository;
  }

  public Clima buscarTemperaturaBuenosAires(){
    URI uri = UriComponentsBuilder
        .fromUriString(restClimaProperties.getBaseUrl())
        .path("/current.json")
        .queryParam("key", restClimaProperties.getApiKey())
        .queryParam("q", "Buenos Aires")
        .build()
        .toUri();
        WeatherDTO weatherDTO =restTemplate.getForObject(uri,WeatherDTO.class);
        Clima clima = new Clima();
        clima.setTemperatura(weatherDTO.getCurrent().getTemperatura());
        clima.setHumedad(weatherDTO.getCurrent().getHumedad());
    return clima;
  }
  public List<Clima> obtenerTodos(){
    return climaRepository.findAll();
  }
  public void guardar(Clima clima){
    climaRepository.save(clima);
  }


}
