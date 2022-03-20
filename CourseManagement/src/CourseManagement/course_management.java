package CourseManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


class Student extends School
{
	void addStudentRecord() throws SQLException, ClassNotFoundException 
	{
		 String Name;
		 int Paidfee;
		 int Sid;
		 String Saddress;
		 String Password;
		 String UserId;
		 String Std;
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter Student Id");
		 Sid=sc.nextInt();
		System.out.println("Enter name of Student");
		Name=sc.next();
		System.out.println("Enter Class");
		Std=sc.next();
		System.out.println("Enter Student UserName:");
		UserId=sc.next();
		System.out.println("Enter Student Paasword:");
		Password=sc.next();
		System.out.println("Enter Student Adress");
		Saddress=sc.next();
		System.out.println("Enter paidfee:");
		Paidfee=sc.nextInt();
		 String str="select * from Student where sid="+Sid;
		 ResultSet rs=stat.executeQuery(str);
		 if(!rs.next())
		 {
		 String ins="insert into Student values('"+Sid+"','"+Name+"','"+Std+"','"+UserId+"','"+Password+"','"+Saddress+"','"+Paidfee+"')";
		 int i=stat.executeUpdate(ins);
		 if(i>0) 
		 {
			 System.out.println("student Record is Added ");
		 }
		 
		 }
		 else
		 {
			 System.out.println(Sid+ " This Id is Already exits:");
		 }
	}
	
	
	 void enrolled() throws SQLException, ClassNotFoundException
	 {
		 Connection con= connect();
			stat=con.createStatement();
		 System.out.println("If you Want to join Course...Enter 1 or Activity...Enter 2??");
		 int accept=sc.nextInt();
		 if(accept==1)
		 {
			 System.out.println("Enter id:");
			 Sid=sc.nextInt();
			 System.out.println("Enter name of Course");
			 CName=sc.next();
			 System.out.println("Enter Fee");
			 CFee=sc.nextInt();
			 String str="select * from Enrolled";
			 ResultSet rs=stat.executeQuery(str);
			 if(!rs.next())
			 {
			 String ins="insert into Enrolled values('"+Sid+"','"+CName+"','"+CFee+"')";
			 int i=stat.executeUpdate(ins);
			 if(i>0)
			 {
				 System.out.println("Done");
			 }
			 else
			 {
				 System.out.println("no");
			 }
		 }			 }

		 if(accept==2)
		 {
			 System.out.println("Enter id:");
			 Sid=sc.nextInt();
			 System.out.println("Enter name of Activity");
			 AName=sc.next();
			 System.out.println("Enter Fee");
			 AFee=sc.nextInt();
			 String str="select * from Enrolled";
			 ResultSet rs=stat.executeQuery(str);
			 if(rs.next())
			 {
			 String ins="insert into Enrolled values('"+Sid+"','"+AName+"','"+AFee+"')";
			 int i=stat.executeUpdate(ins);
			 if(i>0)
			 {
				 System.out.println("Done");
			 }
			 else
			 {
				 System.out.println("no");
			 }
		 }		
			 }
		 }

		
	 
	 void viewStudentProfile() throws ClassNotFoundException, SQLException
	 {
		 Connection con= connect();
			stat=con.createStatement();
			System.out.println("Enter Student Id");
			Sid=sc.nextInt();
			ResultSet rs=stat.executeQuery("select * from Student where Sid="+Sid);
			System.out.println("Here is Your Profile inforamtion   "+Name);
			System.out.println("Id \t Name\t Class\t UserName\t Adress\t PaidFee");
			while(rs.next())
			{
				System.out.println(rs.getInt("Sid")+"\t"+rs.getString("Name")+"\t"+rs.getString("Class")+"\t"+rs.getString("UserId")+"\t"+"\t"+rs.getString("Saddress")+"\t"+rs.getInt("Paidfee"));
				
			}
	 }
	 
	
}

