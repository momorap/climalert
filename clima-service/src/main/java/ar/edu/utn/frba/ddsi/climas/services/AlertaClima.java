package ar.edu.utn.frba.ddsi.climas.services;

import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import ar.edu.utn.frba.ddsi.climas.models.repositories.ClimaRepository;
import ar.edu.utn.frba.ddsi.climas.models.repositories.MailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertaClima {

  private final MailRepository mailRepository;
  private final ClimaRepository climaRepository;
  private final JavaMailSender mailSender;

  public AlertaClima(MailRepository mailRepository, JavaMailSender mailSender, ClimaRepository climaRepository) {
    this.mailSender = mailSender;
    this.climaRepository = climaRepository;
    this.mailRepository = mailRepository;
  }

  private Clima ultimoClimaAlertado;

  public Clima verificarUltimoClima() {
    Clima lastClima = climaRepository.findLast().orElse(null);
    if (lastClima != null && !lastClima.equals(ultimoClimaAlertado) && lastClima.getTemperatura() > 35 && lastClima.getHumedad() > 60) {
      this.ultimoClimaAlertado = lastClima;
      this.notificarAlerta(lastClima);
    }
    return lastClima;
  }

  public void notificarAlerta(Clima clima) {
    List<Mail> mails = mailRepository.findAll();

    mails.forEach(mail -> enviar(mail.getCorreo(),clima));
  }

  public void enviar(String destinatario, Clima clima) {
    SimpleMailMessage mensaje = new SimpleMailMessage();

    mensaje.setTo(destinatario);
    mensaje.setSubject("Alerta meteorológica");
    mensaje.setText(
        "Se detectó una alerta climática.\n\n" +
            "Temperatura: " + clima.getTemperatura() + "°C\n" +
            "Humedad: " + clima.getHumedad() + "%");

    mailSender.send(mensaje);
  }
}
