package eliseeassohoun.miage.psi.api.controller;

import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping(path="/locations")
public class LocationController {
    @GetMapping(value = "/latlong/{countryCode}")
    public String getLatLongByCountryCode(@PathVariable final String countryCode) {
        JSONParser parser = new JSONParser();
        JSONArray latLong;
        JSONObject object;

        String data = "";
        ClassPathResource cpr = new ClassPathResource("latlong-by-countrycode.json");
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return e.getMessage();
        }
        try {
            object = (JSONObject)  parser.parse(data);
            latLong = (JSONArray) object.get(countryCode);

            return String.valueOf(latLong);

        } catch (ParseException e) {
            return e.getMessage();
        }
    }
}
