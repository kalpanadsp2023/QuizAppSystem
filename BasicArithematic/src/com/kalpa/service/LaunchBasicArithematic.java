package com.kalpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kalpa.db.*;

public class LaunchBasicArithematic 
{
	public static void main(String[] args) throws SQLException 
	{
		Connection conn = null;
		PreparedStatement chk_op_stmt = null, ins_op_stmt=null, sel_op_stmt=null, upd_op_stmt = null, ins_oprd_stmt=null, sel_oprd_stmt=null;
		ResultSet rs1 = null, rs2 = null,  rs3 = null;
		Datatypes type;
		ICalculator oprnds = null;
		int op_id = -1, freq = 0, rAff = 0;
		
		try (Scanner scan = new Scanner(System.in)) 
		{
			conn = JDBCUtil.getDBConnection();
			// Accept input
			// Select the type of data.
			System.out.println("Choose the type of data : \n\t1.Short \n\t2. Integer\n\t3. Long\n\t4. Float\n\t5. Double");
			int choice = scan.nextInt();
			if(choice >= 1 && choice <= 5)
			{
				switch(Datatypes.values()[choice])
				{
					case DEFAULT:System.out.println("No case matched.");
					break;
					case SHORT:System.out.println("Short case selected.");
					break;
					case INTEGER:System.out.println("Integer case selected.");
								System.out.println("Enter two numbers : ");
								Integer num1 = scan.nextInt();
								Integer num2 = scan.nextInt();
								oprnds = new Operands(num1, num2);
								chk_op_stmt = conn.prepareStatement("SELECT op_id,freq FROM OperandsTracker WHERE num1 = ? AND num2 = ?");
								chk_op_stmt.setInt(1, num1);
								chk_op_stmt.setInt(2, num2);
								rs1 = chk_op_stmt.executeQuery();
								if(rs1.next())
								{
									op_id = rs1.getInt(1);
									freq=rs1.getInt(2);
									rs1.close();
									chk_op_stmt.close();
									sel_op_stmt = conn.prepareStatement("SELECT sum,diff,prod,divi FROM OperationResults WHERE op_id=? ");
									sel_op_stmt.setInt(1, op_id);
									rs2 = sel_op_stmt.executeQuery();
									if(rs2!=null)
									{
										rs2.next();
										System.out.println("Values already exist fetched from DB : ");
										System.out.println("\tSum : "+rs2.getInt(1)+"\n\tDifference : "+rs2.getInt(2)+"\n\tProduct : "+rs2.getInt(3)+"\n\tDivision : "+rs2.getFloat(4));
										rs2.close();
										sel_op_stmt.close();
										upd_op_stmt = conn.prepareStatement("UPDATE OperandsTracker SET freq = ? WHERE op_id=?");
										upd_op_stmt.setInt(1, freq+1);
										upd_op_stmt.setInt(2, op_id);
										rAff = upd_op_stmt.executeUpdate();
										upd_op_stmt.close();
										System.out.println("\tFrequency :"+(freq+1));
									}
								}
								else
								{
									ins_oprd_stmt = conn.prepareStatement("INSERT INTO OperandsTracker(num1,num2) VALUES(?,?)");
									ins_oprd_stmt.setInt(1, num1);
									ins_oprd_stmt.setInt(2, num2);
									rAff = ins_oprd_stmt.executeUpdate();
									
									if(rAff == 1)
									{
										ins_oprd_stmt.close();
										sel_oprd_stmt = conn.prepareStatement("SELECT op_id FROM OperandsTracker WHERE num1 = ? AND num2 = ?");
										sel_oprd_stmt.setInt(1, num1);
										sel_oprd_stmt.setInt(2, num2);
										rs3=sel_oprd_stmt.executeQuery();
										if(rs3.next())
										{
											op_id=rs3.getInt(1);
											ins_op_stmt = conn.prepareStatement("INSERT INTO OperationResults(op_id,sum,diff,prod,divi) VALUES(?,?,?,?,?)");
											ins_op_stmt.setInt(1, op_id);
											ins_op_stmt.setInt(2, oprnds.add());
											ins_op_stmt.setInt(3, oprnds.sub());
											ins_op_stmt.setInt(4, oprnds.mul());
											ins_op_stmt.setFloat(5, oprnds.div());
											rAff = ins_op_stmt.executeUpdate();
											if(rAff == 1)
											{
												System.out.println("Inserted the numbers and their arithematic values into DB : ");
												System.out.println("\tSum : "+oprnds.add()+"\n\tDifference : "+oprnds.sub()+"\n\tProduct : "+oprnds.mul()+"\n\tDivision : "+oprnds.div());
											}
											ins_op_stmt.close();
											rs3.close();
											sel_oprd_stmt.close();
										}
										
									}
								}
								break;
					case LONG:System.out.println("Long case selected.");
					break;
					case FLOAT:System.out.println("Float case selected.");
					break;
					case DOUBLE:System.out.println("Double case selected.");
					break;
					default: System.out.println("No case matched");
					break;
				}
			}
			else
			{
				System.out.println("Entered wrong choice... rerun the program.");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResources(rs1, chk_op_stmt, conn);
		}
	}

}
