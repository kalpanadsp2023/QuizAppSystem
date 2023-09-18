package com.kalpa.quiz.data;

import java.util.List;
import java.util.ArrayList;

import com.kalpa.quiz.classes.Roles;

public class RolesDB implements IRoles
{
	private List<Roles> roles= new ArrayList<Roles>();
	private List<Roles> admOp= new ArrayList<Roles>();
	private List<Roles> orgOp= new ArrayList<Roles>();
	private List<Roles> plyOp= new ArrayList<Roles>();

	public RolesDB()
	{
		super();
	}
	@Override
	public void loadRoles()
	{
		System.out.println("Loading all roles from RolesDB.....");
		roles.add(new Roles(1,"Admin"));
		roles.add(new Roles(2,"Organizer"));
		roles.add(new Roles(3,"Player"));
		
		admOp.add(new Roles(1, "Add Organizer"));
		admOp.add(new Roles(2, "Update Organizer"));
		admOp.add(new Roles(3, "Delete Organizer"));
		
		orgOp.add(new Roles(1, "Add Quiz"));
		orgOp.add(new Roles(2, "Update Quiz"));
		orgOp.add(new Roles(3, "Delete Quiz"));
		orgOp.add(new Roles(4, "Add Player"));
		orgOp.add(new Roles(5, "Update Player"));
		orgOp.add(new Roles(6, "Delete Player"));
		
		plyOp.add(new Roles(1, "Play Quiz"));
		plyOp.add(new Roles(2, "Revisit Quiz"));
	}
	
	public List<Roles> getRoles() 
	{
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<Roles> getAdmOp() {
		return admOp;
	}

	public void setAdmOp(List<Roles> admOp) {
		this.admOp = admOp;
	}

	public List<Roles> getOrgOp() {
		return orgOp;
	}

	public void setOrgOp(List<Roles> orgOp) {
		this.orgOp = orgOp;
	}

	public List<Roles> getPlyOp() {
		return plyOp;
	}

	public void setPlyOp(List<Roles> plyOp) {
		this.plyOp = plyOp;
	}

}
