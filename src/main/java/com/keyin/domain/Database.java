package com.keyin.domain;

import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.donar.BloodDonar;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public List<AppointmentSlot> getAppointmentSlot(){
        ArrayList<AppointmentSlot> appointmentSlots = new ArrayList<AppointmentSlot>();

        AppointmentSlot appointmentSlot = new AppointmentSlot();
        appointmentSlot.setId(1);
        appointmentSlot.setLocation("Somewhere down the bay");
        appointmentSlot.setDate(LocalDate.now());
        appointmentSlot.setStartTime("3:00pm");
        appointmentSlot.setEndTime("4:00pm");
        appointmentSlot.setBloodType("A");

        appointmentSlots.add(appointmentSlot);

        return appointmentSlots;
    }

    public BloodDonar getDonar(int id) {
        BloodDonar bloodDonar = new BloodDonar();

        bloodDonar.setDateOfBirth(LocalDate.of( 1994 , Month.JANUARY , 20 ));

        return bloodDonar;
    }

}
