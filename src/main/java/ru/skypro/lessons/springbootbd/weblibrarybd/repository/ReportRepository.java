package ru.skypro.lessons.springbootbd.weblibrarybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.lessons.springbootbd.weblibrarybd.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
