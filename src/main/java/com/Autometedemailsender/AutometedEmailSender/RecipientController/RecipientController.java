package com.Autometedemailsender.AutometedEmailSender.RecipientController;

import com.Autometedemailsender.AutometedEmailSender.Recipient.Recipient;
import com.Autometedemailsender.AutometedEmailSender.RecipientServices.RecipientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipientController {
    private RecipientServices recipientServices;
    private
    @Autowired
    RecipientController(RecipientServices recipientServices){
        this.recipientServices=recipientServices;
    }

    @GetMapping("/recipients")
    public String viewRecipient(Model model){
        List<Recipient> recipients = recipientServices.getAllRecipient();
        model.addAttribute("recipients", recipients);
        return "recipientList";
    }
    @GetMapping("/addRecipient")
    public String showAddRecipientForm(Model model) {
        model.addAttribute("recipient", new Recipient());
        return "addRecipient";
    }

    @PostMapping("/addRecipient")
    public String addRecipient(@ModelAttribute("recipient") Recipient recipient) {
        recipientServices.saveRecipient(recipient);
        return "redirect:/recipients";
    }

    @GetMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable(value="id")Long id,Model model){
        Recipient recipient=recipientServices.getRecipientById(id);
        model.addAttribute("recipient",recipient);
        return "update_recipient";
    }

    @GetMapping("/deleteRecipent/{id}")
    public String deletrecipent(@PathVariable(value = "id") Long id){
        this.recipientServices.deleteRecipientById(id);
        return "redirect:/recipients";

    }





}
