package com.kalpa.quiz.services;

import com.kalpa.quiz.data.IRoles;
import com.kalpa.quiz.data.RolesMySQL;
import com.kalpa.quiz.classes.Roles;
import com.kalpa.quiz.classes.AdminOp;
import com.kalpa.quiz.classes.OrganizerOp;
import com.kalpa.quiz.classes.PlayerOp;
import java.util.Scanner;
import java.util.ListIterator;

public class RolesSer 
{
	private IRoles rdb;
	private Scanner scan;
	private int rID;
	private int oID;
	public static final int MAX_ATTEMPTS = 3;
	
	public RolesSer(IRoles rdb, Scanner scan) 
	{
		super();
		this.rdb = rdb;
		this.scan = scan;
	}
	
	
	public int getrID() {
		return rID;
	}


	public void setrID(int rID) {
		this.rID = rID;
	}


	public void chooseRole() 
	{
		rID = selectRole();
		if(rID == -1)
		{
			System.out.println("You reached maximum tries to enter into the system.");
			System.out.println("Quiz application is existing.");
			System.exit(0);
		}
		else
		{
			System.out.println(((RolesMySQL) rdb).getRoles().get(rID - 1).getRole()+" entered into the system. Please validate your credentials.");
		}
	}
	
	public int selectRole()
	{
		int currTry = 0;
		do 
		{
			listRoles();
			System.out.println("Please enter your selection : ");
			int rID = Integer.parseInt(scan.next());
			
			if((rID >= 1) && (rID < ((RolesMySQL) rdb).getRoles().size()+1))
				return rID;
			else
				System.out.println("Please enter a selection from the list displayed.");
		}while(currTry < MAX_ATTEMPTS);
		return -1;
	}
	public void listRoles()
	{
		ListIterator<Roles> it = ((RolesMySQL) rdb).getRoles().listIterator();
		int i = 0;
		while(it.hasNext())
		{
			Roles r = it.next();
			System.out.println(r.getId() + ". " + r.getRole());
			i++;
		}
	}
	public void chooseOp() 
	{
		String sRole = ((RolesMySQL) rdb).getRoles().get(rID - 1).getRole();
		oID = selectOp(sRole);
		if(oID == -1)
		{
			System.out.println("You reached maximum tries to enter into the system.");
			System.out.println("Quiz application is existing.");
			System.exit(0);
		}
		else
		{
			System.out.println("Operation selected.....");
		}
	}
	
	public int selectOp(String role)
	{
		int currTry = 0;
		do 
		{
			listOp(role);
			System.out.println("Please enter your selection : ");
			int oID = Integer.parseInt(scan.next());
			switch(role)
			{
			case "Admin":if((oID >= 1) && (oID < ((RolesMySQL) rdb).getAdmOp().size()+1))
							return oID;
							break;
			case "Organizer":if((oID >= 1) && (oID < ((RolesMySQL) rdb).getOrgOp().size()+1))
							return oID;
							break;
			case "Player":if((oID >= 1) && (oID < ((RolesMySQL) rdb).getPlyOp().size()+1))
							return oID;
							break;
			default:System.out.println("Please enter a selection from the list displayed.");
			}
			currTry++;
		}while(currTry < MAX_ATTEMPTS);
		return -1;
	}
		
	public void listOp(String role)
	{
		switch(role)
		{
		case "Admin": System.out.println("Admin operations : ");
					  System.out.println("1. Add Organizer.");
					  System.out.println("2. Update Organizer.");	
					  System.out.println("3. Delete Organizer.");
					  break;
		case "Organizer": System.out.println("Organizer operations : ");
						  System.out.println("1. Add Quiz.");
						  System.out.println("2. Update Quiz.");	
						  System.out.println("3. Delete Quiz.");
						  System.out.println("4. Add Player.");
						  System.out.println("5. Update Player.");	
						  System.out.println("6. Delete Player.");
						  break;
		case "Player": System.out.println("Player operations : ");
					   System.out.println("1. Play Quiz.");
					   System.out.println("2. Revisit Quiz.");	
					   break;				  
		}
	}
	
	public void executeOp(String sRole, RolesSer rs, UserSer us, QuestionsSer qs)
	{
		switch(sRole)
		{
			case "Admin":System.out.println(((RolesMySQL) rdb).getAdmOp().get(oID - 1).getRole()
					+".....");
			executeAdminOp(((RolesMySQL) rdb).getAdmOp().get(oID-1).getId(),rs, us, qs);
			break;
			case "Organizer":System.out.println(((RolesMySQL) rdb).getOrgOp().get(oID - 1).getRole()
					+".....");
			executeOrganizerOp(((RolesMySQL) rdb).getOrgOp().get(oID-1).getId(),rs, us, qs);
			break;
			case "Player":System.out.println(((RolesMySQL) rdb).getPlyOp().get(oID - 1).getRole()
					+".....");
			executePlayerOp(((RolesMySQL) rdb).getPlyOp().get(oID-1).getId(),rs, us, qs);
			break;
		}
	}
	
	public void executeAdminOp(int opID, RolesSer rs, UserSer us, QuestionsSer qs)
	{
		switch(AdminOp.values()[opID-1])
		{
		case ADD_ORG:System.out.println("Adding Organizer.....");
		break;
		case MOD_ORG:System.out.println("Modifying Organizer.....");
		break;
		case DEL_ORG:System.out.println("Deleting Organizer.....");
		break;
		default:System.out.println("Invalid Admin operation.....");
		break;
		}
	}
	
	public void executeOrganizerOp(int opID, RolesSer rs, UserSer us, QuestionsSer qs)
	{
		switch(OrganizerOp.values()[opID-1])
		{
		case ADD_QZ:System.out.println("Adding Quiz.....");
		break;
		case MOD_QZ:System.out.println("Modifying Quiz.....");
		break;
		case DEL_QZ:System.out.println("Deleting Quiz.....");
		break;
		case ADD_PLY:System.out.println("Adding Player.....");
		break;
		case MOD_PLY:System.out.println("Modifying Player.....");
		break;
		case DEL_PLY:System.out.println("Deleting Player.....");
		break;
		default:System.out.println("Invalid Organizer operation.....");
		break;
		}
	
	}
	
	public void executePlayerOp(int opID, RolesSer rs, UserSer us, QuestionsSer qs)
	{
		switch(PlayerOp.values()[opID-1])
		{
		case PLAY:System.out.println("Playing Quiz.....");
		qs.startQuiz();
		break;
		case REVISIT:System.out.println("Revisiting Quiz.....");
		break;
		default:System.out.println("Invalid Player operation.....");
		break;
		}
	
	}
}
