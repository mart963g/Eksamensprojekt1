package enggaarden.app.controllers;

import enggaarden.app.models.Address;
import enggaarden.app.models.Factories.MemberFactory;
import enggaarden.app.models.Member;
import enggaarden.app.models.MemberType;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import enggaarden.app.models.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class MemberController
{
    @Autowired
    MemberRepositoryInterface memberRepository = new MemberRepository();
    MemberFactory memberFactory = new MemberFactory();

    @GetMapping("/members")
    public String home(Model model)
    {
        model.addAttribute("members",memberFactory.getMembers(memberRepository.get()));
        return "/Members/members";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("member",new Member());
        model.addAttribute("memberTypes",MemberType.values());
        return "/Members/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Member member)
    {
        /*
        Member m1 = new Member("Mikkel","Olsen","Wuddu12p@mail.com",
                20132132,new Date(2018-12-20),
                "Paradisæblevej 101",2650,"Hvidovre",
                new Date(2011-11-11), MemberType.Primær,true);
                */
        System.out.println("Før post");
        memberRepository.postMember(member);
        System.out.println("Efter post");
        return "redirect:/members";
    }
}
