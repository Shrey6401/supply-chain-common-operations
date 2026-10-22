package com.fsc.supply_chain_common_operations.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "roles")
@Entity
public class Role extends Globalrecords{
    private String roleId; // ROLE-001
    private String roleName;
    @ManyToMany
    private List<Operation> operations;
}
