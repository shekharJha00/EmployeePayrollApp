package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDto {
    public String empName;
    public long salary;

    public EmployeePayrollDto(String name, long salary) {
        this.empName = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "name='" + empName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
