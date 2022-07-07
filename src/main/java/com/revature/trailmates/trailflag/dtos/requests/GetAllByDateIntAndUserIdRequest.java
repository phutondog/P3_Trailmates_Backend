package com.revature.trailmates.trailflag.dtos.requests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class GetAllByDateIntAndUserIdRequest {


private String user_id;

    private long date_int;


    public GetAllByDateIntAndUserIdRequest() {
    }

    public GetAllByDateIntAndUserIdRequest( long date_int,String user_id) {
        this.user_id = user_id;
        this.date_int = date_int;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getDate_int() {
        return date_int;
    }

    public void setDate_int(long date_int) {
        this.date_int = date_int;
    }
}