class Teacher extends School
{
	void addTeacherRecord() throws SQLException, ClassNotFoundException 
	{
		
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter Teacher Id");
		Tid=sc.nextInt();
		System.out.println("Enter name of Teacher");
		 TName=sc.next();
		System.out.println("Enter MailID of Teacher");
		 MailId=sc.next();
		System.out.println("Enter Teacher Paasword:");
		TPassword=sc.next();
		System.out.println("Enter Teacher Adress");
		TAddress=sc.next();
		System.out.println("Enter Subject");
		 Subject=sc.next();
		System.out.println("Enter Salary:");
		Salary=sc.nextDouble();
		 String str="select * from Teacher where Tid="+Tid;
		 ResultSet rs=stat.executeQuery(str);
		 if(!rs.next())
		 {
		
		String ins="insert into Teacher values('"+Tid+"','"+Name+"','"+MailId+"','"+TPassword+"','"+TAddress+"','"+Subject+"','"+Salary+"')";
		 int i=stat.executeUpdate(ins);
		 if(i>0) 
		 {
			 System.out.println("Teacher Record is Added ");
		 }
		 
		 }
		 else
		 {
			 System.out.println(Tid+ " This Id is Already exits:");
		 }
	}
	
	 void viewTeacherProfile() throws ClassNotFoundException, SQLException
	 {
					Connection con= connect();
					stat=con.createStatement();
					System.out.println("Enter Your Id");
					Tid=sc.nextInt();
					ResultSet rs=stat.executeQuery("select * from Teacher where Tid="+Tid);
					System.out.println("Id \t Name\t MailId\t\t Adress \t Subject \tSalary");
					while(rs.next())
					{
						System.out.println(rs.getInt("Tid")+"\t"+rs.getString("Name")+"\t"+rs.getString("MailId")+"\t"+rs.getString("TAddress")+"\t"+rs.getString("Subject")+"\t\t"+rs.getDouble("Salary"));
						
					}
	 }
}
class School
{
	 private static String conn;
	 private  static Connection con;
	 protected static Statement stat=null;
	 Scanner sc=new Scanner(System.in); 
	 protected static String Name;
	 protected static int Paidfee;
	 protected static int Sid;
	 protected static String Saddress;
	 protected static String Password;
	 protected static String UserId;
	 protected static String Std;
	 protected static int Tid;
	 protected static String TName;
	 protected static String MailId;
	 protected static String TPassword;
	 protected static String Subject;
	 protected static String TAddress;
	 protected static double Salary;
	 private static int Stid;
	 private static String ItemName;
	 private static int quantity;
	 private static double price;
	 protected static String CName;
	 private static int Cid;
	 protected static int CFee;
	 private static int Duration;
	 private static int Aid;
	 protected static String AName;
	 protected static int AFee;
	 private static double School_Fund=200000;
 
	 
	 static
	 {
	 conn="com.mysql.cj.jdbc.Driver";
	  @SuppressWarnings("unused")
	Connection con=null;
	}
	 
	 
	static Connection connect() throws ClassNotFoundException, SQLException 
	{
	
		Class.forName(conn);
		con=DriverManager.getConnection("JDBC:MYSQL://localhost:3306/SchoolManagement","root","root123");
		//stat=con.createStatement();
		return con;
		
	}
	
	
	
	void displayStudentRecord() throws ClassNotFoundException, SQLException
	{
			Connection con= connect();
			stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from Student");
			System.out.println("Id \t Name\t Class\t UserName\t Adress\t PaidFee");
			while(rs.next())
			{
				System.out.println(rs.getInt("Sid")+"\t"+rs.getString("Name")+"\t"+rs.getString("Class")+"\t"+rs.getString("UserId")+"\t"+"\t"+rs.getString("Saddress")+"\t"+rs.getInt("Paidfee"));
				
			}
		}
	

	
	static void displayTeacherRecord() throws ClassNotFoundException, SQLException
	{
			Connection con= connect();
			stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from Teacher");
			System.out.println("Id \t Name\t MailId\t\t Adress \t Subject \tSalary");
			while(rs.next())
			{
				System.out.println(rs.getInt("Tid")+"\t"+rs.getString("Name")+"\t"+rs.getString("MailId")+"\t"+rs.getString("TAddress")+"\t"+rs.getString("Subject")+"\t\t"+rs.getDouble("Salary"));
				
			}
		}
	
