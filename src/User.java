
public abstract class User {
	MemoryManager memManager;
	public boolean isAdmin;
	public abstract void viewRecord(int rollNo);
	public abstract void viewAllRecords();
}
