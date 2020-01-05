package eliseeassohoun.miage.psi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    @Id
    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "industry_name")
    private String industryName;

    @Column(name = "headline")
    private String headline;

    public String getProfileId() {
        return profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getIndustryName() {
        return industryName;
    }

    public String getHeadline() {
        return headline;
    }
}

