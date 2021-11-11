package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.BloodDonationAppointment;
import com.keyin.domain.donar.BloodDonar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BloodDonationAppointmentManager {
    private Database database;

    public BloodDonationAppointmentManager(Database database) {
        this.database = database;
    }

    public BloodDonationAppointment bookAppointment(int bloodDonorId) throws InvalidDonationSchedulingException {
        BloodDonationAppointment bloodDonationAppointment = null;

        BloodDonar bloodDonar = database.getDonar(bloodDonorId);

        LocalDate today = LocalDate.now();
        LocalDate tooYougDate = today.minus(18, ChronoUnit.YEARS);

        if (bloodDonar.getDateOfBirth().isAfter(tooYougDate)) {
            throw new InvalidDonationSchedulingException("Blood donar is too young");
        }

        List<AppointmentSlot> appointmentSlotList = database.getAppointmentSlot();

        for (AppointmentSlot appointmentSlot: appointmentSlotList) {
            if (appointmentSlot.getBloodType().equalsIgnoreCase(bloodDonar.getBloodType())) {

            } else {
                throw new InvalidDonationSchedulingException("invalid blood type");
            }
        }

        return bloodDonationAppointment;
    }

}
