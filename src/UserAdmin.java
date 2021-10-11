import java.io.FileNotFoundException;
import java.io.IOException;

public class UserAdmin extends User{
	boolean isAdmin = true;
	
	public UserAdmin(MemoryManager memManager) {
		this.memManager = memManager;
	}
	
	@Override
	public void viewRecord(int rollNo) {
		memManager.viewRecord(rollNo);
	}

	@Override
	public void viewAllRecords() {
		memManager.viewAllRecords();
	}
	
	public void viewPassedStudents() {
		memManager.viewPassedStudents();
	}
	
	public void addRecord(Student stu) {
		memManager.addRecord(stu);
	}
	
	public void deleteRecord(int rollNo) {
		memManager.deleteRecord(rollNo);
	}
	
	public void editRecord(int rollNo,String toEdit,int value) {
		memManager.editRecord(rollNo,toEdit,value);
	}
	
	public void editRecord(int rollNo,String toEditName,String value) {
		memManager.editRecord(rollNo, toEditName, value);
	}

	public void saveDetails(){
		try {
			memManager.saveRecords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
