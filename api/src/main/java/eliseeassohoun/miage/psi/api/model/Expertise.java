package eliseeassohoun.miage.psi.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "expertise")
public class Expertise implements Serializable {
    @Id
    @Column(name="expertise_id")
    private String expertiseId;

    @Column(name="title")
    private String title;

    @Column(name="company_name")
    private String companyName;

    @Column(name = "location_name")
    private String locationName;

    @Column(name="start_year")
    private Integer startYear;

    @Column(name="end_year")
    private Integer endYear;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profile_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profile profile;


    public String getExpertiseId() {
        return expertiseId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocationName() {
        return locationName;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Profile getProfile() {
        return profile;
    }
}


