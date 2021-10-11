import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MemoryManager {
	FileManager fileManager = null;
	Map<Integer, Student> studentMap = null;

	public MemoryManager(){
		try {
			fileManager = new FileManager();
			studentMap = fileManager.loadStudentRecords();
		} catch (EOFException e) {
			System.out.println("Ser file is empty!!");
			studentMap = new HashMap<Integer, Student>();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void viewRecord(int rollNo) {
		if(studentMap.get(rollNo) == null) {
			System.out.println("There is no student with Roll No :" + rollNo);
			return;
		}
		else
			System.out.println(studentMap.get(rollNo));
	}

	public void viewAllRecords() {
		Iterator itr = getSortedIterator();
		if(!itr.hasNext())
			System.out.println("No Records Found!!");
		while (itr.hasNext()) {
			int key = (int) itr.next();
			System.out.println(studentMap.get(key));
		}
	}

	public void viewPassedStudents() {
		Iterator itr = getSortedIterator();
		if(!itr.hasNext())
			System.out.println("No Records Found!!");
		while (itr.hasNext()) {
			int key = (int) itr.next();
			if(studentMap.get(key).isPassed)
				System.out.println(studentMap.get(key));
		}
	}
	
	private Iterator getSortedIterator() {
		return new TreeMap<Integer, Student>(studentMap).keySet().iterator();
	}
	
	public void addRecord(Student stu) {
		studentMap.put(stu.rollNo, stu);
	}

	public void deleteRecord(int rollNo) {
		if(studentMap.get(rollNo) == null) {
			System.out.println("There is no student with Roll No :" + rollNo);
			return;
		}
		else
			studentMap.remove(rollNo);
	}

	public void editRecord(int rollNo, String toEdit, int value) {
		if(studentMap.get(rollNo) == null) {
			System.out.println("There is no student with Roll No :" + rollNo);
			return;
		}
		else
			studentMap.get(rollNo).editRecord(toEdit, value);
	}

	public void editRecord(int rollNo, String toEditName, String value) {
		if(studentMap.get(rollNo) == null) {
			System.out.println("There is no student with Roll No :" + rollNo);
			return;
		}
		else
			studentMap.get(rollNo).editRecord(toEditName, value);
	}
	
	public void saveRecords() throws FileNotFoundException, IOException {
		fileManager.saveStudentDetails(studentMap);
	}
}
