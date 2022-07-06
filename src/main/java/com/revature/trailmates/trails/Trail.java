package com.revature.trailmates.trails;

public class Trail {

    private String id, name, short_desc, long_desc, image_url, website_url;
    private Boolean isReservationRequired, arePetsPermitted, doFeesApply;
    private int duration;

    public Trail(String id, String name, String short_desc, String long_desc, String image_url, String website_url, Boolean isReservationRequired, Boolean arePetsPermitted, Boolean doFeesApply, int duration) {
        this.id = id;
        this.name = name;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
        this.image_url = image_url;
        this.website_url = website_url;
        this.isReservationRequired = isReservationRequired;
        this.arePetsPermitted = arePetsPermitted;
        this.doFeesApply = doFeesApply;
        this.duration = duration;
    }

    public Trail() { }

    //<editor-fold desc="Get/Set">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public Boolean getReservationRequired() {
        return isReservationRequired;
    }

    public void setReservationRequired(Boolean reservationRequired) {
        isReservationRequired = reservationRequired;
    }

    public Boolean getArePetsPermitted() {
        return arePetsPermitted;
    }

    public void setArePetsPermitted(Boolean arePetsPermitted) {
        this.arePetsPermitted = arePetsPermitted;
    }

    public Boolean getDoFeesApply() {
        return doFeesApply;
    }

    public void setDoFeesApply(Boolean doFeesApply) {
        this.doFeesApply = doFeesApply;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    //</editor-fold>

}