	void feeStatus() throws SQLException, ClassNotFoundException 
	{
		Connection con= connect();
		stat=con.createStatement();
		ResultSet rs=stat.executeQuery("select Name, Class, PaidFee from Student where PaidFee< 20000");
		System.out.println("Name of the Student Whose Fee is Remaining Are:");
		System.out.println("Name \t Class \t PaidFee");
		while(rs.next())
		{
			System.out.println(rs.getString("Name")+"\t"+rs.getString("Class")+"\t"+rs.getInt("PaidFee"));
			
		}
	}
	
	void addStationary() throws SQLException, ClassNotFoundException 
	{
		
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter Stationary Id");
		Stid=sc.nextInt();
		System.out.println("Enter name of item");
		 ItemName=sc.next();
		System.out.println("Enter Quantity");
		 quantity=sc.nextInt();
		System.out.println("Enter Total Price:");
		price=sc.nextDouble();
	
		String ins="insert into Stationary values('"+Stid+"','"+ItemName+"','"+quantity+"','"+price+"')";
		 int i=stat.executeUpdate(ins);
		 System.out.println("Stationary Record is Added ");
		
	}
	
	 void displayStationaryRecord() throws ClassNotFoundException, SQLException
	{
			Connection con= connect();
			stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from Stationary");
			System.out.println("Id \t Name\t Quantity\t Price");
			while(rs.next())
			{
				System.out.println(rs.getInt("Stid")+"\t"+rs.getString("Itemname")+"\t"+rs.getInt("Quantity")+"\t"+rs.getDouble("Price"));
				
			}
		}
	
	void addNewCourse() throws SQLException, ClassNotFoundException 
	{
		
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter Course Id");
		Cid=sc.nextInt();
		System.out.println("Enter name of Course");
		 CName=sc.next();
		System.out.println("Enter Fee");
		 CFee=sc.nextInt();
		System.out.println("Enter Duration Of Course In Hours");
		Duration=sc.nextInt();
	
		String ins="insert into Course values('"+Cid+"','"+CName+"','"+CFee+"','"+Duration+"')";
		 @SuppressWarnings("unused")
		int i=stat.executeUpdate(ins);
		 System.out.println("New Course is Added ");
		
	}
	
	void displayCourseRecord() throws ClassNotFoundException, SQLException
	{
			Connection con= connect();
			stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from Course");
			System.out.println("Id \t Name\t Fee\t Duration");
			while(rs.next())
			{
				System.out.println(rs.getInt("Cid")+"\t"+rs.getString("CourseName")+"\t"+rs.getInt("CourseFee")+"\t"+rs.getDouble("Duration_HR"));
				
			}
		}
	
	
	void addNewActivity() throws SQLException, ClassNotFoundException 
	{
		
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter Activity Id");
		Aid=sc.nextInt();
		System.out.println("Enter name of Activity");
		 AName=sc.next();
		System.out.println("Enter Fee");
		 AFee=sc.nextInt();
		
		String ins="insert into Activity values('"+Aid+"','"+AName+"','"+AFee+"')";
		 @SuppressWarnings("unused")
		int i=stat.executeUpdate(ins);
		 System.out.println("New Activity is Added ");
		
	}
	
	 void displayActivityRecord() throws ClassNotFoundException, SQLException
	{
			Connection con= connect();
			stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from Activity");
			System.out.println("Id \t Name\t Fee");
			while(rs.next())
			{
				System.out.println(rs.getInt("Aid")+"\t"+rs.getString("ActivityName")+"\t"+rs.getInt("ActivityFee"));
				
			}
		}
	
