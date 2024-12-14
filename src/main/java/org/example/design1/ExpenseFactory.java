package org.example.design1;

class ExpenseFactory {

    public static ExpensesStrategy getInstance(String type){
        switch (type.toUpperCase()){
            case "EQUAL" : return new EqualExpensesStrategy();
            case "EXACT" : return new ExactExpensesStrategy();
            case "PERCENT" : return new PercentExpensesStrategy();
            default:
                throw new IllegalArgumentException("Invalid Split Type ");
        }
    }
}
