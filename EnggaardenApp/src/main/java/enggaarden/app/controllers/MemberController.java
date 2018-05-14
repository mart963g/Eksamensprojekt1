package enggaarden.app.controllers;

import enggaarden.app.models.Factories.MemberFactory;
import enggaarden.app.models.Entities.Member;
import enggaarden.app.models.Entities.MemberType;
import enggaarden.app.models.interfaces.MemberRepositoryInterface;
import enggaarden.app.models.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MemberController
{
    @Autowired
    private MemberRepositoryInterface memberRepository = new MemberRepository();
    private MemberFactory memberFactory = new MemberFactory();

    /*
    Overview Methods
     */
    @GetMapping("/members")
    public String membersOverview(Model model)
    {
        model.addAttribute("members",memberFactory.getMembers(memberRepository.get()));
        return "/Members/members_overview";
    }

    @GetMapping("/details")
    public String memberDetails(@RequestParam("memberId") int id, Model model)
    {
        model.addAttribute("member", memberFactory.getMember(memberRepository.get(id)));
        return "/Members/member_details";
    }

    /*
    Create Methods
     */
    @GetMapping("/create")
    public String createMember(Model model)
    {
        model.addAttribute("member",new Member());
        model.addAttribute("memberTypes", MemberType.values());
        return "/Members/member_create";
    }

    @PostMapping("/create")
    public String createMember(@ModelAttribute Member member)
    {
        memberRepository.postMember(member);
        return "redirect:/members";
    }

    /*
    Edit Methods
     */
    @GetMapping("/edit")
    public String editMember(@RequestParam("memberId") int id, Model model)
    {
        model.addAttribute("member", memberFactory.getMember(memberRepository.get(id)));
        model.addAttribute("memberTypes",MemberType.values());
        return "/Members/member_edit";
    }

    @PostMapping("/edit")
    public String editMember(@ModelAttribute Member member)
    {
        memberRepository.updateMember(member);
        return "redirect:/members";
    }
}
