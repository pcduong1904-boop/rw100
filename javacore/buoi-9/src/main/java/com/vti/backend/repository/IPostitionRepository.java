package com.vti.backend.repository;

import com.vti.entity.Position;

import java.util.List;

public interface IPostitionRepository {
    List<Position> findAll();

    boolean create(String name);

    boolean delete(int id);

    boolean update(int id, String name);
}
