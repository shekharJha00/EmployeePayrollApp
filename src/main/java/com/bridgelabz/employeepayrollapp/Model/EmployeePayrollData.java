package com.bridgelabz.employeepayrollapp.Model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private long empId;
    @Column(name = "empName")
    private String empName;

    private long salary;

    private String gender;

    private LocalDate startDate;

    private String note;

    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public void updateEmployeePayrollData(EmployeePayrollDto employeePayrollDTO) {
        this.empName = employeePayrollDTO.getEmpName();
        this.salary = employeePayrollDTO.getSalary();
        this.department = employeePayrollDTO.getDepartment();
        this.gender = employeePayrollDTO.getGender();
        this.note = employeePayrollDTO.getNote();
        this.startDate = employeePayrollDTO.getStartDate();
        this.profilePic = employeePayrollDTO.getProfilePic();
    }
}


