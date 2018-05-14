package enggaarden.app.controllers;

import enggaarden.app.models.Entities.ActivityType;
import enggaarden.app.models.Entities.Contribution;
import enggaarden.app.models.Factories.ContributionFactory;
import enggaarden.app.models.repositories.ContributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContributionController
{
    @Autowired
    private ContributionRepository contributionRepository = new ContributionRepository();
    private ContributionFactory contributionFactory = new ContributionFactory();

    /*
    Overview Methods
     */
    @GetMapping("/contributions")
    public String home(Model model)
    {
        model.addAttribute("contributions",contributionFactory.getContributions(contributionRepository.get()));
        return "/Contributions/contribution_overview";
    }

    /*
    Create Methods
     */
    @GetMapping("/contributions/create")
    public String create(Model model)
    {
        model.addAttribute("contribution",new Contribution());
        model.addAttribute("activities", ActivityType.values());
        return "/Contributions/contribution_create";
    }

    @PostMapping("/contributions/create")
    public String create(@ModelAttribute Contribution contribution)
    {
        contributionRepository.postContribution(contribution);
        return "redirect:/contributions";
    }

    /*
    Edit Methods
     */
    @GetMapping("/contributions/edit")
    public String edit(@RequestParam("contributionId") int id, Model model)
    {
        model.addAttribute("contribution",contributionFactory.getContribution(contributionRepository.get(id)));
        model.addAttribute("activities",ActivityType.values());

        return "/Contributions/contribution_edit";
    }

    @PostMapping("/contributions/edit")
    public String edit(@ModelAttribute Contribution contribution)
    {
        contributionRepository.updateContribution(contribution);

        return "redirect:/contributions";
    }

}
