package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.get(empId - 1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDto);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;

    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setEmpName(employeePayrollDto.empName);
        employeePayrollData.setSalary(employeePayrollDto.salary);
        employeePayrollList.set(empId-1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId - 1);
    }
}