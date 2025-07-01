import java.sql.SQLException;
import java.util.Scanner;

public class App {
	public static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		boolean choice = true;
		while(choice) {
			printChoice();
			int choiOp = scan.nextInt();
			scan.nextLine();
			
			switch(choiOp) {
			   case 1 -> AddStudent();
			   case 2 -> ViewAllStudents();
			   case 3 -> ViewSingleStudent();
			   case 4 -> UpdateStudentByID();
			   case 5 -> DeleteStudentByID();
			   case 6 -> {
			            System.out.println("Exiting the program...");
			            choice = false; // Will break the loop
			   }
			   default -> System.out.println("Invalid Choice");
			}
		}
	}
	
	
	public static void printChoice() {
		System.out.println();
		System.out.println("Student Management System:");
		System.out.println("1.Add New Student");
		System.out.println("2.View all Student Details");
		System.out.println("3.View Single Student Details by ID");
		System.out.println("4.Update Student by ID");
		System.out.println("5.Delete STudent By ID");
		System.out.println("6.Exit Choice");
		System.out.println("Enter the choice of Operation you want:");
	}
	
	public static void AddStudent() {
		System.out.println("Enter Student Details:");
		System.out.println("Enter Student ID:");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Student Name:");
		String name = scan.nextLine();
		System.out.println("Enter Student Email:");
		String email = scan.nextLine();
		System.out.println("Enter Student Age:");
		int age = scan.nextInt();
		scan.nextLine();
		
		try {
			StudentDAO.AddStudent(id, name, email, age);
			System.out.println("Student Added Succesfully!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ViewAllStudents() {
		try {
			StudentDAO.ViewAllStudents();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewSingleStudent() {
		try {
			System.out.println("Enter the ID of the Student");
			int id = scan.nextInt();
			StudentDAO.ViewSingleStudent(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateStudentByID() {
		try {
			System.out.println("Enter the Details to Update the Student Details:");
			System.out.println("Enter Student ID:");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Student Name:");
			String name = scan.nextLine();
			System.out.println("Enter Student Email:");
			String email = scan.nextLine();
			System.out.println("Enter Student Age:");
			int age = scan.nextInt();
			scan.nextLine();
			
			int res = StudentDAO.UpdateStudentByID(id, name, email, age);
			System.out.println("Record Updated Sucessfully "+res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteStudentByID() {
		try {
			System.out.println("Enter the Student ID You want to Delete");
			int id = scan.nextInt();
			
			int res = StudentDAO.DeleteStudentByID(id);
			System.out.println("Record Updated Sucessfully "+res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
