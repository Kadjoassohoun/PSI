package eliseeassohoun.miage.psi.api.repository;

import eliseeassohoun.miage.psi.api.model.Profile;
import eliseeassohoun.miage.psi.api.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends CrudRepository<Skill, String> {
    Iterable<Skill> findByProfile(Optional<Profile> profile);
    List<Skill> findAll();

    @Query(value = "SELECT `name` AS `pays`, COUNT(`name`) AS `compteur` FROM `skill` GROUP BY `name` ORDER BY `compteur` DESC LIMIT 5", nativeQuery = true)
    List<String> getGroupByName();
}
