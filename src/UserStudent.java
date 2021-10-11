
public class UserStudent extends User{
	boolean isAdmin = false;
	
	public UserStudent(MemoryManager memManager) {
		this.memManager=memManager;
	}
	
	@Override
	public void viewRecord(int rollNo) {
		memManager.viewRecord(rollNo);
	}

	@Override
	public void viewAllRecords() {
		memManager.viewAllRecords();
	}

}
