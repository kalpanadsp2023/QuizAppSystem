package com.kalpa.rewards.services;

import com.kalpa.rewards.data.Customers;
import com.kalpa.rewards.classes.CustomerDetails;

import java.util.Scanner;
import java.util.Timer;

public class RewardsRedemptionMain 
{
	public static void main(String[] args) 
	{
		// Displays welcome menu to the system
		DisplayMenus dm = new DisplayMenus();
		dm.welcomeMenu();
		
		// Loads the system with user data for the selected no: of users
        int nUsers = 5;
		Customers c = new Customers(nUsers);
		// Starts the demon thread to process the user transactions
		// by Crediting the random user account with random transaction points
        Timer tm = new Timer();
		GenerateTransactions gt = new GenerateTransactions(c, nUsers);
		tm.scheduleAtFixedRate(gt, 0, 1000);
				
		int loginAttempts = 0;
		// Accept the user details
		Scanner sc = new Scanner(System.in);
		System.out.println("Login to the system by entering the USER credentials.");
        System.out.println("Enter your username : ");
        String usrName = sc.nextLine();
        String usrPwd = "";
        
        // Allow the user to login to the system
        // Check for the existence of the user
        CustomerDetails loggedUser = c.getCustomerDetails(usrName);
        if(loggedUser != null)
        {
			while(loginAttempts < 3)
			{
				System.out.print("Enter your password : ");
		        usrPwd = sc.nextLine();
				// Validate the user credentials
				if(loggedUser.getCust().getUsrPwd().equals(usrPwd))
				{
					// 2. Welcome message to the redemption menu
					// 3. Allow the user to select the category and the redemption gift
					// 4. Check if the gift can be availed for the existing points
						// If availed gift it to the user and deduct the points
						// Else show an error message and allow the user to select other
					System.out.println(usrName.toUpperCase() + " Logged in successful to rewards redemption system.");
					Redemption rdm = new Redemption(loggedUser, c);
					System.out.println("Available points for redemption : "+loggedUser.getCust().getPts());
					rdm.executeRedemption();
					System.out.println(loggedUser);
					System.exit(1);
				}
				else
				{
					loginAttempts++;
					System.out.println("The password you entered is incorrect. You are left with "+ (3-loginAttempts) + " more tries before the system exists.");
				}
			}
			System.out.println("Sorry..... You’ve reached the maximum logon attempts. Please login to the system again.");
		  }
          else
          {
			System.out.println("Invalid username. Please try to register with the system using signin.");
			System.exit(0);
          }
		if(sc != null)
			sc.close();
	}
}
