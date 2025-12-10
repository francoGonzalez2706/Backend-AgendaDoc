package com.turnos.agendadoc.models;

import com.turnos.agendadoc.models.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "appointment_settings")
@Data
@EqualsAndHashCode(callSuper = true)
public class AppointmentSettings extends Base {
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_id", nullable = false, unique = true)
    private Professional professional;
    
    @NotNull
    @Positive
    @Column(name = "default_duration_minutes", nullable = false)
    private Integer defaultDurationMinutes;
    
    @NotNull
    @Column(name = "allow_same_day_booking", nullable = false)
    private Boolean allowSameDayBooking = true;
    
    @NotNull
    @Positive
    @Column(name = "min_hours_notice", nullable = false)
    private Integer minHoursNotice; 
    
    @NotNull
    @Positive
    @Column(name = "max_days_advance", nullable = false)
    private Integer maxDaysAdvance; // días máximos para agendar
    
    @NotNull
    @Column(name = "send_confirmation_whatsapp", nullable = false)
    private Boolean sendConfirmationWhatsapp = true;
    
 
    @Column(name = "cancellation_allowed_hours")
    private Integer cancellationAllowedHours; // hasta cuántas horas antes puede cancelar
}

