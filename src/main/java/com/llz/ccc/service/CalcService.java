package com.llz.ccc.service;

import com.llz.ccc.dto.CalcResponse;
import com.llz.ccc.entity.CalculationHistory;
import com.llz.ccc.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalcService {

    private final ExpressionEvaluator evaluator;
    private final HistoryRepository historyRepository;

    public CalcResponse calculate(String expression) {
        double result = evaluator.evaluate(expression);

        CalculationHistory history = new CalculationHistory();
        history.setExpression(expression);
        history.setResult(String.valueOf(result));
        history.setCreatedAt(LocalDateTime.now());
        historyRepository.save(history);

        return new CalcResponse(true, expression, result);
    }

    public List<CalculationHistory> getHistory() {
        return historyRepository.findAllByOrderByIdDesc();
    }

    public boolean deleteHistory(Long id) {
        if (historyRepository.existsById(id)) {
            historyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void clearHistory() {
        historyRepository.deleteAll();
    }
}