	void DeleteRecord() throws ClassNotFoundException, SQLException {
		Connection con= connect();
		stat=con.createStatement();
		System.out.println("Enter student  id to delete Record \n");
		 Sid=sc.nextInt();
		 String str="select * from Student where Sid="+Sid;
		 ResultSet rs=stat.executeQuery(str);
		 
		 if(rs.next()) {
			 System.out.println("value is persent");
			 String del="Delete from Student where Sid="+Sid;
			 int i=stat.executeUpdate(del);
			 if(i>0) {
				 System.out.println("Record is Deleted");
			 }
			 
		 }else {
			 System.out.println(Sid+" not Exits");
		 }
	}
	
	 void teachersalary() throws ClassNotFoundException, SQLException
		 {
				Connection con= connect();
				stat=con.createStatement();
				System.out.println("Enter Teacher  id to which has pay Salary \n");
				 Tid=sc.nextInt();
				 String str="select * from Teacher where Tid="+Tid;
				 ResultSet rs=stat.executeQuery(str);
				 
				 if(rs.next()) {
					 System.out.println("value is persent");
					 System.out.println("Enter salary Amount");
					 int Salary=sc.nextInt();
					 
					 String updated="update Teacher set Salary='"+ Salary +"'where Tid="+Tid;
					 int i=stat.executeUpdate(updated);
					 if(i>0) 
					 {
						 System.out.println("Salary is Done");
					 }
					 
				 }
				 else 
				 {
					 System.out.println(Tid+" not Exits");
				 }
			}
	
		 
		 void expence() throws ClassNotFoundException, SQLException
		 {
			 Connection con= connect();
			 double amount = 0;
			 double amount2=0;
			 PreparedStatement ps=con.prepareStatement("select SUM(Salary) from Teacher");
				ResultSet rs=ps.executeQuery();
				System.out.println("Total Salary That we pay To All Teacher");
				while(rs.next())
				{
					 amount=(rs.getDouble(1));
					 System.out.println(amount);
				}
				
				 PreparedStatement ps1=con.prepareStatement("select SUM(Price) from Stationary");
					ResultSet rs1=ps1.executeQuery();
					System.out.println("Amount used for Stationary");
					while(rs1.next())

					{
						 amount2=(rs1.getDouble(1));
						 System.out.println(amount2);
					}
				System.out.println("School Fund Amount Is:");
				System.out.println(School_Fund);
				System.out.println("After pay to all teacher Salary and Stationary Amount remaining AMOINT IS:");
				double expence=School_Fund-amount-amount2;
				System.out.println(expence);
		 }
	
		 void revenue() throws ClassNotFoundException, SQLException
		 {
			 Connection con= connect();
			 int amount1=0;
			 double amount2=0;
			 double revenue=0;
			 
			 PreparedStatement ps1=con.prepareStatement("select SUM(paidfee) from Student");
				ResultSet rs1=ps1.executeQuery();
				System.out.println("Amount School Received from Student Fee");
				while(rs1.next())

				{
					 amount1=(rs1.getInt(1));
					 System.out.println(amount1);
				}
				
			 PreparedStatement ps2=con.prepareStatement("select SUM(Fee) from Enrolled");
					ResultSet rs2=ps2.executeQuery();
					System.out.println("Amount School Received from Course Fee and Activity Fee");
					while(rs2.next())

					{
						 amount2=(rs2.getDouble(1));
						 System.out.println(amount2);
					}
					
				
						System.out.println("School Fund Amount Is:");
						System.out.println(School_Fund);
						System.out.println("After Adding all Above Fee AMOINT IS:");
						revenue=School_Fund+amount1+amount2;
						System.out.println(revenue);
 
		 }
		 
		
	
	}



