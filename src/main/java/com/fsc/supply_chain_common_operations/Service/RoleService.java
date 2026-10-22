package com.fsc.supply_chain_common_operations.Service;

import com.fsc.supply_chain_common_operations.Models.Company;
import com.fsc.supply_chain_common_operations.Models.Operation;
import com.fsc.supply_chain_common_operations.Models.Role;
import com.fsc.supply_chain_common_operations.Utilities.SystemUtility;
import com.fsc.supply_chain_common_operations.enums.CompanyType;
import com.fsc.supply_chain_common_operations.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    private OperationService operationService;
    private RoleRepo roleRepo;

    @Autowired
    public RoleService(OperationService operationService,
                       RoleRepo roleRepo){
        this.operationService = operationService;
        this.roleRepo = roleRepo;
    }

    public Role saveOrUpdate(Role role){
        return this.roleRepo.save(role);
    }
    public Role createMaintRole(Company company, CompanyType companyType){
        // Operation Service - To fetch maint role operations on the basis of company type
        List<Operation> operations = operationService.fetchMaintOperationsByCompanyType(companyType);
        Role role = Role.builder()
                .roleId(SystemUtility.generateId("ROLE"))
                .roleName(company.getCompanyName() + "_" + "MAINT")
                .operations(operations)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("system")
                .updatedBy("system")
                .build();
        return this.saveOrUpdate(role);
    }
}
