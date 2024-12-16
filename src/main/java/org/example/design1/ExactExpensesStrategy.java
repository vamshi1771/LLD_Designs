package org.example.design1;

import javax.xml.validation.Validator;
import java.util.List;

public class ExactExpensesStrategy implements ExpensesStrategy{

    @Override
    public void splitExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values) {
        if(amount != values.stream().mapToDouble(Double::doubleValue).sum()){
            throw new IllegalArgumentException("Split operation is Incorrect as Total amount didn't match");
        }
        for(int i =0;i< involvedUsers.size();i++){
            ExpensesManager instance = ExpensesManager.getInstance();
            String user  = involvedUsers.get(i);
            instance.updateBalances(paidBy,values.get(i),user);
        }
    }
}
