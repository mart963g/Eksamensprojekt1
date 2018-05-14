package enggaarden.app.controllers;

import enggaarden.app.models.Address;
import enggaarden.app.models.Factories.MemberFactory;
import enggaarden.app.models.Member;
import enggaarden.app.models.MemberType;
import enggaarden.app.models.Subscription;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import enggaarden.app.models.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController
{
    @Autowired
    private MemberRepositoryInterface memberRepository = new MemberRepository();
    private MemberFactory memberFactory = new MemberFactory();

    @GetMapping("/members")
    public String home(Model model)
    {
        model.addAttribute("members",memberFactory.getMembers(memberRepository.get()));
        return "/Members/members_overview";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("member",new Member());
        model.addAttribute("memberTypes", MemberType.values());
        model.addAttribute("address", new Address());
        model.addAttribute("subscription", new Subscription());
        return "/Members/create_member";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Member member, Address address, Subscription subscription)
    {
        memberRepository.postMember(member, address, subscription);
        return "redirect:/members";
    }

    //TIL TEST
    @GetMapping("/index")
    public String index(Model model)
    {
        return "/index";
    }
}
