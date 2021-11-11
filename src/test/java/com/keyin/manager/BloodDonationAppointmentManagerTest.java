package com.keyin.manager;

import com.keyin.domain.Database;
import com.keyin.domain.appointment.AppointmentSlot;
import com.keyin.domain.appointment.BloodDonationAppointment;
import com.keyin.domain.donar.BloodDonar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class BloodDonationAppointmentManagerTest {
    @Mock
    private Database mockDatabase;

    @Test
    public void testBloodDonarTooYoung() {
        BloodDonar bloodDonarTooYoung = new BloodDonar();
        bloodDonarTooYoung.setFirstName("Billy");
        bloodDonarTooYoung.setLastName("Bob");
        bloodDonarTooYoung.setBloodType("A");
        bloodDonarTooYoung.setDateOfBirth(LocalDate.of( 2009 , Month.JANUARY, 30 ));
        bloodDonarTooYoung.setId(1);

        Mockito.when(mockDatabase.getDonar(1)).thenReturn(
                bloodDonarTooYoung
        );

        BloodDonationAppointmentManager bloodDonationAppointmentManager =
                new BloodDonationAppointmentManager(mockDatabase);

        try {
            BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("donor too young"));
        }

    }

    @Test
    public void testBloodDonorInvalidType() {
        BloodDonar bloodDonarTooYoung = new BloodDonar();
        bloodDonarTooYoung.setFirstName("Joe");
        bloodDonarTooYoung.setLastName("Batts");
        bloodDonarTooYoung.setBloodType("A");
        bloodDonarTooYoung.setDateOfBirth(LocalDate.of( 1954 , Month.AUGUST , 10 ));
        bloodDonarTooYoung.setId(1);

        Mockito.when(mockDatabase.getDonar(1)).thenReturn(
                bloodDonarTooYoung
        );

        ArrayList<AppointmentSlot> appointmentSlots = new ArrayList<AppointmentSlot>();

        AppointmentSlot appointmentSlotTypeA = new AppointmentSlot();
        appointmentSlotTypeA.setId(1);
        appointmentSlotTypeA.setLocation("Over here");
        appointmentSlotTypeA.setBloodType("A");
        appointmentSlots.add(appointmentSlotTypeA);

        AppointmentSlot appointmentSlot = new AppointmentSlot();
        appointmentSlot.setId(1);
        appointmentSlot.setLocation("over there!");
        appointmentSlot.setBloodType("B");
        appointmentSlots.add(appointmentSlot);


        Mockito.when(mockDatabase.getAppointmentSlot()).thenReturn(appointmentSlots);

        BloodDonationAppointmentManager bloodDonationAppointmentManager =
                new BloodDonationAppointmentManager(mockDatabase);

        try {
            BloodDonationAppointment bloodDonationAppointment = bloodDonationAppointmentManager.bookAppointment(1);
        } catch (InvalidDonationSchedulingException e) {
            Assertions.assertTrue(e.getMessage().equalsIgnoreCase("invalid blood type"));
        }

    }
}
