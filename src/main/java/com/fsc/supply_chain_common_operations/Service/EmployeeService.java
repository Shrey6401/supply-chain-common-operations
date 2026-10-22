package com.fsc.supply_chain_common_operations.Service;

import com.fsc.supply_chain_common_operations.Models.Company;
import com.fsc.supply_chain_common_operations.Models.Employee;
import com.fsc.supply_chain_common_operations.Models.Role;
import com.fsc.supply_chain_common_operations.Utilities.SystemUtility;
import com.fsc.supply_chain_common_operations.enums.CompanyType;
import com.fsc.supply_chain_common_operations.repositories.EmployeeRepo;
import com.fsc.supply_chain_common_operations.transformers.EntityTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeService implements EntityService<Employee> {

    private RoleService roleService;
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(RoleService roleService,
                           EmployeeRepo employeeRepo){
        this.roleService = roleService;
        this.employeeRepo = employeeRepo;
    }

    public Employee saveOrUpdate(Employee employee){
        return this.employeeRepo.save(employee);
    }

    //TODO - We need to send email notification to the employee regarding account creation and account credentials.
    public Employee createMaintUserForCompany(Company company, CompanyType companyType){
        // Before creating employee/user we need to know what role we need to assign to that user.
        // TCS - register
        // TCS - SUper User - Role ? But at the time of registration no roles exist for TCS
        // Super Admin Role
        // When a company will register our system will be intelligent enough to create super user with super admin role for that company.
        // We need to create role first - roleService
        Role maintRole = roleService.createMaintRole(company, companyType);
        // Create first employee on the basis of whatever information we are getting from company model
        Employee maintEmployee = EntityTransformer.mapCompanyToEmployee(company, SystemUtility.generatePassword(10));
        maintEmployee.setRoles(List.of(maintRole));
        // Maint Employee is created.
        // Save this employee in employees table.
        maintEmployee = this.saveOrUpdate(maintEmployee);
        // Notification should be sent on the employees email regarding the account creation and account credentials
        // Email Notification
        return maintEmployee;
    }

}