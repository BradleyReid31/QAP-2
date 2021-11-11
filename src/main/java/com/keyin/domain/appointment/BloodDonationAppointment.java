package com.keyin.domain.appointment;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Timer;

public class BloodDonationAppointment {

    private String Appointmentid;
    private LocalDate Date;
    private Time Time;
    private Timer Duration;
    private String Location;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    private String bloodType;
    private String FirstTimeDonar;
    private String DonarId;

    public String getAppointmentid() {
        return Appointmentid;
    }

    public void setAppointmentid(String appointmentid) {
        Appointmentid = appointmentid;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public java.sql.Time getTime() {
        return Time;
    }

    public void setTime(java.sql.Time time) {
        Time = time;
    }

    public Timer getDuration() {
        return Duration;
    }

    public void setDuration(Timer duration) {
        Duration = duration;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getFirstTimeDonar() {
        return FirstTimeDonar;
    }

    public void setFirstTimeDonar(String firstTimeDonar) {
        FirstTimeDonar = firstTimeDonar;
    }

    public String getDonarId() {
        return DonarId;
    }

    public void setDonarId(String donarId) {
        DonarId = donarId;
    }
}
