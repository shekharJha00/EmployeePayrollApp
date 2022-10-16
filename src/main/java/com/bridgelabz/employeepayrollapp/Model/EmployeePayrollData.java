package com.bridgelabz.employeepayrollapp.Model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;

public class EmployeePayrollData {

    private long empId;
    private String empName;
    private long salary;

    public EmployeePayrollData(long empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.empName = employeePayrollDto.empName;
        this.salary = employeePayrollDto.salary;
    }

    public EmployeePayrollData(String empName, long salary) {
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
