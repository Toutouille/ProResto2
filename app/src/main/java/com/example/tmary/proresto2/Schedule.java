package com.example.tmary.proresto2;

/**
 * Created by Petermarzinou on 21/12/2015.
 */
public class Schedule{

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    public Schedule(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public Schedule()
    {
        monday = "";
        tuesday = "";
        wednesday = "";
        thursday = "";
        friday = "";
        saturday = "";
        sunday = "";
    }

    public Schedule(String UniqSchedule)
    {
        monday = UniqSchedule;
        tuesday = UniqSchedule;
        wednesday = UniqSchedule;
        thursday = UniqSchedule;
        friday = UniqSchedule;
        saturday = UniqSchedule;
        sunday = UniqSchedule;
    }

    public Schedule(String UniqSchedule, int close)
    {
        switch (close)
        {
            case 1:
                monday = UniqSchedule;
                tuesday = UniqSchedule;
                wednesday = UniqSchedule;
                thursday = UniqSchedule;
                friday = UniqSchedule;
                saturday = UniqSchedule;
                sunday = "Fermé";
                break;
            case 2:
                monday = UniqSchedule;
                tuesday = UniqSchedule;
                wednesday = UniqSchedule;
                thursday = UniqSchedule;
                friday = UniqSchedule;
                saturday = "Fermé";
                sunday = "Fermé";
                break;
            case 3:
                monday = UniqSchedule;
                tuesday = UniqSchedule;
                wednesday = UniqSchedule;
                thursday = UniqSchedule;
                friday = "Fermé";
                saturday = "Fermé";
                sunday = "Fermé";
                break;
            default:
                monday = UniqSchedule;
                tuesday = UniqSchedule;
                wednesday = UniqSchedule;
                thursday = UniqSchedule;
                friday = UniqSchedule;
                saturday = UniqSchedule;
                sunday = UniqSchedule;

        }

    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }





}