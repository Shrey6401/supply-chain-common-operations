package com.fsc.supply_chain_common_operations.Models;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseRequestLine extends RequestLine {

    @ManyToOne
    private PurchaseRequest purchaseRequest;

    @Column(precision = 19, scale = 4)
    private BigDecimal estimatedUnitPrice;

    @Column(precision = 19, scale = 4)
    private BigDecimal estimatedLineAmount;

    @Column(length = 3)
    private String currencyCode;

    private LocalDate requiredDate;

    @Column(length = 500)
    private String deliveryLocation;

    @Column(precision = 7, scale = 4)
    private BigDecimal taxRate;
}

