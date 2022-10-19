package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollCustomException;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Data
@Service


public class EmployeePayrollService implements IEmployeePayrollService {


    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {

        return employeePayrollRepository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollCustomException("Employee Not Found With Id :" + empId));

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(long empId, EmployeePayrollDto empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataDepartment(String department){
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }
}