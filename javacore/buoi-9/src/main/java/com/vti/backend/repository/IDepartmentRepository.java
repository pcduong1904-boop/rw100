package com.vti.backend.repository;

import com.vti.entity.Department;

import java.util.List;
import java.util.Map;

public interface IDepartmentRepository {
    List<Department> findAll();
    boolean create(String name);

    boolean delete(int id);

    boolean createListDepartment(List<Department> list);

    boolean update(int id, String name);

    boolean checkExistNameAndIdNot(String name, Integer id);

    boolean checkExistID(Integer id);

    Map<String, Department> mapByName();
}
