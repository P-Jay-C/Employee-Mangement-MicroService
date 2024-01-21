package com.amalitech.org.departmentservice.repository;

import com.amalitech.org.departmentservice.models.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class DepartmentRepository {
    private final List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + id));
    }


    public List<Department> findAll() {
        return departments;
    }

}