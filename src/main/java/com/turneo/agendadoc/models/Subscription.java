package com.turneo.agendadoc.models;

import com.turneo.agendadoc.models.enums.PlanType;
import com.turneo.agendadoc.models.enums.SubscriptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscriptions")
@Data
@EqualsAndHashCode(callSuper = true)
public class Subscription extends Base {
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professional_id", nullable = false)
    private Professional professional;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type", nullable = false)
    private PlanType planType;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SubscriptionStatus status;
    
    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "auto_renew", columnDefinition = "boolean default false")
    private Boolean autoRenew = false;
    
    @Column(name = "mercadopago_subscription_id")
    private String mercadopagoSubscriptionId;
    
    @Column(name = "mercadopago_preapproval_id")
    private String mercadopagoPreapprovalId;
    
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentHistory> paymentHistory = new ArrayList<>();
}

