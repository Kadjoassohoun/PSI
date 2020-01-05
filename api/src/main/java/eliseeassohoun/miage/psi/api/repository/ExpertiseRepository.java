package eliseeassohoun.miage.psi.api.repository;


import eliseeassohoun.miage.psi.api.model.Expertise;
import eliseeassohoun.miage.psi.api.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ExpertiseRepository extends CrudRepository<Expertise, String> {
    Iterable <Expertise> findByProfile(Optional<Profile> profile);
    List<Expertise> findAll();
    @Query(value = "SELECT `company_name`, COUNT(`company_name`) FROM `expertise` GROUP BY `company_name` ORDER BY COUNT(`company_name`) DESC", nativeQuery = true)
    List<String> groupByCompanyName();
}
