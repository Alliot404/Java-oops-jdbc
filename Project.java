package project;

import java.sql.*;
import java.util.Scanner;

class Insert{
	
	void insert(String posi) {
		String name;
		int id;
		int age;
		int salary;
		
			
			try {
				Scanner sc=new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","");
				PreparedStatement pstmt=con.prepareStatement("insert into emptable values(?,?,?,?)");

				System.out.println("\n");
				System.out.print("Enter Name  : ");
				name=sc.next();
				System.out.print("Enter ID : ");
				id=sc.nextInt();
				System.out.print("Enter Age ");
				age=sc.nextInt();	
	
				    pstmt.setString(1,name);
					pstmt.setInt(2,id);
					pstmt.setInt(3,age);
					pstmt.setString(4,posi);
					
					pstmt.execute();	
			
				System.out.println("-------------Record Created............");
				pstmt.close();	
				con.close();
				
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
	}
}

class Read
{		
	void read(){
		
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","");
			int c;
			do {
				
				System.out.println("Which info you want to read?");
				System.out.println("----------------------------------------------------------");
				System.out.println("1)Developer \n2)Tester \n3)Manager \n4)Exit");
				
				c = sc.nextInt();
				
				if(c==1) {
					PreparedStatement stmt =con.prepareStatement("select * from emptable where posi='developer' ");
					
					ResultSet rs=stmt.executeQuery();
					
					System.out.println("Name\t|\tId\t|\tAge\t|\tPosition");
					System.out.println("-----------------------------------------------------------------");
					while(rs.next())
					{
						
					System.out.println(rs.getString(1)+ "\t \t"+rs.getInt(2)+"\t \t"+rs.getInt(3)+ "\t \t"+rs.getString(4));
					
					
					}
				
					
					System.out.println("------Records Fecthed Successfully-------\n");
					stmt.close();
					
				}
				
				else if(c==2) {
					PreparedStatement stmt =con.prepareStatement("select * from emptable where posi='Tester' ");
					
					ResultSet rs=stmt.executeQuery();
					
					System.out.println("Name\t|\tId\t|\tAge\t|\tPosition");
					System.out.println("-----------------------------------------------------------------");
					while(rs.next())
					{
						
						System.out.println(rs.getString(1)+ "\t \t"+rs.getInt(2)+"\t \t"+rs.getInt(3)+ "\t \t"+rs.getString(4));
					}
				
					
					System.out.println("------Records Fecthed Successfully-------\n");
					stmt.close();
					
				}
				
				else if(c==3) {
					PreparedStatement stmt =con.prepareStatement("select * from emptable where posi='Manager' ");
					
					ResultSet rs=stmt.executeQuery();
					
					System.out.println("Name\t|\tId\t|\tAge\t|\tPosition");
					System.out.println("-----------------------------------------------------------------");
					while(rs.next())
					{
						
						System.out.println(rs.getString(1)+ "\t \t"+rs.getInt(2)+"\t \t"+rs.getInt(3)+ "\t \t"+rs.getString(4));
					}
				
					
					System.out.println("------Records Fecthed Successfully-------\n");
					stmt.close();
					
				}
				else {
					System.out.println(" exited ");
					con.close();
				}
				
			}while(c!=4);
	
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

class Update 
{
		
	void update(){
		Scanner sc=new Scanner(System.in);
		int ch;
		do {

			System.out.println("\n---What you want to update?---");
			System.out.println("1)Age \n2)Position \n3)Exit");
			ch = sc.nextInt();
			
			if(ch==1) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","");
	
					Statement stmt=con.createStatement();
					
					ResultSet rs=stmt.executeQuery("select * from emptable");
					System.out.println("\n---Available All Info----\n");
					System.out.println("Name\t\tId\t\tAge\t\tPosition");
				
					System.out.println("-----------------------------------------------------------------");
					while(rs.next())
					{
						System.out.println(rs.getString(1)+ "\t\t" +rs.getInt(2)+ "\t\t" +rs.getInt(3)+ "\t\t" +rs.getString(4));
						
					}
				
					stmt.close();
					
					PreparedStatement pstmt=con.prepareStatement("update emptable set age=? where id=? ");
					
					System.out.println("\n---Select an ID from above Info----\n");
					
					System.out.print("Enter The ID : ");
					int id=sc.nextInt();
					
					System.out.print("Enter The New Age  : ");
					int age=sc.nextInt();
					
					
					pstmt.setInt(1,age); 
					pstmt.setInt(2,id);
			
					System.out.println("-------Age updated Successfully----------\n");
					pstmt.execute();
					con.close();
					
					
				} 
				catch (Exception e) {
					System.out.println(e);
				}
			}
			else if(ch==2) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","");
					
					
					Statement stmt=con.createStatement();
					
					ResultSet rs=stmt.executeQuery("select * from emptable");
					System.out.println("\n---Available All Info----\n");
					System.out.println("Name\t\tId\t\tAge\t\tPosition");
					System.out.println("-----------------------------------------------------------------");
					while(rs.next())
					{
						System.out.println(rs.getString(1)+ "\t\t" +rs.getInt(2)+ "\t\t" +rs.getInt(3)+ "\t\t" +rs.getString(4));
					}
				
					stmt.close();
					
					PreparedStatement pstmt=con.prepareStatement("update emptable set posi=? where id=? ");
					System.out.println("\n---Select an ID from above Info----\n");
					
					System.out.print("Enter The ID : ");
					int id=sc.nextInt();
					
					System.out.print("Enter The new Position  : ");
					String posi=sc.next();

					
					pstmt.setString(1,posi);
					pstmt.setInt(2,id);
			
					System.out.println("------Position updated Successfully--------\n");
					pstmt.execute();
					con.close();
					
					
				} 
				catch (Exception e) {
					System.out.println(e);
				}
			}
			
