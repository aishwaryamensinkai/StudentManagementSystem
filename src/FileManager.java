import java.io.*;
import java.util.*;

public class FileManager {
	static Map<String, String> configFile = null;
	
	 FileManager() throws IOException {
		String line;
		configFile = new HashMap<>();
		BufferedReader br;
		br = new BufferedReader(new FileReader("/home/pelatro/eclipse-workspace/config.txt"));
		while ((line = br.readLine()) != null) 
		{
				String arr[] = line.split("=");
				configFile.put(arr[0], arr[1]);	
		}
		br.close();
	}

	Map<Integer, Student> loadStudentRecords() throws FileNotFoundException, IOException, Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(configFile.get("path")));
//		System.out.println(configFile.get("path"));
		Map<Integer, Student> map = (Map<Integer, Student>)ois.readObject();
		ois.close();
		return map;
	}
	
	public void saveStudentDetails(Map<Integer,Student> studentMap) throws FileNotFoundException, IOException {
		ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(configFile.get("path")));
		oos.writeObject(studentMap);
		oos.close();
	}
	
	static Map<String, String> getConfigMap(){
		return configFile;
	}
}
