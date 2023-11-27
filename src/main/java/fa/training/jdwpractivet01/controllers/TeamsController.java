package fa.training.jdwpractivet01.controllers;

import fa.training.jdwpractivet01.entities.Teams;
import fa.training.jdwpractivet01.req.TeamReq;
import fa.training.jdwpractivet01.resp.TeamResp;
import fa.training.jdwpractivet01.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TeamsController {

    final private ModelMapper modelMapper;
    final private TeamsService teamsService;

    @GetMapping({"/teams","/"})
    public String getTeams(@ModelAttribute TeamReq teamReq, Model model) {
        List<Teams> teams = teamsService.findAllTeams();
        List<TeamResp> teamResps = new ArrayList<>();
        teams.forEach(t -> {
            TeamResp teamResp = modelMapper.map(t, TeamResp.class);
            teamResps.add(teamResp);
        });
        model.addAttribute("teamResps", teamResps);
        return "ui/teams";
    }

    @PostMapping("/teams")
    public String postTeams(@ModelAttribute @Validated TeamReq teamReq, BindingResult result, Model model) {
        if(result.hasErrors()){
            return getTeams(new TeamReq(), model);
        }
        System.out.println(teamReq.getId());
        Teams team = modelMapper.map(teamReq, Teams.class);
        teamsService.saveTeams(team);
        model.addAttribute("teamReq", new TeamReq());
        return getTeams(teamReq, model);
    }

    @GetMapping("/team/{id}")
    @ResponseBody
    public Teams getOneTeams(@PathVariable Long id, @ModelAttribute TeamReq teamReq) {
        return teamsService.findTeamById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));

    }

    @GetMapping("/team/delete/{id}")
    public String deleteTeam(@PathVariable Long id, @ModelAttribute TeamReq teamReq, Model model) {
        Teams team = teamsService.findTeamById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));
        teamsService.deleteTeams(team);
        return getTeams(teamReq,model);
    }
}