public class course_management {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		School obj1=new School();
		Teacher obj2=new Teacher();
		Student obj3=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("Login as\n1.Admin\n2.Student\n3.Teacher");
		int c=sc.nextInt();
		if(c==1)
		{
			System.out.println("Joinning As School Admin");
			while(true)
			{
				System.out.println("1. Add New student");
				System.out.println("2. Display All Student Record");
				System.out.println("3. Check All Student Fee Info");
				System.out.println("4. Add New Teacher");
				System.out.println("5. Display Data Of All Teacher");
				System.out.println("6.Add Stationary Item");
				System.out.println("7.Display Stationary");
				System.out.println("8.Add New Course");
				System.out.println("9.Display All Course");
				System.out.println("10.Add New Activity");
				System.out.println("11.Display Activity Record");
				System.out.println("12.Delete Student record ");
				System.out.println("13.Complete Teacher Salary Process");
				System.out.println("14.Trace Expence Details");
				System.out.println("15.Trace Revenue Details");
				System.out.println("16. Exit");
				int ch1=obj1.sc.nextInt();
				switch(ch1)
				{
				case 1:
					System.out.println("Add New Student:");
					obj3.addStudentRecord();
					break;
					
				case 2:
					System.out.println("Display All Student Record ");
					obj1.displayStudentRecord();
					break;
					
				case 3:
					obj1.feeStatus();
					break;
					
				case 4:
					obj2.addTeacherRecord();
					break;
					
				case 5:
					obj1.displayTeacherRecord();
					break;
					
				case 6:
					obj1.addStationary();
					break;
					
				case 7:
					obj1.displayStationaryRecord();
					break;
				
				case 8:
					obj1.addNewCourse();
					break;
					
				case 9:
					obj1.displayCourseRecord();
					break;
					
				case 10:
					obj1.addNewActivity();
					break;
					
				case 11:
					obj1.displayActivityRecord();
					break;
				
				case 12:
					obj1.DeleteRecord();
					break;
					
				case 13:
					obj1.teachersalary();
					break;
				
				case 14:
					obj1.expence();
					break;
				
				case 15:
					obj1.revenue();
					break;
					
				case 16:
					System.out.println("exit");
					System.exit(0);
				
				default:
					System.out.println("You enter Wrong Choice");
					break;
			}
			
			}
		}	
			
		if(c==2)
		{
			System.out.println("Joining As Student:");
			while(true)
			{
				System.out.println("1.View Profile");
				System.out.println("2.Display All Course");
				System.out.println("3.Display Activity Record");
				System.out.println("4.join Course and Activity");
				System.out.println("5. Exit");
				int ch2=obj1.sc.nextInt();
				switch(ch2)
				{
				case 1:
					obj3.viewStudentProfile();
					break;
					
				case 2:
					obj1.displayCourseRecord();
					break;
					
				case 3:
					obj1.displayActivityRecord();
					break;
					
				case 4:
					obj3.enrolled();
					break;
					
				case 5:
					System.out.println("exit");
					System.exit(0);
					break;
				
				default:
				System.out.println("You enter Wrong Choice");
				break;
				}}
		}
			
	if(c==3)
	{
			while(true)
			{
				System.out.println("1.View Profile");
				System.out.println("2.Display All Student Details");
				System.out.println("3.Display All Course");
				System.out.println("4.Display Activity Record");
				System.out.println("5. Exit");
				int ch3=obj1.sc.nextInt();
				switch(ch3)
				{
				case 1:
					System.out.println("Here Is Your Profile Information:");
					//obj1.addStudentRecord();
					break;
					
				case 2:
					obj1.displayStudentRecord();
					break;
					
				case 3:
					obj1.displayCourseRecord();
					break;
					
				case 4:
					obj1.displayActivityRecord();
					break;
					
				case 5:
					System.out.println("exit");
					System.exit(0);
				
				default:
				System.out.println("You enter Wrong Choice");
				break;
				}
				
			}
	}




}

}
