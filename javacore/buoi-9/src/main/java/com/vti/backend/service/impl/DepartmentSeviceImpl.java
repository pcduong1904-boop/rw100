package com.vti.backend.service.impl;

import com.vti.backend.repository.IDepartmentRepository;
import com.vti.backend.repository.impl.DepartmentRepositoryImpl;
import com.vti.backend.service.IDepartmentService;
import com.vti.dto.ImportError;
import com.vti.dto.context.DepartmentContext;
import com.vti.dto.csv.DepartmentCsv;
import com.vti.entity.Department;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public void validation(String line, DepartmentContext context, List<Department> entities, List<ImportError<DepartmentCsv>> importErrors) {

        List<String> errors = new ArrayList<>(); // lưu lại ds lỗi

        String[] fields = line.split(",", -1);
        String departmentName = fields[0];

        // validation
        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            errors.add("Tên phòng ban ko được để trống");
        } else if (departmentName.length() > 100) {
            errors.add("Tên phòng ban ko được dài quá 100 kí tự");
        } else if (context.getMapByName().get(departmentName) != null) {
            errors.add("Tên phòng ban đã tồn tại");
        }

        if (errors.isEmpty()) {
            Department dep = new Department(departmentName);
            entities.add(dep);

            // check tồn tại cho file có nhiều gtri trùng lặp
            context.getMapByName().put(departmentName, dep);

        } else {
            DepartmentCsv csv = new DepartmentCsv(departmentName);
            ImportError importError = new ImportError(csv, errors);
            importErrors.add(importError);
        }

    }

    @Override
    public void saveAll(List<Department> entities) {
        departmentRepository.createListDepartment(entities);
    }

    @Override
    public void exportFileError(List<ImportError<DepartmentCsv>> importErrors, String pathError) {
        if (!importErrors.isEmpty()) {
            try {

                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));

                // header
                bw.write("department_name,error_message");
                bw.newLine();

                for (ImportError error : importErrors) {
                    String ln = error.getCsv() + "," + String.join("|", error.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }

                bw.flush();
                bw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String importDepartmentFromCSV(String pathName) {
        String pathError = "C:\\Users\\pcduo\\OneDrive\\Desktop\\rw100\\csv\\output_error_department.csv";
        Map<String, Department> mapByName = departmentRepository.mapByName();
        DepartmentContext context = new DepartmentContext(mapByName);
        String message = this.importFileCSV(pathName, context, pathError);
        return message;
    }
//
//    public void exportFileCSV(List<ImportError> importErrors, String pathError){
//        if (!importErrors.isEmpty()) {
//            try {

    /// /
//                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
//
//                // header
//                bw.write("department_name,error_message");
//                bw.newLine();
//
//                for (ImportError error : importErrors) {
//                    String ln = error.get() + "," + String.join("|", error.getMessage());
//                    bw.write(ln);
//                    bw.newLine();
//                }
//
//                bw.flush();
//                bw.close();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//

}
