package tech.ada.java.agendamentoconsultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.ada.java.agendamentoconsultas.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("""
            select (count(a) > 0) from Appointment a
            where a.appointmentDate = :appointmentDate and a.doctor.uuid = :doctorUuid and :startTime between a.appointmentStartTime and a.appointmentEndTime""")
    boolean appointmentExists(@Param("appointmentDate") LocalDate appointmentDate,
                              @Param("doctorUuid") UUID doctorUuid,
                              @Param("startTime") LocalTime appointmentStartTimeStart);



        List<Appointment> findAllByPatientUuid(UUID patientUuid);

        List<Appointment> findAllByDoctorUuid(UUID doctorUuid);

}
