package org.example.design1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpensesManager {

    public static ExpensesManager expensesManager;
    private Map<String,Users> usersMap;
    private Map<String,Map<String,Double>> balances;

    private ExpensesManager(){
        System.out.println("please use getInstance method to get instance");
    }

    // singleton Pattern
    public static ExpensesManager getInstance(){
        if(expensesManager == null){
            synchronized (ExpensesManager.class){
                if(expensesManager == null){
                    return new ExpensesManager();
                }
            }
        }
        return expensesManager;
    }

//    "vamshi", "vamshi@email.com","U1","1234567890")
    public void addUsers(String name, String userId, String email, String phoneNumber){
        usersMap.put(userId, new Users(name,email,userId,phoneNumber));
        balances.putIfAbsent(userId, new HashMap<>());
    }

    public  void addExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values, String expensesType){
        ExpensesStrategy  strategy = ExpenseFactory.getInstance(expensesType);
        strategy.splitExpenses(paidBy,amount,involvedUsers,values);
    }

    public void updateBalances(String paidBy, double amount, String user){

    }
}
