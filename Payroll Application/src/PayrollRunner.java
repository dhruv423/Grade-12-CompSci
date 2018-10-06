import java.util.Scanner;
/**
 * @author Dhruv Bhavsar
 * Teacher: Ms.Jansen
 * Date: 11/25/2017
 * This is a payroll application for LBP. Co. which stores information
 * of all its employees. Each employee is classified as a part time or 
 * full time staff. Full-time and part-time staffs work under different contracts.
 * Full-time staffs are hired with a yearly (12 months) salary. 
 * They are paid monthly. Each of them is given 20 sick days per year.
 * Part-time staffs are hired with an hourly rate. 
 * Each of them is assigned a certain number of hours per month (same every month). 
 * They do not have any sick day benefit, i.e., they do not get paid for the days they are absent.
 * This program takes in a command which can range from list all employees to resetting monthly
 * sick days for part time employees. This program can also load and save files.
 *
 */
public class PayrollRunner {
	public static void main(String[] args) {
		String input;
		Payroll payroll = new Payroll();
		System.out.println("Welcome");
		// Runs the code at least once
		// Keeps looping until the user exits
		do{
			// Prints out the functions that can be done
			System.out.println("");
			System.out.println("Select from the following methods:");
			System.out.println("0. Exit");
			System.out.println("1. List all Employees");
			System.out.println("2. Update the Sick Days");
			System.out.println("3. Print all the pay stubs");
			System.out.println("4. Save the current staff list");
			System.out.println("5. Load a staff list from a file");
			System.out.println("6. Calculate the average full time staff salary");
			System.out.println("7. Calculate the average hourly rate for part time staff");
			System.out.println("8. Print the full time employee who has the most sick days taken");
			System.out.println("9. Print the part time employee who has the most sick days taken");
			System.out.println("10. Reset the yearly sick days for all full time employees");
			System.out.println("11. Reset the monthly sick days for all part time employees");
			
			System.out.println("");
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your command: ");
			input = in.nextLine();
			
			// If statements for calling methods based on user input
			
			if(input.equals("1")){
				payroll.listAllEmployee();
			}
			else if(input.equals("2")){
				System.out.println("Enter the employee number: "); 
				int empNum = Integer.parseInt(in.nextLine()); // Gets the employee number
				System.out.println("Enter the number of Sick Days: ");
				double sickDays = Double.parseDouble(in.nextLine()); // Gets the sick days
				payroll.enterSickDay(sickDays, empNum); // Calls the method based on the info provided by the user
			}
			else if(input.equals("3")){
				payroll.printAllPayStubs();
			}
			else if(input.equals("4")){
				System.out.println("Please enter the name of the file: ");
				String file = in.nextLine(); // Gets the file name
				payroll.saveStaffList(file); // Uses the file name as the parameter to the method
			}
			else if(input.equals("5")){
				System.out.println("Please enter the name of the file: ");
				String file = in.nextLine(); // Gets the file name
				payroll.loadStaffList(file); // Uses the file name as the parameter to the method
			}
			else if(input.equals("6")){
				System.out.println(payroll.averageSalary());
			}
			else if(input.equals("7")){
				System.out.println(payroll.averageHourlyRate());
			}
			else if(input.equals("8")){
				System.out.println(payroll.mostAbsentFullTime());
			}
			else if(input.equals("9")){
				System.out.println(payroll.mostAbsentPartTime());
			}
			else if(input.equals("10")){
				payroll.yearlySickDayReset();
			}
			else if(input.equals("11")){
				payroll.monthlySickDayReset();
			}
			else if(!(input.equals("0"))){  // Prints error if command is not anything above
				System.out.println("Error! Re-enter the function");
			}
			
		}while(!(input.equals("0"))); // Program terminates if the command is 0
		System.out.println("Program Terminated");
		System.out.println("Goodbye!");
		

	}

}
