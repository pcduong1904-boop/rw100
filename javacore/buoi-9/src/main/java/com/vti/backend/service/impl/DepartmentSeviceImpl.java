package com.vti.backend.service.impl;

import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.service.IDepartmentService;
import com.vti.entity.Department;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSeviceImpl implements IDepartmentService {
    // khoi tao doi tuong departmentRepository

    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> findAll() {
        // lay ra ds department tu repository
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public boolean create(String name) {
        boolean check = departmentRepository.create(name);
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = departmentRepository.delete(id);
        return check;
    }

    @Override
    public boolean update(int id, String name) {
        boolean check = departmentRepository.update(id, name);
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return departmentRepository.checkExistNameAndIdNot(name, id);
    }

    @Override
    public boolean checkExistID(Integer id) {
        return departmentRepository.checkExistID(id);
    }

    @Override
    public String importDepartmentFromCSV(String pathName) {
        // doc du lieu tu file va dua du lieu cho repository de lưu vao DB
        if (!pathName.endsWith(".csv")) {
            return "Định dạng file không đúng";
        }
        // FileReader: là 1 doi tuong dung de doc file , doc tung ki tu
        // BufferedReader: // ho tro doc theo tung dòng

        boolean checkCreate = false;
        List<Department> departments = new ArrayList<>();// chua ds department se dc them moi
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();// lay dòng dau tien, bo no di
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String departmentName = fields[0];
                // validation
                Department dep = new Department(departmentName);
                departments.add(dep);
            }

            //  luu vao DB
            checkCreate = departmentRepository.createListDepartment(departments);

            // xuat ra file loi

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "Import thành công ";
    }
}
