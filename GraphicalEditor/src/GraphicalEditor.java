import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author Dhruv Bhavsar
 * Teacher: Ms.Jansen
 * Date: 10/02/2017
 * Graphical editors such as Photoshop allow us to alter 
 * bit-mapped images in the same way that text editors allow us to modify documents.  
 * Images are represented as an M x N array of pixels, 
 * where each pixel has a given color.
 * This program takes in a command and appropriate amount of parameters
 * and alters the array based on user input, it can initialize a array, change a specific position of the 
 * array, clear, display, smooth, or make an rectangle in the specific area of the array.
 * This program can also save and load files.
 *
 */
public class GraphicalEditor {
	public static int[][] grid; 	// Declare global array
	public static int m; 	// Global array size
	public static int n; 	// Global array size
	public static String [] commands; 	// Global command array

	public static void main(String[] args) {
		do{
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your command: ");
			String input = in.nextLine();
			commands = input.split(" "); 	// Turns string into array

			// If statements for calling methods based on user input
			if(commands[0].equalsIgnoreCase("I")){
				if(commands.length == 3)
					initialize();
				else
					System.out.println("Incorrect amount of parameters"); 	// Error for wrong amount of parameters
			}
			else if (commands[0].equalsIgnoreCase("C")){
				if(commands.length == 1)
					clear();
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if (commands[0].equalsIgnoreCase("P")){
				if(commands.length == 4)
					pixel();
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(commands[0].equalsIgnoreCase("R")){
				if(commands.length == 6)
					rectangle();
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(commands[0].equalsIgnoreCase("D")){
				if(commands.length == 1)
					display();
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(commands[0].equalsIgnoreCase("L")){
				if(commands.length == 2)
					readFile(commands[1]);
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(commands[0].equalsIgnoreCase("S")){
				if(commands.length == 2)
					writeFile(commands[1]);
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(commands[0].equalsIgnoreCase("M")){
				if(commands.length == 1)
					smoothing();
				else
					System.out.println("Incorrect amount of parameters");
			}
			else if(!(commands[0].equalsIgnoreCase("X"))) 	// Prints error if command is not anything above
				System.out.println("Error Re-enter the command");

		}while(!(commands[0].equalsIgnoreCase("X"))); 	// Terminates if the command is x
		System.out.println("Program Terminated.");
	}
	// Method to initialize the array
	public static void initialize(){
		m = Integer.parseInt(commands[1]); 	// Converts the first index to int to get row
		n = Integer.parseInt(commands[2]); 	// Converts the second index to int to get column
		grid = new int [m][n]; 	// Assigns row and column to grid
	}
	// Method to assign 0 to all elements
	public static void clear(){
		for(int r = 0; r < grid.length; r++){ 	// Go through the array
			for (int c = 0; c < grid[r].length; c++){
				grid[r][c] = 0; 	// Replace all elements with 0
			}
		}
	}
	// Method to print out array
	public static void display(){
		for(int r = 0; r < grid.length; r++){
			for (int c = 0; c < grid[r].length; c++){
				System.out.printf("%2d " , grid[r][c]); 	// Printf makes the array look better
			}
			System.out.println();
		}
	}
	// Method to fill a specified location with a int from the user
	public static void pixel(){
		int row = Integer.parseInt(commands[1]); 	// Gets and converts the second element to an int
		int col = Integer.parseInt(commands[2]); 	// Gets and converts the third element to an int
		int colour = Integer.parseInt(commands[3]); 	// Gets and converts the forth element to an int
		grid [row][col] = colour; 	// Assign the location to the array
	}
	// Method to draw rectangle from user input
	public static void rectangle(){
		int upperLeft = Integer.parseInt(commands[1]);
		int upperLeft2 = Integer.parseInt(commands[2]);
		int lowerRight = Integer.parseInt(commands[3]);
		int lowerRight2 = Integer.parseInt(commands[4]);
		int colour = Integer.parseInt(commands[5]);

		for(int i = upperLeft; i <= lowerRight; i++){ // Goes through the array from the indicated points
			for(int x = upperLeft2; x <= lowerRight2; x++){
				grid [i][x] = colour; 	// Assigns a number to the location
			}
		}
	}
	// Method that averages itself and neighboring elements
	public static void smoothing(){
		int [][] temp = new int [m][n];
		for(int row = 0; row < grid.length; row++){ 	// Goes through the whole array
			for (int col = 0; col < grid[row].length; col++){
				int count = 0;
				int average = 0;
				int startRow = row -1; 
				int startCol = col - 1;
				int endRow = row + 1;
				int endCol = col + 1;

				if(startRow < 0){ 	// If startrow is less than 0 then bring back to its original position
					startRow++;
				}
				if(startCol < 0){ 	//If startcol is less than 0 then bring back to its original position
					startCol++;
				}
				if(endRow > grid.length - 1){ //If endrow is greater than the length of the array then bring back to its original position
					endRow--;
				}
				if(endCol > grid[row].length - 1){ //If endcol is greater than the length of the array then bring back to its original position
					endCol--;
				}
				for(int i = startRow; i <= endRow; i++){ 	// Only runs from startrow to endrow
					for(int x = startCol; x <= endCol; x++){ 	// Only runs from the startcol to endcol
						count++; 	// Counter for determining how many elements to divide by
						average += grid[i][x]; 	// Adds whatever the number is in the element to average
					}
				}
				average = average/count; 	// Calculating the average
				temp[row][col] = average; 	// Allocates the average in the specific location
			}
		}
		grid = temp; 	// The grid array receives all the values stored in the temp array for average
	}
	// Method that reads a file called by the user and stores the information to the array
	public static void readFile(String fn){
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(fn)));
			m = Integer.parseInt(s.next()); // Gets the first int
			n = Integer.parseInt(s.next()); // Gets the second int
			grid = new int [m][n]; 	// Allocates Memory to grid 
			for(int r = 0; r < grid.length; r++){
				for (int c = 0; c < grid[r].length; c++){
					grid [r][c] = Integer.parseInt(s.next()); 	// Gets the next number in the file
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
	// Method that writes the current array information to a file named by the user
	public static void writeFile(String fn){
		File file = new File(fn);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
			pw.println(m); 	// Prints the number of rows in the file
			pw.println(n); 	// Prints the number of column in the file
			for(int r = 0; r < grid.length; r++){ 	// Prints the array in the file
				for(int c = 0; c < grid[r].length; c++){
					pw.printf("%2d " ,grid[r][c]); 	// Format printing adds space to the numbers when printing
				}
				pw.println(""); // Adds a space after the row
			}
		} catch (FileNotFoundException e) { // If file not found
			e.printStackTrace();
		} finally {
			if(pw != null){
				pw.close();
			}
		}	
	}
}