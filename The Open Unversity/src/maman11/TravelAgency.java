package maman11;

import java.util.Scanner;

public class TravelAgency {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello. Please enter your destination in tow integers:");
		int x = in.nextInt(), y = in.nextInt();
		
		int PRICE_PER_100_KM = 50;
		
		double distance = Math.sqrt(x * x + y*y);
		double price = Math.ceil(distance / 100.0) * PRICE_PER_100_KM;
		
		System.out.println("The price of the flight is:");
		System.out.println(price);
		
		System.out.println("Please enter your credit card number:");
		int credit = in.nextInt();
		boolean b = 100000 <= credit && credit <= 1000000 && (credit /10)%7 == credit%10;
		
		if(b){
			System.out.println("Your credit card is valid. Bon Voyage!");
		} else {
			System.out.println("Your credit card is not valid. You cnnot buy the ticket.");
		}
	}

}
