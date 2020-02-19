package eliseeassohoun.miage.psi.api.repository;


import eliseeassohoun.miage.psi.api.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends PagingAndSortingRepository<Profile, String> {
    Page <Profile> findAll(Pageable pageable);
    List<Profile> findAll();

    @Query(value = "SELECT * FROM `profile` p where p.first_name LIKE :firstName%", nativeQuery = true)
    List<Profile> findByFirstName(@Param("firstName") String firstName);
    @Query(value = "SELECT * FROM `profile` p where p.last_name LIKE :lastName%", nativeQuery = true)
    List<Profile> findByLastName(@Param("lastName") String lastName);
    @Query(value = "SELECT `industry_name`, COUNT(`industry_name`) FROM `profile` GROUP BY `industry_name` ORDER BY COUNT(`industry_name`) DESC", nativeQuery = true)
    List<String> groupByIndustryName();
    @Query(value = "SELECT `country_code`, COUNT(`country_code`) FROM `profile` GROUP BY `country_code` ORDER BY COUNT(`country_code`) DESC", nativeQuery = true)
    List<String> groupByCountryCode();
}
