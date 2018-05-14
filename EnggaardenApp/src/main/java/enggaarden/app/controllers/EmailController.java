package enggaarden.app.controllers;

import enggaarden.app.models.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController
{
    @Autowired
    private EmailRepository er = new EmailRepository();

    @GetMapping("/emails")
    public String sEmail(Model model)
    {
        model.addAttribute("primary", er.emailForPrimary());
        model.addAttribute("secondary", er.emailForSecondary());
        model.addAttribute("external", er.emailForExternal());
        model.addAttribute("all", er.emailForAll());
        return "/Emails/email_send";
    }
}
