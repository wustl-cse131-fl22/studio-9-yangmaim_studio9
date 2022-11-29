package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	Map<String, Student> map;
	
	// constructor
	public UniversityDatabase() {
		this.map = new HashMap<String, Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		this.map.put(accountName, student);
	}

	public int getStudentCount() {
		return this.map.size();
	}

	public String lookupFullName(String accountName) {
		Student result = this.map.get(accountName);
		
		if (result != null) {
			return result.getFullName();
		} else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		
		double sum = 0;
		for(String name : map.keySet()) {
			Student student = this.map.get(name);
			double balance = student.getBearBucksBalance();
			sum += balance;
		}
		return sum;
	}
}
