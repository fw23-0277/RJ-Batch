package com.masai.school;

import java.util.Scanner;

public class Main {
	
	public Hotel provideFood(int amount) {
		
		if(amount > 1000) {
			return new TajHotel();
		}else if(amount > 200 && amount < 1000) {
			return new RoadSideHotel();
		}
		return null;

	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Amount In RS. : ");
		int amount = sc.nextInt();
		
		Main main = new Main();
		
		Hotel  hotel =  main.provideFood(amount);
		
		if(hotel == null) System.out.println("Please Enter a valid amount.");
		
		
		if(hotel instanceof TajHotel) {
			hotel.chickenBiryani();
			hotel.masalaDosa();
		}
		if(hotel instanceof RoadSideHotel){
			hotel.chickenBiryani();
			hotel.masalaDosa();
		}
		
		
		
		
		
	}

}
