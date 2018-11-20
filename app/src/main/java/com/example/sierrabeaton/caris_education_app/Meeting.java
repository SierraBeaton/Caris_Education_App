package com.example.sierrabeaton.caris_education_app;

public class Meeting {
    //Class of Meeting to fill with data to use in the database
    //fields
    private int meetingID;
    private String meetingName;
    private String meetingPlace;
    private String meetingTime;
    private String meetingDescription;
    //constructors
    public Meeting() {}
    public Meeting(int id, String meetName, String meetPlace, String meetTime, String meetDescription)
    {
        this.meetingID = id;
        this.meetingName = meetName;
        this.meetingPlace = meetPlace;
        this.meetingTime = meetTime;
        this.meetingDescription = meetDescription;
    }
    //properties of setters and getters
    public void setMeetingID (int meetid)
        {
            this.meetingID = meetid;
        }
    public int getMeetingID ()
        {
            return this.meetingID;
        }

    public void setMeetingName (String meetName)
        {
            this.meetingName = meetName;
        }
    public String getMeetingName() { return this.meetingName; }

    public void setMeetingPlace (String meetPlace) { this.meetingPlace = meetPlace; }
    public String getMeetingPlace () { return this.meetingPlace; }

    public void setMeetingTime (String meetTime) { this.meetingTime = meetTime; }
    public String getMeetingTime () { return this.meetingTime; }

    public void setMeetingDescription (String meetDesccription) { this.meetingDescription = meetDesccription; }
    public String getMeetingDescription () { return this.meetingDescription; }
}
