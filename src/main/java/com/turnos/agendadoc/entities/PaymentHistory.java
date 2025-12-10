package com.turnos.agendadoc.entities;

import com.turnos.agendadoc.entities.base.Base;
import com.turnos.agendadoc.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_history")
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentHistory extends Base {
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;
    
    @NotNull
    @Positive
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
    
    @NotNull
    @Column(name = "currency", nullable = false, length = 3)
    private String currency = "ARS";
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;
    
    @NotNull
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
    
    @Column(name = "mercadopago_payment_id")
    private String mercadopagoPaymentId;
    
    @Column(name = "payment_method_type")
    private String paymentMethodType;
}

