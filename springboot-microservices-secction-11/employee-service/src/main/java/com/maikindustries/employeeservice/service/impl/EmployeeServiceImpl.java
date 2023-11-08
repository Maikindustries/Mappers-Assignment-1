package com.maikindustries.employeeservice.service.impl;

import com.maikindustries.employeeservice.dto.EmployeeDto;
import com.maikindustries.employeeservice.entity.Employee;
import com.maikindustries.employeeservice.mapper.EmployeeMapper;
import com.maikindustries.employeeservice.repository.EmployeeRepository;
import com.maikindustries.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //Employee employee = new Employee(
        //        employeeDto.getId(),
        //        employeeDto.getFirstName(),
        //        employeeDto.getLastName(),
        //        employeeDto.getEmail()
        //);
        //Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        //EmployeeDto savedEmployeeDto = new EmployeeDto(
        //        savedEmployee.getId(),
        //        savedEmployee.getFirstName(),
        //        savedEmployee.getLastName(),
        //        savedEmployee.getEmail()
        //);
        //EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        //EmployeeDto employeeDto = new EmployeeDto(
        //        employee.getId(),
        //        employee.getFirstName(),
        //        employee.getLastName(),
        //        employee.getEmail()
        //);
        //EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        return employeeDto;
    }
}
