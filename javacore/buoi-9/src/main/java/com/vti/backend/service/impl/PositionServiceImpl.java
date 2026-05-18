package com.vti.backend.service.impl;

import com.vti.backend.repository.IPostitionRepository;
import com.vti.backend.repository.impl.PositionRepositoryImpl;
import com.vti.backend.service.IPositionService;
import com.vti.entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPostitionRepository positionRepository  = new PositionRepositoryImpl();
        @Override
        public List<Position> findAll() {
            List<Position> positions = positionRepository.findAll();
            return positions;
        }

    @Override
    public boolean create(String name) {
        boolean check = positionRepository. create(name);
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = positionRepository.delete(id);
        return check;
    }

    @Override
    public boolean update(int id, String name) {
        boolean check = positionRepository.update(id, name);
        return check;
    }
}

