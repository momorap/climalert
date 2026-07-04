package ar.edu.utn.frba.ddsi.climas.models.repositories;

import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import java.util.List;

public interface MailRepository {
   Mail save(Mail mail);
   List<Mail> findAll();
   void delete(Mail mail);

}
