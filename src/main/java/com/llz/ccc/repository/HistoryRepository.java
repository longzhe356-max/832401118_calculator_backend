package com.llz.ccc.repository;

import com.llz.ccc.entity.CalculationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoryRepository extends JpaRepository<CalculationHistory, Long> {
    List<CalculationHistory> findAllByOrderByIdDesc();
}