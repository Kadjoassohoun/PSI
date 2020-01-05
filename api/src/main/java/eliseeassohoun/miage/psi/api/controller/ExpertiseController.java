package eliseeassohoun.miage.psi.api.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import eliseeassohoun.miage.psi.api.model.Expertise;
import eliseeassohoun.miage.psi.api.repository.ExpertiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(path="/expertises")
public class ExpertiseController {

    @Autowired
    private ExpertiseRepository expertiseRepository;

    @GetMapping(value = "")
    @ResponseBody
    public Iterable<Expertise> getExpertises() { return expertiseRepository.findAll(); }
    @GetMapping(value = "/groupByCompany")
    @ResponseBody
    public Iterable<String> groupByCompany() { return expertiseRepository.groupByCompanyName(); }

    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "experiences.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        StatefulBeanToCsv<Expertise> writer = new StatefulBeanToCsvBuilder<Expertise>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        writer.write(expertiseRepository.findAll());
    }
}


