package ru.skypro.lessons.springbootbd.weblibrarybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
