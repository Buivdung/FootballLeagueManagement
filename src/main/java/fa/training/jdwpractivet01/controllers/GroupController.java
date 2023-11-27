package fa.training.jdwpractivet01.controllers;

import fa.training.jdwpractivet01.entities.Teams;
import fa.training.jdwpractivet01.req.TeamReq;
import fa.training.jdwpractivet01.resp.TeamResp;
import fa.training.jdwpractivet01.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GroupController {
    final private TeamsService teamsService;
    final private ModelMapper modelMapper;

    @GetMapping("/group")
    public String getTeams(@ModelAttribute TeamReq teamReq, Model model) {
        List<Teams> teams = teamsService.findAllTeams();
        List<TeamResp> teamResps = new ArrayList<>();
        teams.forEach(t -> {
            TeamResp teamResp = modelMapper.map(t, TeamResp.class);
            teamResps.add(teamResp);
        });
        model.addAttribute("teamResps", teamResps);
        return "ui/group";
    }

    @GetMapping("/getGroup")
    public String getGroup(@ModelAttribute TeamReq teamReq, Model model) {
        Map<String, List<Teams>> map = new HashMap<>();
        List<Teams> groupA = new ArrayList<>();
        List<Teams> groupB = new ArrayList<>();
        List<Teams> groupC = new ArrayList<>();
        List<Teams> groupD = new ArrayList<>();
        List<Teams> teams = teamsService.findAllTeams();
        if (teams.size() < 8 || teams.size() > 16) {
            model.addAttribute("message", "Cannot group because invalid number of teams");
        } else {
            teams.forEach(x -> {
                if (groupA.size() < 4) {
                    groupA.add(x);
                } else if (groupB.size() < 4) {
                    groupB.add(x);
                } else if (groupC.size() < 4) {
                    groupC.add(x);
                } else {
                    groupD.add(x);
                }
            });
            Teams team = Teams.builder().teamName("--").build();
            for (int i = 0; i < 5; i++) {
                if (groupC.size() < 4) {
                    groupC.add(team);
                }
                if (groupD.size() < 4) {
                    groupD.add(team);
                }
            }
            map.put("A", groupA);
            map.put("B", groupB);
            map.put("C", groupC);
            map.put("D", groupD);
            model.addAttribute("groups", map);
        }
        return getTeams(teamReq, model);
    }
}
