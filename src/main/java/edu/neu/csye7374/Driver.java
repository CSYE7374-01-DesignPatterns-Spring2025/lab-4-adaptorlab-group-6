package edu.neu.csye7374;

/**
 * 
 * @author Yesha
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

         //Add your code in between these two print statements
		System.out.println("============Class Adapter Start===================\n\n");
		CalculatorClassAdapter.demo();
		System.out.println("============Object Adapter Start===================\n\n");
		CalculatorObjectAdapter.demo();
		System.out.println("\n\n============Main Execution End===================");
	}

}
