package maman11;

import java.util.Scanner;

public class Expresion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello. Please enter three integers:");
		int num_1 = in.nextInt(), num_2 = in.nextInt(), num_3 = in.nextInt();
		int option_1 = num_1 + num_2 * num_3,
			option_2 = (num_1 + num_2) * num_3,
			option_3 = num_1 * num_2 + num_3,
			option_4 = num_1 * (num_2 + num_3);
		
		int max = option_1;
		
		if(option_2 > max){
			max = option_2;
		}
		
		if(option_3 > max){
			max = option_2;
		}
		
		if(option_4 > max){
			max = option_2;
		}
		
		System.out.print("The maximum value is obtained by the following expression: ");
		if (max == option_1) {
			System.out.println(num_1 + " + " + num_2 + " * " + num_3);
		} else if (max == option_2) {
			System.out.println("(" + num_1 + " + " + num_2 + ")" + " * " + num_3);
		} else if (max == option_3) {
			System.out.println(num_1 + " * " + num_2 + " + " + num_3);
		} else if (max == option_4) {
			System.out.println(num_1 + " * (" + num_2 + " + " + num_3 + ")");
		}
		
		
	}
}
