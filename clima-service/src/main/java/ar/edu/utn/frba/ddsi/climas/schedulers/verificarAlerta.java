package ar.edu.utn.frba.ddsi.climas.schedulers;

import static java.lang.Math.log;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climas.services.AlertaClima;
import ar.edu.utn.frba.ddsi.climas.services.ClimaService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class verificarAlerta {

  private final AlertaClima alertaClima;

  public verificarAlerta(AlertaClima alertaClima){
    this.alertaClima = alertaClima;

  }
  @Scheduled(fixedRate = 60000) // 60000 ms = 5 minutos
  public void alertar(){
    Clima nuevoclima = alertaClima.verificarUltimoClima();
    if (nuevoclima != null)
      System.out.println("Humedad: " + nuevoclima.getHumedad() + " Temperatura: " + nuevoclima.getTemperatura());
  }
}
