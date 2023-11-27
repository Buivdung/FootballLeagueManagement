package fa.training.jdwpractivet01.repository;

import fa.training.jdwpractivet01.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
    boolean existsByTeamName(String name);
    Optional<Teams> findDistinctByTeamName(String name);
}
