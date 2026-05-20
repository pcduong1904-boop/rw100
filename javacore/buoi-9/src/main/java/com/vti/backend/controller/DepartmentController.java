package com.vti.backend.controller;

import com.vti.backend.service.IDepartmentService;

import com.vti.backend.service.impl.DepartmentSeviceImpl;
import com.vti.entity.Department;

import java.util.List;

public class DepartmentController {
    //khoi tao departmentSevice
    private IDepartmentService departmentService = new DepartmentSeviceImpl();

    public List<Department> findAll(){
        //lay ds tu service
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    public boolean create(String name) {
        boolean check = departmentService.create(name);
        return check;
    }

    public boolean delete(int id) {
        boolean check = departmentService.delete(id);
        return check;
    }

    public boolean update(int id, String name) {
        boolean check = departmentService.update(id,name);
        return check;
    }
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return departmentService.checkExistNameAndIdNot(name, id);
    }

    public boolean checkExistID(Integer id) {
        return departmentService.checkExistID(id);
    }
}
