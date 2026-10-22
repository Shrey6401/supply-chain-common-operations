package com.fsc.supply_chain_common_operations.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "procurement_companies")
@Entity
public class ProcurementCompany extends Company {

    private String procurementCode;
    private Integer fiscalYearStartMonth;
    private Boolean approvalRequired;
}