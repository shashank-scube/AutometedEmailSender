package com.Autometedemailsender.AutometedEmailSender.RecipientController;


import com.Autometedemailsender.AutometedEmailSender.RecipientServices.RecipientMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    private final RecipientMailSender recipientMailSender;

    @Autowired
    public EmailController(RecipientMailSender recipientMailSender) {
        this.recipientMailSender=recipientMailSender;
    }

    @GetMapping("/sendmail")
    public String showEmailTemplate() {
        return "emailTemplet";
    }

    @PostMapping("/send-email")
    @ResponseBody
    public String sendEmailToAllRecipients(@RequestParam("subject") String subject,
                                           @RequestParam("message") String message) {
        recipientMailSender.sendEmailToAllRecipients(subject, message);
        return "Email sent successfully to all recipients!";
    }
}
