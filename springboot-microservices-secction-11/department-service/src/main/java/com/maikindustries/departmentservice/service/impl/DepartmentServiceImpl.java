package com.maikindustries.departmentservice.service.impl;

import com.maikindustries.departmentservice.dto.DepartmentDto;
import com.maikindustries.departmentservice.entity.Department;
import com.maikindustries.departmentservice.mapper.DepartmentMapper;
import com.maikindustries.departmentservice.repository.DepartmentRepository;
import com.maikindustries.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    // si una clase tiene 1 atributo, el autowired se pone en automatico
    //@Autowired
    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto savedDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity
        //Department department = new Department(
        //        departmentDto.getId(),
        //        departmentDto.getDepartmentName(),
        //        departmentDto.getDepartmentDescription(),
        //        departmentDto.getDepartmentCode()
        //);
        //Department department = modelMapper.map(departmentDto, Department.class);
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        //DepartmentDto savedDepartmentDto = new DepartmentDto(
        //        savedDepartment.getId(),
        //        savedDepartment.getDepartmentName(),
        //        savedDepartment.getDepartmentDescription(),
        //        savedDepartment.getDepartmentCode()
        //);
        //DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        //DepartmentDto departmentDto = new DepartmentDto(
        //        department.getId(),
        //        department.getDepartmentName(),
        //        department.getDepartmentDescription(),
        //        department.getDepartmentCode()
        //);
        //DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
