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
    public void addUsers(String name, String userId, String email, String phoneNumber){
        usersMap.put(userId, new Users(name,email,userId,phoneNumber));
        balances.putIfAbsent(userId, new HashMap<>());
    }

    public  void addExpenses(String paidBy, double amount, List<String> involvedUsers, List<Double> values, String expensesType){
        ExpensesStrategy  strategy = ExpenseFactory.getInstance(expensesType);
        strategy.splitExpenses(paidBy,amount,involvedUsers,values);
    }

    public void updateBalances(String paidBy, double amount, String user){
        if(!paidBy.equals(user))
        {
            balances.get(paidBy).put(user, balances.get(paidBy).getOrDefault(user, 0.0) + amount);
            balances.get(user).put(paidBy, balances.get(user).getOrDefault(paidBy, 0.0) - amount);
        }
    }

    void showBalances(){
        for(Map.Entry<String,Map<String,Double>> entry : balances.entrySet()){
            String user1 = entry.getKey();
            for(Map.Entry<String,Double> entry1 : entry.getValue().entrySet()){
                Double balance = entry1.getValue();
                if(balance > 0){
                    System.out.println(entry1.getKey() + "owes" + balance + " to" + user1);
                }
            }
        }
    }
    void showBalances(String userId){
        for(Map.Entry<String,Double> entry : balances.get(userId).entrySet()){
            if(entry.getValue() > 0){
                System.out.println(entry.getKey() + "owes" + entry.getValue() + " to" + userId);
            }
        }
    }
}
