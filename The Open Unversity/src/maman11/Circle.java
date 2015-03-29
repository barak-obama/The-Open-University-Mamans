package maman11;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("This program calculates the areas "
				+ "and the perimeters of the excircle and the incircle "
				+ "of a given rectangle ");
		System.out.print("Please enter the two coordinates of the "
				+ "left-upper point of the rectangle\n");
		int leftUpX = scan.nextInt();
		int leftUpY = scan.nextInt();

		System.out.print("Please enter the two coordinates of the "
				+ "right-bottom point of the rectangle\n");

		int rightBottomX = scan.nextInt();
		int rightBottomY = scan.nextInt();

		int height = leftUpY - rightBottomY;
		double innerRadius = height / 2.0;
		double innerArea = Math.PI * Math.pow(innerRadius, 2), innerPerimeter = 2
				* Math.PI * innerRadius;

		System.out.println("Incircle: radius = " + innerRadius + ", area = "
				+ innerArea + ", perimeter = " + innerPerimeter);

		int width = rightBottomX - leftUpX;
		double externalRadius = Math.sqrt(Math.pow(width, 2)
				+ Math.pow(height, 2)) / 2;
		double externalArea = Math.PI * Math.pow(externalRadius, 2), externalPerimeter = 2
				* Math.PI * externalRadius;

		System.out.println("Excircle: radius = " + externalRadius
				+ ", area = " + externalArea + ", perimeter = "
				+ externalPerimeter);

	} // end of method main
} // end of class Circle 