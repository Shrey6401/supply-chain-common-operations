package com.fsc.supply_chain_common_operations.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operations")
public class Operation extends Globalrecords{
    @Column(unique = true, nullable = false)
    private String operationId; // OPR-01
    @Column(unique = true, nullable = false)
    private String operationName; // CREATE_PURCHASE_REQUEST
    private String operationCategory; // PROCUREMENT
}
