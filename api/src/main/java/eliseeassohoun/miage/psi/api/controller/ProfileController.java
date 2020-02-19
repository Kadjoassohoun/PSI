package eliseeassohoun.miage.psi.api.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import eliseeassohoun.miage.psi.api.model.Expertise;
import eliseeassohoun.miage.psi.api.model.Profile;
import eliseeassohoun.miage.psi.api.model.Skill;
import eliseeassohoun.miage.psi.api.repository.ExpertiseRepository;
import eliseeassohoun.miage.psi.api.repository.ProfileRepository;
import eliseeassohoun.miage.psi.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ExpertiseRepository expertiseRepository;

    @GetMapping(value = "")
    @ResponseBody
    public Page<Profile> getProfiles(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Optional<Profile> getProfileById(@PathVariable final String id) {

        return profileRepository.findById(id);
    }
    @GetMapping(value = "/by-lastname/{lastName}")
    @ResponseBody
    public List<Profile> getProfileByLastName(@PathVariable final String lastName) {
        return profileRepository.findByLastName(lastName);
    }

    @GetMapping(value = "/by-firstname/{firstName}")
    @ResponseBody
    public List<Profile> getProfileByFirstName(@PathVariable final String firstName) {
        return profileRepository.findByFirstName(firstName);
    }

    @GetMapping(value = "/{id}/skills")
    @ResponseBody
    public Iterable<Skill> getSkillsByProfileId(@PathVariable final String id) {
        return skillRepository.findByProfile(profileRepository.findById(id));
    }

    @GetMapping(value = "/{id}/expertises")
    @ResponseBody
    public Iterable<Expertise> getExpertisesByProfileId(@PathVariable final String id) {
        return expertiseRepository.findByProfile(profileRepository.findById(id));
    }

    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "profils.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        StatefulBeanToCsv<Profile> writer = new StatefulBeanToCsvBuilder<Profile>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(profileRepository.findAll());
    }

    @GetMapping(value = "/groupByIndustry")
    @ResponseBody
    public Iterable<String> groupByIndustry() {
        return profileRepository.groupByIndustryName();
    }

    @GetMapping(value = "/groupByCountryCode")
    @ResponseBody
    public Iterable<String> groupByCountryCode() {
        return profileRepository.groupByCountryCode();
    }

}


