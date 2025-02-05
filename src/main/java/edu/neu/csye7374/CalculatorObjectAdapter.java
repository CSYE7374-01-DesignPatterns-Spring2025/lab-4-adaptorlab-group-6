package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.CalculatableAPI.OPERATION;
public class CalculatorObjectAdapter implements AccumulatableAPI {

    private CalculatableAPI calculator;
    private double sum;

    public CalculatorObjectAdapter(CalculatableAPI calc){
        super();
        this.calculator = calc;
        this.sum = 0;
    }

    @Override
    public double accumulation(List<Double> itemPrices){
        sum = 0;
        for(double itemPrice: itemPrices){
            sum = this.calculator.operation(OPERATION.ADD, sum, itemPrice);
        }
        return sum;
    }

    @Override
    public double payment(double cash){
        return this.calculator.operation(OPERATION.SUB, cash, sum);
    }

    public static void demo(){
        CalculatableAPI concreteCalculator = new ConcreteCalculator();

        CalculatorObjectAdapter adapter = new CalculatorObjectAdapter(concreteCalculator);

        List<Double> itemPrices = new ArrayList<Double>();
        itemPrices.add(10.0);
        itemPrices.add(20.0);
        itemPrices.add(30.0);

        double total = adapter.accumulation(itemPrices);

        System.out.println("Total price: " + total);

        double cash = 100.0;
        double change = adapter.payment(cash);

        System.out.println("Change: " + change);
    }
}
