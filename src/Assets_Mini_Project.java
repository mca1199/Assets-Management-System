import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
public class Assets_Mini_Project {

	public static void main(String[] args) {
		try {
			
	
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uname="System";
		String password="12345";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,uname,password);
//		String q="Create table Assets1(Product_Name varchar(20) not null, Model_Number varchar(10) primary key not null,Company varchar(20) not null,Color varchar(8) not null, Warranty varchar(8) not null,Screen_Size varchar(10), Screen_Resolution varchar(20), Architectur varchar(8),OS_Architecture varchar(20),Prices number, Total_Atoms number(10))";
		System.out.println("WELCOM TO LAPTOP WORLD .....");
		System.out.println("***********************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("Operater Choice is 1:");
		System.out.println("Manager Choice is 2:");
		System.out.println("Operater Choice :");
		int a=sc.nextInt();
		if(a==1)
		{
		String q2="Insert into Assets1(Product_Name,Model_Number,Company,Color, Warranty,Screen_Size ,Screen_Resolution,Architectur,OS_Architecture,Prices,Total_Atoms) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(q2);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 
		
		System.out.println("Enter Product Name");
		String P_Name=br.readLine();
		ps.setString(1,P_Name);
		System.out.println("Enter Model_Number");
		String M_Number=br.readLine();
		ps.setString(2,M_Number);
		System.out.println("Enter Company Name");
		String Comp=br.readLine();
		ps.setString(3,Comp);
		System.out.println(" Enter Color");
		String Clr=br.readLine();
		ps.setString(4,Clr);
		System.out.println(" Enter Warranty");
		String War=br.readLine();
		ps.setString(5,War);
		System.out.println(" Enter Screen_Size");
		String S_Size=br.readLine();
		ps.setString(6,S_Size);
		System.out.println("Enter Screen_Resolution");
		String S_Resolution=br.readLine();
		ps.setString(7,S_Resolution);
		System.out.println(" Enter Architectur");
		String Architec=br.readLine();
		ps.setString(8,Architec);
		System.out.println(" Enter OS_Architecture");
		String OS_Architec=br.readLine();
		ps.setString(9,OS_Architec);
		System.out.println("Enter Prices");
		String Price=br.readLine();
		ps.setString(10,Price);
		//br.readLine();
		System.out.println("Enter Total_Atoms");
		int T_Atoms=br.read();
		ps.setInt(11,T_Atoms);
//		Statement st= con.createStatement();
//		st.executeUpdate(q);
		ps.executeUpdate();
//		System.out.println("Table Create....");
		System.out.println("one Row Is Created....");
		}
		else if(a==2)
			{
			String q2="Select Total_Atoms from Assets1 where Company='Dell'and Product_Name='Laptop' ";
		//2
	      //String q2="Select *from Assets1";
			Statement ps=con.createStatement();
			ResultSet rs1=ps.executeQuery(q2);
//            while(rs1.next())
//            {
//			Scanner sc1=new Scanner(System.in);
//			System.out.println("Enter The Input to Find Table Data");
			while(rs1.next())
			{
				System.out.println("Total items of dell company's laptop is : "+rs1.getString("Total_Atoms"));
            }
			}
		
	
		
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}