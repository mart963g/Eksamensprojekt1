package enggaarden.app.controllers;

import enggaarden.app.models.Factories.MemberFactory;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import enggaarden.app.models.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController
{
    @Autowired
    MemberRepositoryInterface memberRepository = new MemberRepository();
    MemberFactory memberFactory = new MemberFactory();

    @RequestMapping("/members")
    public String home(Model model)
    {
        model.addAttribute("members",memberFactory.getMembers(memberRepository.get()));
        return "/Members/members";
    }
}
