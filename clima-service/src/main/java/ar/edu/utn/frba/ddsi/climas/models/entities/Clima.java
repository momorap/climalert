package ar.edu.utn.frba.ddsi.climas.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clima {
  private Long id;
  private Double temperatura;
  private Integer humedad;
}
