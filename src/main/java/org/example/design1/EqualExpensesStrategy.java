package org.example.design1;

import java.util.List;

public class EqualExpensesStrategy implements  ExpensesStrategy{

    @Override
    public void splitExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values) {
        int noOfUserInvolved = involvedUsers.size();
        double splitAmount = Math.round((amount/noOfUserInvolved)*100)/100;
        double firstUserAmount = Math.round(amount - (splitAmount*noOfUserInvolved-1)*100)/100;

        for(int i =0 ;i<noOfUserInvolved;i++){
            double val = i == 0 ? firstUserAmount : splitAmount;
            ExpensesManager instance = ExpensesManager.getInstance();
            String user = involvedUsers.get(i);
            instance.updateBalances(paidBy,amount,user);
        }
    }
}
