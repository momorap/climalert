package ar.edu.utn.frba.ddsi.climas.models.repositories.inMemory;


import ar.edu.utn.frba.ddsi.climas.models.entities.Mail;
import ar.edu.utn.frba.ddsi.climas.models.repositories.MailRepository;
import java.util.ArrayList;
import java.util.List;

public class inMemoryMail implements MailRepository {
  private final List<Mail> mails = new ArrayList<>();

  public void save(Mail mail){
    mails.add(mail);
  }
  public List<Mail> findAll(){
    return new ArrayList<>(mails);
  }


}


