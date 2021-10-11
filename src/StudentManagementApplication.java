public class StudentManagementApplication {

	public static void main(String[] args) {
		System.out.println("------STUDENT MANAGEMENT APPLICATION------");
		MemoryManager memManager = null;
		User user = null;
		int option = -1;

		try {
			memManager = new MemoryManager();
			while(option == -1) {
				option = Admin.getSelectedloginOption(memManager);
			}
			if(option == 1) {
				user =(UserAdmin) new UserAdmin(memManager);
				user.isAdmin = true;
			}
			else if(option == 2)
				user =(UserStudent) new UserStudent(memManager);
			option = -1;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user.isAdmin){
			while(true) {
				while(option == -1)
					option = Admin.getUserAdminSelectedOption();
				switch (option) {
				case 1:
					Admin.addStudentDetails(user);
					break;
				case 2:
					Admin.deleteStudentDetails(user);
					break;
				case 3:
					Admin.editStudentDetails(user);
					break;
				case 4:
					Admin.viewStudentDetails(user);
					break;	
				case 5:
					user.viewAllRecords();
					break;	
				case 6:
					((UserAdmin) user).viewPassedStudents();
					break;	
				case 7:
					try {
					((UserAdmin) user).saveDetails();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("Saving the Student Details...\nExiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Error: Invalid Input!!");
					break;
				}
				option = -1;
			}
		}
		else {
			while(true) {
				while(option == -1)
					option = Admin.getUserStudentSelectedOption();
				switch (option) {
				case 1:
					Admin.viewStudentDetails(user);
					break;	
				case 2:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Error: Invalid Input!!");
					break;
				}
				option = -1;
			}
		}
	}

}
