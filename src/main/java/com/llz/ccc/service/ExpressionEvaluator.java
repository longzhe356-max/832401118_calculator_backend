package com.llz.ccc.service;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service
public class ExpressionEvaluator {

    public double evaluate(String expression) {
        String normalized = expression
                .replace("×", "*")
                .replace("÷", "/");

        if (normalized == null || normalized.isBlank()) {
            throw new IllegalArgumentException("表达式不能为空");
        }

        try {
            Expression exp = new ExpressionBuilder(normalized).build();
            double result = exp.evaluate();

            if (Double.isNaN(result) || Double.isInfinite(result)) {
                throw new ArithmeticException("计算结果无效");
            }
            return result;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("除数不能为零");
        } catch (Exception e) {
            throw new IllegalArgumentException("表达式语法错误");
        }
    }
}