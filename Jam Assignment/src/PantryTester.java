import java.util.Scanner;
public class PantryTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		String username = System.getProperty("user.name");
		System.out.println("Welcome to " + username +"'s Pantry!");
		
		System.out.println("Enter the infomation about Jar 1:");
		System.out.println("Enter the flavour of the jam:");
		String n = sc.nextLine();
		System.out.println("Enter the date of the jam:");
		String d = sc.nextLine();
		System.out.println("Enter the size of the jar:");
		int s = Integer.parseInt(sc.nextLine());
		Jam jar1 = new Jam(n,d,s);
		
		System.out.println("Enter the infomation about Jar 2:");
		System.out.println("Enter the flavour of the jam:");
		String n1 = sc.nextLine();
		System.out.println("Enter the date of the jam:");
		String d1 = sc.nextLine();
		System.out.println("Enter the size of the jar:");
		int s1 = Integer.parseInt(sc.nextLine());
		Jam jar2 = new Jam(n1,d1,s1);
		
		System.out.println("Enter the infomation about Jar 3:");
		System.out.println("Enter the flavour of the jam:");
		String n2 = sc.nextLine();
		System.out.println("Enter the date of the jam:");
		String d2 = sc.nextLine();
		System.out.println("Enter the size of the jar:");
		int s2 = Integer.parseInt(sc.nextLine());
		Jam jar3 = new Jam(n2,d2,s2);
		
		Pantry all = new Pantry(jar1, jar2, jar3);
		
		
		while(loop){
			System.out.println("The jams are:");
			System.out.println(all);
			
			System.out.println("Enter your selection (1, 2, or 3):");
			int jamChoice = sc.nextInt();
			
			if(jamChoice == 1){
				System.out.println("Enter amount to spread:");
				int spreadNum = sc.nextInt();
				if(jar1.isEmpty()){
					System.out.println("No jam in the Jar!");
					System.out.println("");
				}
				else
					all.spread(jar1, spreadNum);
			}
			else if(jamChoice == 2){
				System.out.println("Enter amount to spread:");
				int spreadNum = sc.nextInt();
				if(jar2.isEmpty()){
					System.out.println("No jam in the Jar!");
					System.out.println("");
				}
				else
					all.spread(jar2, spreadNum);
			}
			else if(jamChoice == 3){
				System.out.println("Enter amount to spread:");
				int spreadNum = sc.nextInt();
				if(jar3.isEmpty()){
					System.out.println("No jam in the Jar!");
					System.out.println("");
				}
				else
					all.spread(jar3, spreadNum);
			}
			else if(jamChoice == -1){
				System.out.println("Good-bye");
				loop = false;
			}
			else{
				System.out.println("Jam " + jamChoice + " doesn't exist");
				System.out.println("Retry!");
			}
		}
		
	}
}

