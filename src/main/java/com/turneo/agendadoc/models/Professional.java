package com.turneo.agendadoc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professionals")
@DiscriminatorValue("PROFESSIONAL")
@Data
@EqualsAndHashCode(callSuper = true)
public class Professional extends User {
    
    @NotBlank
    @Column(name = "specialty", nullable = false)
    private String specialty;
    
    @NotBlank
    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;
    
    @Column(name = "profile_picture_url")
    private String profilePictureUrl;
    
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscriptions = new ArrayList<>();
    
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointmentsAsProfessional = new ArrayList<>();
    
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkingHours> workingHours = new ArrayList<>();
    
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlockedTimeSlots> blockedTimeSlots = new ArrayList<>();
    
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patient> managedPatients = new ArrayList<>();
    
    @OneToOne(mappedBy = "professional", cascade = CascadeType.ALL, orphanRemoval = true)
    private AppointmentSettings appointmentSettings;
}

