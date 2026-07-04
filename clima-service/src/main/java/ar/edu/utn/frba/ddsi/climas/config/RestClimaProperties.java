package ar.edu.utn.frba.ddsi.climas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather-api")
@Data
public class RestClimaProperties {

  private String baseUrl;
  private String apiKey;
}