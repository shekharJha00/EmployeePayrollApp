package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.Model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/EmployeePayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDto respDTO = new ResponseDto("Get Call Successful", empDataList);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);

    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDto responseDto = new ResponseDto("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);


    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDto responseDto = new ResponseDto("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayroll(@PathVariable("empId") int empId,
                                                             @Valid @RequestBody EmployeePayrollDto empPayrollDto) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDto);
        ResponseDto responseDto = new ResponseDto("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDto> getEmployeeByDepartment(@PathVariable("department") String department) {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollDataDepartment(department);
        ResponseDto responseDto = new ResponseDto("Get Call For Department Successful", employeePayrollDataList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

    }
}