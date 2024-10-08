package xruisu.project.unitylink.teams;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, String> {
    Optional<Team> findByTeamId(String teamId);
    }