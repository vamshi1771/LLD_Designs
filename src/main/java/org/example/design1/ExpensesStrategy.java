package org.example.design1;

import java.util.Date;
import java.util.List;

public interface ExpensesStrategy {
    void splitExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values);
}
