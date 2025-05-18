/** 	
 * ICSI/IECE 201 Introduction to Computer Science
 * Semester Fall 2024
 * Lab class Every Thursday 4.30pm - 5.25pm
 * Trinh Nguyen
 * TN623245
 * Tnguyen31@albany.edu
 * This program creates a dialog with the user to decide if he is a machine or a human through probability-based algorithm
*/

import java.util.Scanner;	//Import the Scanner Class for user input
import java.util.Random;	//Import the Random Class to generate random numbers
public class P1_TN623245 {
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);	// Create a Scanner object to read the user's answer
		Random random = new Random();			// Create a Random object to generate arbitrary numbers
		boolean redo = true; 					// Initialize the flag to control the loop
		double human_score = 0;					// Initialize score for human
		double machine_score = 0;				// Initialize score for machine	
		boolean	continue_program = true;		// Initialize the flag to continue or terminate the program
		
		
		while (redo) {
				System.out.println("Hello! Welcome to our Detective Mission.");
				System.out.println("We will ask several questions to evaluate whether you are a Machine or a Human.");
				System.out.println("Please confirm if you are a human! Type Yes or No");
					
				String confirm;										//Initialize variable to hold user confirmation
				
				while (true){										//Validate the user confirmation
					confirm = scnr.nextLine().toLowerCase();		//Read and convert user confirmation to lower case
					if(confirm.equals("yes") || confirm.equals("no")){
						if (confirm.equals("no")) {
							continue_program = false;				// The flag variable is set to false if the user input is "no"
						} 
						break;}										//Exit the while loop if user input is valid, moving to the next part of the code after the loop	
									
						System.out.println("Your input is invalid!Type Yes or No.");	
				}
				if(continue_program) {
					System.out.println("Thank you for confirming. Now you need to answer some more questions!");
					
					//Question 1
					System.out.println("Do you like hiking or processing?");
					String reply1;									//Initialize variable to hold user response to question 1
					do {
						 reply1 = scnr.nextLine().toLowerCase();	//Read and convert user reply to question 1 to lower case
						if (reply1.equals("hiking")) {
								human_score += 10; 					//Add 10 points to human score
						} 
						else if (reply1.equals("processing")) {
								machine_score += 5; 				//Add 5 points to machine score
						} 
						else {
							System.out.println("Your input is invalid! Type hiking or processing.");
						}
					} while (!reply1.equals("hiking") && !reply1.equals("processing"));
					
					
					//Question 2
					System.out.println("What is your favorite food? chicken or number");
					String reply2;									//Initialize variable to hold user response to question 2
					do {	
						reply2 = scnr.nextLine().toLowerCase();		//Read and convert user reply to question 2 to lower case
						
						if (reply2.equals("chicken")) {
								human_score += 6; 					//Add 6 points to human score
						} 
						else if (reply2.equals("number")) {
								machine_score += 8; 				//Add 8 points to machine score
						} 
						else {
						System.out.println("Your input is invalid! Type chicken or number.");
						}
					} while (!reply2.equals("chicken") && !reply2.equals("number"));
				
					
					//Question 3
					System.out.println("How often do you play tennis? sometimes or never?");
					String reply3;									//Initialize variable to hold user response to question 3
					do {
						reply3 = scnr.nextLine().toLowerCase();		//Read and convert user reply to question 3 to lower case
						if (reply3.equals("sometimes")) {
								human_score += 12; 					//Add 12 points to human score
						} 
						else if (reply3.equals("never")) {
								machine_score += 11; 				//Add 11 points to machine score
						} 
						else {
							System.out.println("Your input is invalid! Type sometimes or never.");
						}
					} while (!reply3.equals("sometimes") && !reply3.equals("never"));
					
					
					//Question 4
					System.out.println("Do you prefer coding or karaoke?");
					String reply4;									//Initialize variable to hold user response to question 4
					do {
						reply4 = scnr.nextLine().toLowerCase();		//Read and convert user reply to question 4 to lower case
						if (reply4.equals("karaoke")) {
								human_score += 21; 					//Add 21 points to human score
						} 
						else if (reply4.equals("coding")) {
								machine_score += 23; 				//Add 23 points to machine score
						} 
						else {
							System.out.println("Your input is invalid! Type karaoke or coding.");
						}	
					} while (!reply4.equals("karaoke") && !reply4.equals("coding"));
							
					
					//Question 5
					System.out.println("What do you do when being sad? crying or rebooting?");
					String reply5;									//Initialize variable to hold user response to question 5
					do {
						 reply5 = scnr.nextLine().toLowerCase();	//Read and convert user reply to question 5 to lower case
						 if (reply5.equals("crying")) {
								human_score += 12; 					//Add 12 points to human score
						}
						else if (reply5.equals("rebooting")) {
								machine_score += 12; 				//Add 12 points to machine score
						}
						else {
							System.out.println("Your input is invalid! Type crying or rebooting.");
						}	
					} while (!reply5.equals("crying") && !reply5.equals("rebooting"));
							
					
					//Ask the user his level of confidence in the answer he provided
					
					int confidence;									//Initialize variable to hold user's confidence level
					do {
							System.out.println("How confident you are with the answer, on the scale from 0 to 100?");
							confidence =scnr.nextInt();
							scnr.nextLine();						 //Consume the newline character left
						
							if(confidence <0 || confidence >100) {
							System.out.println("Your input is invalid! Please enter number from 0 to 100!");
						}
					} while (confidence <0 || confidence >100);
					
					//Calculate uncertainty factor
					int uncertainty = 100 - confidence; 			//Calculate uncertainty
					int uncertainty_bound = uncertainty / 2; 		// bound the random factor is maximum half of uncertainty
			
					//Add randomness to the calculated scores
					int randomness = random.nextInt(uncertainty + 1) - uncertainty_bound; 
						
					//Update the score with randomness factor
					human_score += randomness;
					machine_score += randomness;
						
					//Check if score is above 100 or below 0
					if (human_score <0)	{
						human_score = 0;							//Set variable to 0 if score below 0
					} 
					else if (human_score >100)	{
						human_score = 100;							//Set variable to 100 if score above 100
					}					
					if (machine_score <0) {
						machine_score = 0;							//Set variable to 0 if score below 0
					} else if (machine_score >100)	{
						machine_score = 100;						//Set variable to 100 if score above 100
					}
					
					//Print out the final score
					System.out.println("Give us a few seconds to calculate...");
					System.out.printf("Well, you are %.0f%% human and %.0f%% machine", human_score, machine_score);
					System.out.println();
					
					//Compare human score with machine score and Show the result accordingly if the user is human or machine
					if (human_score > machine_score) {				
						System.out.println("You are certified a human!");				
					} 
					else if (human_score < machine_score){
						System.out.println("You are actually a machine!");
					} 
					else{
						System.out.println("Hmm, we're uncertain if you are a human or a machine.");
					}
					// Ask if user want to try again.
					System.out.println("Do you want to try again? Type Yes or No");
					String retry = scnr.nextLine().toLowerCase();	//Read the response for retry
					
					while (!retry.equals("yes") && !retry.equals("no")) {
						System.out.println("Your input is invalid!Type Yes or No.");
						retry = scnr.nextLine().toLowerCase();		//Read the response for retry
					}
					
					redo = retry.equals("yes");						//Set the flag variable to continue if the answer is yes and return to the beginning to run the test again
				}
				else {		
					System.out.println("Program terminated. Thank you!");
					redo = false; 									//Set variable to false to stop the outer while loop 
				}
		}
	}	
}

	
	
	








