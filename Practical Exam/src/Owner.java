import java.util.ArrayList;

public class Owner {
	private String name;
	private String address;
	private long sin;
	
	private static  ArrayList <Store> business = new ArrayList <Store>();
	
	public Owner(String n, String a, long s){
		this.name = n;
		this.address = a;
		this.sin = s;
	}
	
	public static void addBusiness(Store b){
		business.add(b);
	}
	
	public void removeBusiness(Store b){
		int index = business.indexOf(b);
		if(index != -1){
			business.remove(index);
		}
		
	}
}
