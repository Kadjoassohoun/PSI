package eliseeassohoun.miage.psi.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {
    @Id
    @Column(name="skill_id")
    private  String skillId;

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profile profile;

    public String getSkillId() {
        return skillId;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }
}


