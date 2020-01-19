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

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", industryName='" + industryName + '\'' +
                ", headline='" + headline + '\'' +
                '}';
    }
}

