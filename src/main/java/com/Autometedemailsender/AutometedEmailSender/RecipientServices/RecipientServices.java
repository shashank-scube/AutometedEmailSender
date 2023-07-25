package com.Autometedemailsender.AutometedEmailSender.RecipientServices;

import com.Autometedemailsender.AutometedEmailSender.Recipient.Recipient;
import com.Autometedemailsender.AutometedEmailSender.RecipientRepository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipientServices {
    private RecipientRepository recipientRepository;
    @Autowired
    public RecipientServices(RecipientRepository recipientRepository){
        this.recipientRepository=recipientRepository;
    }


    public List<Recipient> getAllRecipient(){
        return recipientRepository.findAll();
    }

    public Recipient saveRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);}


    public Recipient getRecipientById(Long id) {
        Optional<Recipient> optional = recipientRepository.findById(id);
        Recipient recipient = null;
        if (optional.isPresent()) {
            recipient = optional.get();
        } else {
            throw new RuntimeException("Recipient alredy Exsist" + id);
        }
        return recipient;
    }


    public void deleteRecipientById(Long id){
        this.recipientRepository.deleteById(id);
    }


}
