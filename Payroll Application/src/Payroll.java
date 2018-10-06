import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This is a class which stores the list of employees and appropriate methods to be used in the
 * main class.
 * @author Dhruv
 *
 */
public class Payroll {
	Employee [] staffList;
	
	/**
	 * This method prints out all the employees in the array
	 * with their name, employee number, and whether they are part time or
	 * full time
	 */
	public void listAllEmployee(){
		for(int i = 0; i < staffList.length; i++){
			System.out.println(staffList[i]);
		}
	}
	/**
	 * This method updates the number of sick days taken. This method 
	 * takes in employee number and number of sick days and finds the corresponding 
	 * employee and updates the sick day information
	 * @param sickDays takes in employee number
	 * @param empNum takes in employee number
	 */
	public void enterSickDay(double sickDays, int empNum){
		for(int i = 0; i < staffList.length; i++){
			if(empNum == staffList[i].employeeNumber){
				staffList[i].deductSickDay(sickDays); // Calls the deduct sick day method
			}
		}
	}
	/**
	 * Prints out the toString method for the 
	 * appropriate type of employee
	 */
	public void printAllPayStubs(){
		for(int i = 0; i < staffList.length; i++){
			if(staffList[i] instanceof FullTimeStaff){ // Checks if its a full time employee
				System.out.println(((FullTimeStaff)staffList[i]).printPayStub()); 
			}else // If its not a full time employee, it has to be a part time employee
				System.out.println(((PartTimeStaff)staffList[i]).printPayStub()); 
		}
	}
	/**
	 * Method that reads a file called by the user and stores the information to the array
	 * @param fn takes in the file name
	 */
	public void loadStaffList(String fn){
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(fn)));
			int size = Integer.parseInt(s.next()); // Gets the first number
			staffList = new Employee [size]; // The first number is the size of the array
			for(int i = 0; i < staffList.length; i++){
				int empNum = Integer.parseInt(s.next()); // Gets the employee number
				String fN = s.next(); // Gets the first name
				String lN = s.next(); // Gets the last name
				String type = s.next(); // Gets the type of employee
				if(type.equals("FT")){ // If its full time calls the full time constructor and stores all the info
					staffList[i] = new FullTimeStaff(empNum, fN, lN, Double.parseDouble(s.next()));
					((FullTimeStaff)staffList[i]).deductSickDay(Double.parseDouble(s.next()));
				}else{ // Calls the part time constructor and stores all the info
					staffList[i] = new PartTimeStaff(empNum, fN, lN, Double.parseDouble(s.next()), Double.parseDouble(s.next()));
				}	
			}
		} catch( FileNotFoundException e){ // If file is not found
			System.out.println("File was not found!");
		} finally {
			if (s!=null){
				s.close();
			}
		}
	}
	
	/**
	 * This method writes all the information stored on the array
	 * to a file called by the user
	 * @param fn takes in the file name
	 */
	public void saveStaffList(String fn){
		File file = new File(fn);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(staffList.length); // Writes the size of the array in the file
			for(int i = 0; i < staffList.length; i++){ 	
				pw.println(staffList[i].employeeNumber); // Writes the employee number
				pw.println(staffList[i].firstName); // Writes the first name
				pw.println(staffList[i].lastName); // Writes the last name
				if(staffList[i] instanceof FullTimeStaff){ // Checks if its a full time staff
					pw.println("FT"); // Writes the type of employee
					pw.println(((FullTimeStaff)staffList[i]).getYearlySalary()); // Writes the yearly salary
					pw.println(((FullTimeStaff)staffList[i]).getSickDaysUsed()); // Writes the sick days used
				}else{ // Enters else if its a part time employee
					pw.println("PT"); // Writes the type of employee
					pw.println(((PartTimeStaff)staffList[i]).getHourlyRate()); // Writes the hourly rate
					pw.println(((PartTimeStaff)staffList[i]).getHours()); // Writes the number of hours assigned
				}
			}
		} catch (FileNotFoundException e) { // If file not found
			e.printStackTrace();
		} finally {
			if(pw != null){
				pw.close();
			}
		}	
	}
	/**
	 * This method calculates the average yearly salary of full time staff and returns it 
	 * @return the average yearly salary
	 */
	public double averageSalary(){
		double counter = 0;
		double totalSal = 0;
		for(int i = 0; i < staffList.length; i++){
			if(staffList[i] instanceof FullTimeStaff){ // Checks if it is a full time employee
				totalSal += ((FullTimeStaff)staffList[i]).getYearlySalary(); // Adds all the full time employee salary
				counter++; // Keeps count of the full time employees in the array
			}
		}
		System.out.print("The average salary for full time staff is: ");
		return totalSal / counter;

	}
	/**
	 * This method calculates the average hourly rate of the part time staffs and returns it
	 * @return the average hourly rate
	 */
	public double averageHourlyRate(){
		double counter = 0;
		double totalHourlyRate = 0;
		for(int i = 0; i < staffList.length; i++){
			if(staffList[i] instanceof PartTimeStaff){ // Checks if it is a part time staff
				totalHourlyRate += ((PartTimeStaff)staffList[i]).getHourlyRate(); // Adds all the hourly rates
				counter++; // Keeps count of the part time employees in the array
			}
		}
		System.out.print("The average hourly rate for part time staff is: ");
		return totalHourlyRate / counter;
	}
	
	/**
	 * This method finds which full time employee took the most days off and returns its information
	 * @return employee
	 */
	public Employee mostAbsentFullTime(){
		int mostAbsent = 0; // Holds the array index of the employee
		double sickDays = -1; // Starts at -1 because the highest days off can be 0
		for(int i = 0; i < staffList.length; i++){
			if(staffList[i] instanceof FullTimeStaff){ // Checks if it is a full time employee
				if(((FullTimeStaff)staffList[i]).getSickDaysUsed() > sickDays){
					mostAbsent = i;
					sickDays = ((FullTimeStaff)staffList[i]).getSickDaysUsed();
				}
			}
		}
		System.out.println("The full time employee who has the most absents this year is: ");
		return staffList[mostAbsent];
	}
	
	/**
	 * This method finds which part time employee took the most days off and returns its information
	 * @return employee
	 */
	public Employee mostAbsentPartTime(){
		int mostAbsent = 0; // Holds the array index of the employee
		double sickDays = -1; // Starts at -1 because the highest days off can be 0
		for(int i = 0; i < staffList.length; i++){
			if(staffList[i] instanceof PartTimeStaff){ // Checks if it is a part time employee
				if(((PartTimeStaff)staffList[i]).getSickDaysTaken() > sickDays){
					sickDays = ((PartTimeStaff)staffList[i]).getSickDaysTaken();
					mostAbsent = i;
				}
			}
		}
		System.out.println("The part time employee who has the most absents this month is: ");
		return staffList[mostAbsent];
	}
	
	/**
	 * This method resets the sick days, it calls the reset method in the full time staff class
	 */
	public void yearlySickDayReset(){
		for(int i =0; i < staffList.length; i++){
			if(staffList[i] instanceof FullTimeStaff){ // Checks if it is a full time employee
				((FullTimeStaff)staffList[i]).resetSickDay(); // Calls the reset method
			}
		}
	}
	
	/**
	 * This method resets the sick days, it calls the reset method in the part time staff class
	 */
	public void monthlySickDayReset(){
		for(int i =0; i < staffList.length; i++){
			if(staffList[i] instanceof PartTimeStaff){ // Checks if it is a part time employee
				((PartTimeStaff)staffList[i]).resetSickDay(); // Calls the reset method
			}
		}
	}
		
	
}