			else {
				System.out.println("---Not updated anything---\n");
		
			}
			
		}while(ch!=3);
		
		
		
	}
}

class Delete 
{	
	void delete(){
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","");
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from emptable");
			System.out.println("\n---Available All Info----\n");
			System.out.println("Name\t\tId\t\tAge\t\tPosition");
			System.out.println("-----------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ "\t\t" +rs.getInt(2)+ "\t\t" +rs.getInt(3)+ "\t\t" +rs.getString(4));
			}
		
			stmt.close();
			
			System.out.println("\n---Select an ID from above Info to delete----\n");
			
			PreparedStatement pstmt=con.prepareStatement("delete from emptable where id=? ");
			
			System.out.print("\n Enter The ID : ");
			int id=sc.nextInt();

	
			pstmt.setInt(1,id);
			System.out.print(" Realy want To Delete ? : Y/N   : ");
			String ch=sc.next();
			if(ch.equals("y") || ch.equals("Y"))
			{
				pstmt.execute();
				System.out.println("----Record Deleted-----\n ");
			}
			else
			{
				System.out.println("----Record NOt Deleted----\n ");
			}
				
			con.close();
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int ch;
		
		do {
			System.out.println();
			System.out.println("Please Select what you want to perform \n");
			
			System.out.println("1)Create Records \n2)Read Records \n3)Update Records \n4)Delete records \n5)Exit\n");
			
			
			 ch=sc.nextInt();
			 
			 if(ch==1) { 
				 int cho;
				 do {
					 System.out.println("\n Which info do you want to Create?\n");
					 System.out.println("1)Developer \n2)Tester \n3)Manager \n4)Exit");
					 cho = sc.nextInt();
					 
					 if(cho==1) {
						 Insert i = new Insert();
						 i.insert("Developer");
					 }
					 else if(cho==2) {
						 Insert i = new Insert();
						 i.insert("Tester");
					 }
					 else if(cho==3) {
						 Insert i = new Insert();
						 i.insert("Manager");
					 }
					 else {
						 System.out.println("---exited---");
					 }
					 
				 }while(cho!=4);
				 
				 
				 
			 }
			 else if(ch==2) {
				 Read r = new Read();
				 r.read();
			 }
			 else if(ch==3) {
				 Update u = new Update();
				 u.update();
			 }
			 else if(ch==4) {
				 Delete d = new Delete();
				 d.delete();
			 }
			 
			 else {
				 System.out.println("---Exited from application---");
				 System.out.println("---Thank you for using---");
					System.exit(0);
			 }
			 
			 
		} while(ch!=5);
		
		

	}

}
