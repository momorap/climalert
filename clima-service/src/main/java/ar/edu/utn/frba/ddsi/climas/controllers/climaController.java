package ar.edu.utn.frba.ddsi.climas.controllers;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.services.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
// PARA PROBARRR
@RestController
@RequestMapping("/clima")
public class climaController {
  private final ClimaService clima;

  public climaController(ClimaService clima){
    this.clima = clima;
  }
  @GetMapping
  public List<Clima> obtenerClimasHistoricos(){
    return clima.obtenerTodos();
  }
}
