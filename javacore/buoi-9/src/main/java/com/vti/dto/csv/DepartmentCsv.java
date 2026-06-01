package com.vti.dto.csv;

public class DepartmentCsv { // 7 usages  new *
    private String departmentName; // 4 usages

    public DepartmentCsv(String departmentName) { // 1 usage  new *
        this.departmentName = departmentName;
    }

    public String getDepartmentName() { // no usages  new *
        return departmentName;
    }

    public void setDepartmentName(String departmentName) { // no usages  new *
        this.departmentName = departmentName;
    }

    @Override // new *
    public String toString() {
        return departmentName;
    }
}