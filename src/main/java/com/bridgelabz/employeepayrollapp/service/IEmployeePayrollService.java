package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

import java.util.List;

public interface IEmployeePayrollService {


    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(long empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto);

    EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDto employeePayrollDto);

    void deleteEmployeePayrollData(long empId);

    List<EmployeePayrollData> getEmployeePayrollDataDepartment(String department);

}
