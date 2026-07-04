package ar.edu.utn.frba.ddsi.climas.controllers;

import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import ar.edu.utn.frba.ddsi.climas.services.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/mail")
public class mailController {
  private final MailService mailService;

  public mailController(MailService mailService){
    this.mailService=mailService;
  }
  @GetMapping
  public List<Mail> listar(){
    return mailService.listar();
  }
  @PostMapping
  public Mail guardar(Mail mail){
    return  mailService.crear(mail);
  }
}
