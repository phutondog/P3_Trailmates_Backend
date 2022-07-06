package com.revature.trailmates.trailhistory;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trailhistory")
public class TrailHistory {

    @Id
    private String id;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "trailDate", nullable = false)
    private Timestamp date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private String user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trail_id", referencedColumnName = "id")
    private String trail;

    public TrailHistory() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }
}
