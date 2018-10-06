/**
 * This is a child class of the Employee class. It contains appropriate
 * methods and fields such as number of hours assigned, hourly rate, and sick days taken
 * @author 323863597
 *
 */
public class PartTimeStaff extends Employee {
	private double numHoursAssigned;
	private double hourlyRate;
	private double sickDaysTaken;
	
	 /**
	 * This is a part time staff constructor which uses the super function to inherit 
	 * the previous constructor. 
	 * @param eNum takes in employee number
	 * @param fn takes in first name
	 * @param ln takes in last name
	 * @param hourSal takes in hourly rate
	 * @param hours takes in the hours assigned
	 */
	public PartTimeStaff(int eNum, String fn, String ln, double hourSal, double hours){
		super(eNum, fn, ln);
		this.numHoursAssigned = hours;
		this.hourlyRate = hourSal;
		this.sickDaysTaken = 0;
	}
	
	/**
	 * Accessor method for hourly rate
	 * @return hourly rate
	 */
	public double getHourlyRate(){
		return this.hourlyRate;
	}
	
	/**
	 * Accessor method for hours assigned
	 * @return hours assigned
	 */
	public double getHours(){
		return numHoursAssigned;
	}
	
	/**
	 * Accessor method for sick days taken
	 * @return sick days taken
	 */
	public double getSickDaysTaken(){
		return this.sickDaysTaken;
	}

	@Override
	/**
	 * Returns the monthly pay by multiplying the hourly rate by the hours worked
	 */
	public double pay() {
		return (this.numHoursAssigned - (this.sickDaysTaken * 8)) * this.hourlyRate;
		
	}
	
	@Override
	/**
	 * Deducts the sick days (specified from user) from sick days left
	 * @param sick days taken by the user input 
	 */
	public void deductSickDay(double sickDay) {
		this.sickDaysTaken += sickDay;
	}

	@Override
	/**
	 * Reset the number of sick days taken
	 */
	public void resetSickDay() {
		this.sickDaysTaken = 0;
	}

	@Override
	/**
	 * Prints the pay stub with name, employee number, monthly pay, sick days taken, sick days left
	 */
	public String printPayStub() {
		String s = super.toString();
		s += "\nMonthly Pay: " + pay();
		s += "\nSick Days Taken: " + sickDaysTaken;
		s += "\nNumber of Hours Assigned: " + (numHoursAssigned - (sickDaysTaken * 8));
		return s;
	}
	/**
	 * This method
	 * returns 0 if  they have same sick days taken
	 * returns positive if this employee has more sick days than other
	 * returns negative if other employee has more sick days than this
	 * @param other takes in the another employee
	 * @return double difference of sick days
	 */
	public double compareToSickDay(Employee other){
		return sickDaysTaken - ((PartTimeStaff)other).sickDaysTaken;
	}
	
	/**
	 * Prints out all the fields made in this class
	 */
	public String toString(){
		String s = super.toString();
		s += "\nPart-Time Staff";
		return s;
	}

}
