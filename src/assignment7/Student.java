package assignment7;

public class Student {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int id; 
	private int totalAttemptedCredits;
	private int totalPassingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
    // toString() method
    public String toString() 
    { 
      return this.firstName + " " + this.lastName + " " + this.id;
    }
	
	// constructor
	public Student(String initFirstName, String initLastName, int initId) {
		this.firstName = initFirstName;
		this.lastName = initLastName;
		this.id = initId;
	}
	
	// methods
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return this.id;
	}
	
	/**
	 * takes in a course grade (as a value between 0 and 4) and the number of credits 
	 * for a course, and updates the students GPA accordingly
	 * 
	 * @param grade a course grade (as a value between 0 and 4)
	 * @param credits the number of credits for a course
	 */
	public void submitGrade(double grade, int credits) {
		 if (grade >= 0.0 && grade <= 4.0) {
			 if (grade >= 1.7) {
				  totalAttemptedCredits += credits;
				  totalPassingCredits += credits;
			 } else {
				 totalAttemptedCredits += credits;
			 }
			 totalGradeQualityPoints += grade * credits;
		 }
	}
	
	public int getTotalAttemptedCreidts() {
		return this.totalAttemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return this.totalPassingCredits;
	}
			
	/**
	 * calculate GPA (Grade Point Average)
	 * 
	 * @return GPA of the student
	 */
	public double calculateGradePointAverage() {
		return this.totalGradeQualityPoints / (double) totalAttemptedCredits;
	}
	
	/**
	 *  returns the students class standing based on how many passing credits they have
	 * 
	 * @return students class standing (First Year, Sophomore, Junior, or Senior)
	 */
	public String getClassStanding() {
		if (this.totalPassingCredits < 30) {
			return "First Year";
		} else if (this.totalPassingCredits >= 30 && this.totalPassingCredits < 60) {
			return "Sophomore";
		} else if (this.totalPassingCredits >= 60 && this.totalPassingCredits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	/**
	 *  returns whether the student is eligible for Phi Beta Kappa
	 * 
	 * @return boolean whether the student is eligible for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		double gpa = this.calculateGradePointAverage();
		boolean condition1 = (this.totalAttemptedCredits >= 98 && gpa >= 3.60);
		boolean condition2 = (this.totalAttemptedCredits >= 75 && gpa >= 3.80);
		if (condition1 || condition2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *  takes in the amount of money and add it to student's bear bucks balance
	 * 
	 * @param amount the amount of money to be added to student's bear bucks balance
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	/**
	 *  takes in the amount of money and subtract it to student's bear bucks balance
	 * 
	 * @param amount the amount of money to be subtracted from student's bear bucks balance
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	/**
	 *  Zero out the Bear Bucks balance and return the appropriate amount
	 * 
	 * @return the appropriate amount as (previously) specified in the Terms of Service 
	 * for Bear Bucks 
	 */
	public double cashOutBearBucks() {
		double balance = this.getBearBucksBalance();
		if (balance >= 10) {
			this.deductBearBucks(balance);
			return balance - 10;
		} else {
			this.deductBearBucks(balance);
			return 0;
		}
	}
	/**
	 *  take parameters for a first name, the other parent, whether the last name should 
	 *  be hyphenated, and a student id number to create and return a new Student object
	 * 
	 * @param firstName the new Student(child)'s first name
	 * @param other the other Student(the other parent)
	 * @param isHyphenated whether the last name should be hyphenated
	 * @param id the new Student(child)'s id
	 * 
	 * @return a new Student(child) object
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastName = isHyphenated ? this.getLastName() + "-" + other.getLastName() : this.getLastName();
		Student child = new Student(firstName, lastName, id);
		double bearBucksAmount = this.cashOutBearBucks() + other.cashOutBearBucks();
		child.depositBearBucks(bearBucksAmount);
		return child;
	}
}

