package fa.training.jdwpractivet01.service;

import fa.training.jdwpractivet01.entities.Teams;

import java.util.List;
import java.util.Optional;

public interface TeamsService {
    List<Teams> findAllTeams();
    Teams saveTeams(Teams teams);
    void deleteTeams(Teams teams);

    Optional<Teams> findTeamById(Long id);

//    boolean existsByTeamName(String name);
}
