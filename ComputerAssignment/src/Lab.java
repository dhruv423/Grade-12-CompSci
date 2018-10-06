
public class Lab {
	public static final int MAX_CAPACITY = 30;
	private int numComputers;
	static Computer computers[];
	
	
	public Lab(){
		numComputers = 0;
		computers = new Computer [MAX_CAPACITY];
	}
	
	public void installComputer(String sn, String manu, int makeYear, int purcYear, double pspeed, int ram, int expiryYear){
		if(numComputers < MAX_CAPACITY){
		computers[numComputers] = new Computer(sn, manu, makeYear, purcYear, pspeed, ram, expiryYear);
		numComputers++;
		}	
		}
	

	
	public Computer newestComputer(){
		int year = 0;
		int index = 0;
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getMakeYear() > year){
				year = computers[i].getMakeYear();
				index = i;
			}
		}
		return computers[index];
	}
	
	public Computer fastestComputer(){
		double speed = 0;
		int index = 0;
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getPspeed() > speed){
				speed = computers[i].getPspeed();
				index = i;
			}
		}
		return computers[index];
	}
	
	public Computer largestRam(){
		int ram = 0;
		int index = 0;
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getRam() > ram){
				ram = computers[i].getRam();
				index = i;
			}
		}
		return computers[index];
	}
	
	public int sameManufacturer(String manu){
		int num = 0;
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getManu().equalsIgnoreCase(manu)){
				num++;
			}
		}
		return num;
	}
	
	public Computer[] exipiringSoon(){
		int num = 0;
		int index = 0;
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getExpiryYear() == 2018){
				num++;
			}
		}
		Computer expiringSoon[] = new Computer [num];
		for(int i = 0; i < numComputers; i++){
			if(computers[i].getExpiryYear() == 2018){
				expiringSoon[index] = computers[i];
				index++;
			}
		}
		return expiringSoon;
	}
}
