package ar.edu.utn.frba.ddsi.climas.models.repositories;

import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import java.util.List;

public interface MailRepository {
  public void save(Mail mail);
  public List<Mail> findAll();
}
