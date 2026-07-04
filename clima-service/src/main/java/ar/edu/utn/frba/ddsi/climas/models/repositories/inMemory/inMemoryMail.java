package ar.edu.utn.frba.ddsi.climas.models.repositories.inMemory;


import ar.edu.utn.frba.ddsi.climas.models.entities.Clima;
import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import ar.edu.utn.frba.ddsi.climas.models.repositories.MailRepository;
import ar.edu.utn.frba.ddsi.climas.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class inMemoryMail implements MailRepository {
  private final List<Mail> mails = new ArrayList<>();
  private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

  public Mail save(Mail mail){
    if (mail.getId() == null) {
      mail.setId(generadorId.siguiente());
      mails.add(mail);
      return mail;
    }
    delete(mail);
    mails.add(mail);
    return mail;
  }
  public List<Mail> findAll(){
    return new ArrayList<>(mails);
  }
  public void delete(Mail mail){mails.removeIf(d -> d.getId().equals(mail.getId()));};


}


