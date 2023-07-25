package com.Autometedemailsender.AutometedEmailSender.RecipientServices;

import com.Autometedemailsender.AutometedEmailSender.Recipient.Recipient;
import com.Autometedemailsender.AutometedEmailSender.RecipientRepository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipientMailSender {
    private final JavaMailSender javaMailSender;
    private final RecipientRepository recipientRepository;

    @Autowired
    public RecipientMailSender(JavaMailSender javaMailSender, RecipientRepository recipientRepository) {
        this.javaMailSender = javaMailSender;
        this.recipientRepository = recipientRepository;
    }

    public void sendEmailToAllRecipients(String subject, String message) {
        List<Recipient> recipients = recipientRepository.findAll();

        for (Recipient recipient : recipients) {
            try {
                sendEmail(recipient.getEmail(), subject, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sendEmail(String recipientEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
