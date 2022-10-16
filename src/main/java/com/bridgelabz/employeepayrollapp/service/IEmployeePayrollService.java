package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

import java.util.List;

public interface IEmployeePayrollService {


    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto);

    void deleteEmployeePayrollData(int empId);

}
