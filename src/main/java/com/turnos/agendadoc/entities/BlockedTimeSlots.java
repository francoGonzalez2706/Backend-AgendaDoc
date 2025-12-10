package com.turnos.agendadoc.entities;

import com.turnos.agendadoc.entities.base.Base;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "blocked_time_slots")
@Data
@EqualsAndHashCode(callSuper = true)
public class BlockedTimeSlots extends Base {
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_id", nullable = false)
    private Professional professional;
    
    @NotNull
    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDatetime;
    
    @NotNull
    @Column(name = "end_datetime", nullable = false)
    private LocalDateTime endDatetime;
    
    @Column(name = "reason")
    private String reason; 
}

