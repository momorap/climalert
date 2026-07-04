package ar.edu.utn.frba.ddsi.climas.services;

import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import ar.edu.utn.frba.ddsi.climas.models.repositories.MailRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MailService {
  private final MailRepository mailRepository;

  public MailService(MailRepository mailRepository){
    this.mailRepository= mailRepository;
  }

  public Mail crear(Mail mail){
    return mailRepository.save(mail);
  }
  public List<Mail> listar(){
    return mailRepository.findAll();
  }


}
