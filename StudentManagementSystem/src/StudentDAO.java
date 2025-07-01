import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	
	public static Connection conn = null;
	
	public static String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
	public static String username = "root";
	public static String password = "Manasa@204";
	
	public static void initConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void AddStudent(int id,String name,String email,int age) throws SQLException {
		
		if(conn == null) {
			initConnection();
		}
		
		String Insert_query = "Insert into `Student` (`Id`,`Name`,`Email`,`Age`) values (?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(Insert_query);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setInt(4, age);
		
		pstmt.executeUpdate();
	}
	
	public static void ViewAllStudents() throws SQLException {
		
		if(conn == null) {
			initConnection();
		}
		
		String Retriew_Query = "SELECT * from `Student`";
		
		PreparedStatement pstmt = conn.prepareStatement(Retriew_Query);
		
		ResultSet res = pstmt.executeQuery();
		
		System.out.printf("\n------------------------------------------------------");
		System.out.printf("\n| %-2s | %-10s | %-26s | %s |", "ID", "NAME", "EMAIL", "AGE");
		System.out.printf("\n----------------------------------------------------");
		while(res.next()) {
			System.out.printf("\n| %-2d | %-10s | %-26s | %d  |",res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
			System.out.printf("\n------------------------------------------------------");
		}
        System.out.println();
		
	}
	
	public static void ViewSingleStudent(int id) throws SQLException {
		if(conn == null) {
			initConnection();
		}
		
		String Retriew_Query = "SELECT * from `Student` where `ID` = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(Retriew_Query);
		
		pstmt.setInt(1, id);
		
		ResultSet res = pstmt.executeQuery();
		
		while(res.next()) {
			System.out.printf("\n------------------------------------------------------");
			System.out.printf("\n| %-2s | %-10s | %-26s | %s |", "ID", "NAME", "EMAIL", "AGE");
			System.out.printf("\n----------------------------------------------------");
			System.out.printf("\n| %-2d | %-10s | %-20s | %d  |",res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
			System.out.printf("\n------------------------------------------------------");
			System.out.println();
		}
		
	}
	
	public static int UpdateStudentByID(int id,String name,String email,int age) throws SQLException {
		
		if(conn == null) {
			initConnection();
		}
		
		String Update_Query = "update `Student` set `Name` = ? ,`Email` = ?,`Age` = ? where `Id` = ?";
		PreparedStatement pstmt = conn.prepareStatement(Update_Query);
		
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setInt(3, age);
		pstmt.setInt(4, id);
		
		int res = pstmt.executeUpdate();
		return res;
		
	}
	
	public static int DeleteStudentByID(int id) throws SQLException {
		if(conn == null) {
			initConnection();
		}
		
		String Delete_Query = "Delete from `Student` where `Id` = ?";
		PreparedStatement pstmt = conn.prepareStatement(Delete_Query);
		pstmt.setInt(1,id);
		
		return pstmt.executeUpdate();
	}

}
