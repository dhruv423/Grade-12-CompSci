import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LabTester {

	public static void main(String[] args) {
		Lab l1 = new Lab();
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader("computer.txt")));
			int size = Integer.parseInt(s.next());
			for(int i = 0; i < size; i++){
				l1.installComputer(s.next(), s.next(), Integer.parseInt(s.next()), Integer.parseInt(s.next()), Double.parseDouble(s.next()), Integer.parseInt(s.next()), Integer.parseInt(s.next()));
			}
		} catch( FileNotFoundException e){ // If file is not found
			System.out.println("File was not found!");
		} finally {
			if (s!=null){
				
			}
		}
		Scanner sc = new Scanner (System.in);
		System.out.println("The specs of the newest computer: \n");
		System.out.println(l1.newestComputer());
		
		System.out.println("");
		System.out.println("The specs of the fastest computer: \n");
		System.out.println(l1.fastestComputer());
		if(l1.fastestComputer() == l1.largestRam()){
			System.out.println("This computer has the largest size of RAM");
		}
		else
			System.out.println("This computer does not have the largest RAM");
		
		System.out.print("Enter the name of a manufacturer: ");
		String userManu = sc.nextLine();
		System.out.print("The number of the computers that are manufactured by " + userManu);
		System.out.println(" are " + l1.sameManufacturer(userManu));
		
		Object[] temp = l1.exipiringSoon();
		
		for(int i = 0; i < temp.length; i++){
			System.out.println(temp[i]);
		}
		
	}

}
