package com.vti.backend.controller;

import com.vti.backend.repository.IPostitionRepository;
import com.vti.backend.service.IPositionService;
import com.vti.backend.service.impl.PositionServiceImpl;
import com.vti.entity.Position;

import java.util.List;

public class PositionController {
    //khoi tao departmentSevice
    private IPositionService postitionService = new PositionServiceImpl();

    public boolean update(int id, String name) {
        boolean check = postitionService.update(id , name);
        return check;
    }

    public boolean delete(int id) {
        boolean check = postitionService.delete(id);
        return check;
    }

    public boolean create(String name) {
        boolean check = postitionService.create(name);
        return check;
    }

    public List<Position> findAll() {
        List<Position> positions = postitionService.findAll();
        return positions;
    }
}



