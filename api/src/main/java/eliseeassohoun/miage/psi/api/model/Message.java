package eliseeassohoun.miage.psi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity // make a table for this class
@Table(name="message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "message_id")
    private int messageId;
    @Column(name = "profile_id")
    private int profileId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "date")
    //@CreatedDate
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date date;
    private String date;


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }




    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getContenu() {
        return contenu;
    }

    public String getDate() {
        return date;
    }



    // pour tester en local
    public Message(int message_id, int profile_id, String contenu, String date) {
        this.messageId = message_id;
        this.profileId = profile_id;
        this.contenu = contenu;
        this.date = date;
    }


    public Message() {
    }

    public String toString(){
        return "Product{"+
                "message_id=" + messageId +
                "profile_id=" + profileId+
                ",contenu='"+ contenu + '\'' +
                ", date=" + date+ '}';
    }
}

