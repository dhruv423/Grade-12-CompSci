/**
 * This is a child class of an Employee. It contains appropriate methods
 * and fields such as YEARLY_SICK_DAY, yearlySalary, and sickDaysLeft.
 * @author 323863597
 *
 */
 public class FullTimeStaff extends Employee {
	 private static final int YEARLY_SICK_DAY = 20;
	 private double yearlySalary;
	 private double sickDaysLeft;
	
	 /**
	 * This is a full time staff constructor which uses the super function to inherit 
	 * the previous constructor. 
	 * @param eNum takes in employee number
	 * @param fn takes in first name
	 * @param ln takes in last name
	 * @param yearSal takes in yearly salary
	 */
	public FullTimeStaff(int eNum, String fn, String ln, double yearSal) {
		super(eNum, fn, ln);
		this.yearlySalary = yearSal;
		this.sickDaysLeft = YEARLY_SICK_DAY;
	}
	
	/**
	 * Accessor method for yearly salary
	 * @return yearly salary
	 */
	public double getYearlySalary(){
		return this.yearlySalary;
	}
	
	/**
	 * Accessor method for sick days used
	 * @return sick days used by  sick days left from the sick days constant 
	 */
	public double getSickDaysUsed(){
		return YEARLY_SICK_DAY - sickDaysLeft;
	}

	@Override
	/**
	 * Returns the monthly pay by dividing the yearly pay
	 * by 12 and rounding it to 2 decimal points
	 */
	public double pay() {
		double pay = yearlySalary / 12;
		pay = Math.round(pay * 100) / 100.0;
		return pay;
	}
	
	@Override
	/**
	 * Deducts the sick days (specified from user) from sick days left
	 * Prints out error if no sick days left
	 * @param sick days taken by the user input 
	 */
	public void deductSickDay(double sickDay) {
		if(this.sickDaysLeft > 0){
		this.sickDaysLeft -= sickDay; 
		}
		else
			System.out.println("No Sick Days left!");
	}

	@Override
	/**
	 * Reset the number of sick days left
	 */
	public void resetSickDay() {
		this.sickDaysLeft = YEARLY_SICK_DAY;
	}

	@Override
	/**
	 * Prints the pay stub with monthly pay, sick days taken, sick days left
	 */
	public String printPayStub() {
		String s = super.toString();
		s += "\nMonthly Pay: " + pay();
		s += "\nSick Days Taken: " + (YEARLY_SICK_DAY - sickDaysLeft);
		s += "\nSick Days Left: " + sickDaysLeft;
		return s;
	}
	/**
	 * returns 0 if  they have same sick days taken
	 * returns positive if this employee has more sick days than other
	 * returns negative if other employee has more sick days than this
	 * @param other takes in another employee
	 * @return double difference of sick days
	 */
	public double compareToSickDay(Employee other){
		return sickDaysLeft - ((FullTimeStaff)other).sickDaysLeft;
	}
	
	/**
	 * Prints out all the fields made in this class
	 */
	public String toString(){
		String s = super.toString();
		s += "\nFull-Time Staff";
		return s;
	}
}
