package com.llz.ccc.controller;

import com.llz.ccc.dto.CalcRequest;
import com.llz.ccc.dto.CalcResponse;
import com.llz.ccc.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalcController {

    private final CalcService calcService;

    @PostMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestBody CalcRequest request) {
        try {
            CalcResponse response = calcService.calculate(request.getExpression());
            return ResponseEntity.ok(response);
        } catch (ArithmeticException | IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("success", false, "message", e.getMessage()));
        }
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory() {
        return ResponseEntity.ok(Map.of("success", true, "data", calcService.getHistory()));
    }

    @DeleteMapping("/history/{id}")
    public ResponseEntity<?> deleteHistory(@PathVariable Long id) {
        boolean deleted = calcService.deleteHistory(id);
        return deleted
                ? ResponseEntity.ok(Map.of("success", true))
                : ResponseEntity.status(404).body(Map.of("success", false, "message", "记录不存在"));
    }

    @DeleteMapping("/history")
    public ResponseEntity<?> clearHistory() {
        calcService.clearHistory();
        return ResponseEntity.ok(Map.of("success", true));
    }
}