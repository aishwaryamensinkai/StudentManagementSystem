import java.util.Map;
import java.util.Scanner;

public class Admin{
	public static Scanner scan = new Scanner(System.in);
	public static int getSelectedloginOption(MemoryManager memManager) {
		Map<String, String> configMap = FileManager.getConfigMap();
		String userType,password,enteredPassword;
		System.out.println("Please select the user type.\n 1.ADMIN \n 2.STUDENT");
		int option = -1;
		option = getInteger(scan);
		switch (option) {
		case 1:
			userType = "admin";
			break;
		case 2:
			userType = "student";
			break;
		default:
			System.out.println("Error: Invalid Input!!\nPlease enter valid option");
			return -1;
		}
		password = configMap.get(userType);
		System.out.println("Enter the password "+userType+" to login");
		enteredPassword = getString(scan);
		int count = 0;
		while(!enteredPassword.equals(password) && count < 2) {
			System.out.println("Error: Wrong Password, Try Again!!");
			enteredPassword = getString(scan);
			count++;
			if(count == 2) {
				System.out.println("Try After Some Time :(");
				System.exit(0);			
			}
		}
	return option;
	}

	private static int getInteger(Scanner scan) {
		int toReturn = -1;
		while(toReturn < 0) {
			try {
				toReturn = scan.nextInt();
			}catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
			}
			if(toReturn < 0)
				System.out.println("Error: Enter a number!!");
		}
		return toReturn;
	}
	
	private static String getString(Scanner scan) {
		String toReturn = null;
		while(toReturn == null)
			toReturn = scan.next();
		return toReturn;
	}

	public static void addStudentDetails(User user) {
		int rollNo,mathMarks,scienceMarks;
		String name;
		System.out.println("Enter Name :");
		name = getString(scan);
		System.out.println("Enter Roll No :");
		rollNo = getInteger(scan);
		System.out.println("Enter Math Marks :");
		mathMarks = getInteger(scan);
		System.out.println("Enter Science Marks");
		scienceMarks = getInteger(scan);
		((UserAdmin)user).addRecord(new Student(rollNo,name,mathMarks,scienceMarks));
	}

	public static void deleteStudentDetails(User user) {
		int rollNo;
		System.out.println("Enter the roll no to delete student details");
		rollNo = getInteger(scan);
		((UserAdmin)user).deleteRecord(rollNo);
	}

	public static void editStudentDetails(User user) {
		String editName;
		int rollNo,toEditInt;
		System.out.println("Enter the Roll no");
		rollNo = getInteger(scan);
		System.out.println("Please select the field to edit.\n 1.Name \n 2.Roll No \n 3.Math Marks \n 4.Science Marks");
		int option = -1;
		option = getInteger(scan);
		while(option < 0 || option > 4) {
			System.out.println("Error: Invalid Option\n Please enter valid option");
			option = getInteger(scan);
		}
		switch(option) {
		case 1:
			System.out.println("Enter new name :");
			editName = getString(scan);
			((UserAdmin)user).editRecord(rollNo, "name", editName);
			break;
		case 2:
			System.out.println("Enter new roll no :");
			toEditInt = getInteger(scan);
			((UserAdmin)user).editRecord(rollNo, "rollNo", toEditInt);
			break;
		case 3:
			System.out.println("Enter new Math marks :");
			toEditInt = getInteger(scan);
			((UserAdmin)user).editRecord(rollNo, "mathMarks", toEditInt);
			break;
		case 4:
			System.out.println("Enter new name :");
			toEditInt = getInteger(scan);
			((UserAdmin)user).editRecord(rollNo, "scienceMarks", toEditInt);
			break;			
		}
	}

	public static void viewStudentDetails(User user) {
		int rollNo;
		System.out.println("Enter the Roll no");
		rollNo = getInteger(scan);
		user.viewRecord(rollNo);
	}

	public static int getUserStudentSelectedOption() {
		System.out.println("Please select the operation."
				+ "\n 1. View Student"
				+ "\n 2. Exit");
		int option = -1;
		option = getInteger(scan);
		if(option < 1 || option > 3) {
			System.out.println("Error: Invalid input!!");
			return -1;
		}
		return option;
	}
	
	public static int getUserAdminSelectedOption() {
		System.out.println("Please select the operation."
				+ "\n 1. Add Student "
				+ "\n 2. Delete Student"
				+ "\n 3. Edit Student"
				+ "\n 4. View Student"
				+ "\n 5. View All Students"
				+ "\n 6. View All Passed Students"
				+ "\n 7. Save and Exit");
		int option = -1;
		option = getInteger(scan);
		if(option < 1 || option > 8) {
			System.out.println("Error: Invalid input!!");
			scan.close();
			return -1;
		}
		return option;
	}
}
				 