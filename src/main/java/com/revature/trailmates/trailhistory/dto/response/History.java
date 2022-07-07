package com.revature.trailmates.trailhistory.dto.response;

import java.sql.Date;

/**
 * this class will be used to return history objects
 */
public class History {

    private String trailName;
    private String partnerName;
    private String comment;
    private Date date;

    public History() {
    }

    public History(String trailName, String partnerName, String comment, Date date) {
        this.trailName = trailName;
        this.partnerName = partnerName;
        this.comment = comment;
        this.date = date;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "trailName='" + trailName + '\'' +
                ", partnerName='" + partnerName + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
