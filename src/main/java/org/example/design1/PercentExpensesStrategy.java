package org.example.design1;

import java.util.List;

public class PercentExpensesStrategy implements ExpensesStrategy{

    @Override
    public void splitExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values) {
        if(100 != values.stream().mapToDouble(Double::doubleValue).sum()){
            throw  new IllegalArgumentException("Total sum of  percentages should be equal to 100");
        }
        for(int i =0;i<involvedUsers.size();i++){
            Double share = Double.valueOf(Math.round(amount * values.get(i) / 100.0) * 100);
            ExpensesManager instance = ExpensesManager.getInstance();
            String user = involvedUsers.get(i);
            instance.updateBalances(paidBy,share,user);
        }
    }
}
