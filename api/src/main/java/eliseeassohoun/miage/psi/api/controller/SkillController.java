package eliseeassohoun.miage.psi.api.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import eliseeassohoun.miage.psi.api.model.Skill;
import eliseeassohoun.miage.psi.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path="/skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping(value = "")
    @ResponseBody
    public List<Skill> getSkills() { return skillRepository.findAll(); }

    @GetMapping(value = "/groupByName")
    @ResponseBody
    public Iterable<String> getSkillByName() {
        return skillRepository.getGroupByName();
    }
    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "competences.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        StatefulBeanToCsv<Skill> writer = new StatefulBeanToCsvBuilder<Skill>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(skillRepository.findAll());
    }
}


