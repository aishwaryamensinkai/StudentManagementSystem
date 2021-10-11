import java.io.Serializable;

public class Student implements Serializable{
	String name;
	int rollNo,mathMarks,scienceMarks;
	float totalPercent;
	boolean isPassed;
	
	public Student() {}

	public Student(int rollNo, String name, int mathMarks, int scienceMarks) {
		this.rollNo = rollNo;
		this.name = name;
		this.mathMarks = mathMarks;
		this.scienceMarks = scienceMarks;
		setPassStatus();
	}
	
	public void setPassStatus() {
		totalPercent = ( mathMarks + scienceMarks )/2;
		if (totalPercent > 60)
			isPassed = true;
		else
			isPassed = false;
		
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", mathMarks=" + mathMarks + ", scienceMarks="
				+ scienceMarks + ", totalPercent=" + totalPercent + ", isPassed=" + isPassed + "]";
	}
	
	public int editRecord(String toEdit,int value) {
		switch (toEdit) {
		case "rollNo":
			rollNo = value;
			break;
		case "mathMarks":
			mathMarks = value;
			setPassStatus();
			break;
		case "scienceMarks":
			scienceMarks = value;
			setPassStatus();
			break;
		default:
			System.out.println("Error: Invalid field name!!");
			return -1;
		}
		return 1;
	}
	
	public int editRecord(String toEdit,String value) {
		if(toEdit.equals("name")) {
			name = value;
			return 1;
		}
		else
		{
			System.out.println("Error: Invalid field name!!");
			return -1;
		}
	}
}
