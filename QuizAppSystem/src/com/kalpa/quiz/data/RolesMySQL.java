package com.kalpa.quiz.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kalpa.quiz.classes.Roles;

public class RolesMySQL implements IRoles
{
	private Connection conn;
	private List<Roles> roles= new ArrayList<Roles>();
	private List<Roles> admOp= new ArrayList<Roles>();
	private List<Roles> orgOp= new ArrayList<Roles>();
	private List<Roles> plyOp= new ArrayList<Roles>();

	public RolesMySQL(Connection conn)
	{
		super();
		this.conn = conn;
	}
	
	private void loadRoleOperations(String role)
	{
		ResultSet rs=null;
		PreparedStatement sel_roles = null;
		try 
		{
			sel_roles=conn.prepareStatement("SELECT r_id,r_op FROM Roles WHERE r_name=?");
			sel_roles.setString(1, role);
			rs = sel_roles.executeQuery();
			switch(role)
			{
			case "Role":while(rs.next())
							roles.add(new Roles(rs.getInt(1),rs.getString(2)));
						break;
			case "AdminOp":while(rs.next())
							admOp.add(new Roles(rs.getInt(1),rs.getString(2)));
						break;
			case "OrganizerOp":while(rs.next())
								orgOp.add(new Roles(rs.getInt(1),rs.getString(2)));
						break;
			case "PlayerOp":while(rs.next())
								plyOp.add(new Roles(rs.getInt(1),rs.getString(2)));
						break;
			}
			if(rs!=null)
				rs.close();
			if(sel_roles!=null)
				sel_roles.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void loadRoles()
	{
		System.out.println("Loading all roles from RolesDB.....");
		
		loadRoleOperations("Role");
		loadRoleOperations("AdminOp");
		loadRoleOperations("OrganizerOp");
		loadRoleOperations("PlayerOp");
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
