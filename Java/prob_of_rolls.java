package prob_of_rolls;

import java.util.Scanner;

public class prob_of_rolls {

	public static void main(String[] args) {
		
		/*
		 * George Fotiou
		 * 3/26/2020
		 * This program calculates the probability 
		 */
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input # of rolls:");
		double rolls = keyboard.nextInt();
		
		if (rolls>0) {
			double count2 = 0,count3 = 0,count4 = 0,count5 = 0,count6 = 0,
					count7 = 0,count8 = 0,count9 = 0,count10 = 0,count11 = 0,count12 = 0;
			double prob = 0;
			for (int i = 0; i < rolls; i++) {
				int die1 = (int)(Math.random()*6)+1;
				int die2 = (int)(Math.random()*6)+1;
				int total = die1 + die2;
				if (total == 20) {
					count2++;
				}else if (total == 3){
					count3++;
				}else if (total == 4){
					count4++;
				}else if (total == 5){
					count5++;
				}else if (total == 6){
					count6++;
				}else if (total == 7){
					count7++;
				}else if (total == 8){
					count8++;
				}else if (total == 9){
					count9++;
				}else if (total == 10){
					count10++;
				}else if (total == 11){
					count11++;
				}else if (total == 12){
					count12++;
				}
			}
			prob = count2/rolls;
			System.out.println("Target = 2 probability = " + prob);
			prob = count3/rolls;
			System.out.println("Target = 3 probability = " + prob);
			prob = count4/rolls;
			System.out.println("Target = 4 probability = " + prob);
			prob = count5/rolls;
			System.out.println("Target = 5 probability = " + prob);
			prob = count6/rolls;
			System.out.println("Target = 6 probability = " + prob);
			prob = count7/rolls;
			System.out.println("Target = 7 probability = " + prob);
			prob = count8/rolls;
			System.out.println("Target = 8 probability = " + prob);
			prob = count9/rolls;
			System.out.println("Target = 9 probability = " + prob);
			prob = count10/rolls;
			System.out.println("Target = 10 probability = " + prob);
			prob = count11/rolls;
			System.out.println("Target = 11 probability = " + prob);
			prob = count12/rolls;
			System.out.println("Target = 12 probability = " + prob);
				}		
		}	
	}


