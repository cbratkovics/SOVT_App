package com.bignerdranch.android.sovt_app;

public class Activity {
    private String time;
    private String event;

    public Activity(String time, String event){
        this.time = time;
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
