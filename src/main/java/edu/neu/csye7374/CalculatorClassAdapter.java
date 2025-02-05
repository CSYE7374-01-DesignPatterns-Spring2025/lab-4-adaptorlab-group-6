package edu.neu.csye7374;

import java.util.List;

public class CalculatorClassAdapter extends CalculatorAdaptee implements AccumulatableAPI {
	
	private CalculatableAPI calculator;
	private double sum;

	public CalculatorClassAdapter() {
        super(); // Initialize the Adapter
        this.sum = 0;
        this.calculator = new ConcreteCalculator();
	}

	@Override
	public double accumulation(List<Double> itemPrices) {
		sum = 0;
		for (double itemPrice : itemPrices) {
			sum = this.calculator.operation(OPERATION.ADD, sum, itemPrice);
		}
		return sum;
	}

	@Override
	public double payment(double cash) {
		return this.calculator.operation(OPERATION.SUB, cash, sum);
	}
	
	public static void demo () {
		
        CalculatorClassAdapter adapter = new CalculatorClassAdapter();

        // Test the accumulation method
        List<Double> itemPrices = List.of(10.0, 20.0, 30.0);
        double total = adapter.accumulation(itemPrices);
        System.out.println("Total price: " + total);

        // Test the payment method
        double cash = 100.0;
        double change = adapter.payment(cash);
        System.out.println("Change: " + change);
	}
}
