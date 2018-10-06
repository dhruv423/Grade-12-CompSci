/**
 * This is an abstract parent class that holds undeclared methods and fields
 * such as employee number, first and last name of the employee. 
 * @author 323863597
 *
 */
public abstract class Employee {
	protected int employeeNumber; // Stores employee id
	protected String firstName; // Stores first name of the employee 
	protected String lastName; // Stores last name of the employee
	
	/**
	 * This takes in information about the employee makes a employee
	 * @param eNum asks for employee number
	 * @param fn ask for first name
	 * @param ln ask for last name
	 */
	public Employee(int eNum, String fn, String ln){
		this.employeeNumber = eNum;
		this.firstName = fn;
		this.lastName = ln;
	}
	/**
	 * Abstract method for pay
	 * @return a employee's pay
	 */
	public abstract double pay();
	/**
	 * Abstract method for deducting sick days
	 * 
	 */
	public abstract void deductSickDay(double sickDay);
	/**
	 * Abstract method for reseting sick days
	 */
	public abstract void resetSickDay();
	/**
	 * Prints out the monthly stub of the employee
	 * @return employee's monthly pay;
	 */
	public abstract String printPayStub();
	/**
	 * Prints out all the fields made in this class
	 */
	public String toString(){
		String s = "\nEmployee Number: " + employeeNumber + "\n";
		s += "First Name: " + firstName + "\n";
		s += "Last Name: " + lastName;
		return s;
	}
	
	
}
