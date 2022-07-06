package com.revature.trailmates.trailhistory;


import com.revature.trailmates.user.User;

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
    private User user;

    /*
    * creating a group table that will contain a list of users
    * that went to the trail with the current user
    */

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    @Override
    public String toString() {
        return "TrailHistory{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", trail='" + trail + '\'' +
                '}';
    }
}
