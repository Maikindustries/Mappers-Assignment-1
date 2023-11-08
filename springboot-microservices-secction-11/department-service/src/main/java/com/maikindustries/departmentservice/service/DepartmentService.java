package com.maikindustries.departmentservice.service;

import com.maikindustries.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto savedDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
