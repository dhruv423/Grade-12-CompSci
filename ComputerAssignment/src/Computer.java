
public class Computer {
	private String sn;
	private String manu;
	private int makeYear;
	private int purcYear;
	private double pspeed;
	private int ram;
	private int expiryYear;
	
	public Computer(String sn, String manu, int makeYear, int purcYear, double pspeed, int ram, int expiryYear){
		this.sn = sn;
		this.manu = manu;
		this.makeYear = makeYear;
		this.purcYear = purcYear;
		this.pspeed = pspeed;
		this.ram = ram;
		this.expiryYear = expiryYear;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getManu() {
		return manu;
	}
	public void setManu(String manu) {
		this.manu = manu;
	}
	public int getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}
	public int getPurcYear() {
		return purcYear;
	}
	public void setPurcYear(int purcYear) {
		this.purcYear = purcYear;
	}
	public double getPspeed() {
		return pspeed;
	}
	public void setPspeed(double pspeed) {
		this.pspeed = pspeed;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public double compareSpeed(Computer other){
		return this.pspeed - other.pspeed;
	}
	public int compareRam(Computer other){
		return this.ram - other.ram;
	}
	public int compareAge(Computer other){
		return this.makeYear - other.makeYear;
	}
	public String toString(){
		String s = "Serial Number: \t" + sn + "\n";
		s += "Manufacturer: \t" + manu + "\n";
		s += "Year of Made: \t" + makeYear + "\n";
		s += "Year of Purchase: \t" + purcYear + "\n";
		s += "Processor Speed: \t" + pspeed + "\n";
		s += "Size of RAM: \t" + ram + "\n";
		s += "Warranty Expiry Year: \t" + expiryYear + "\n";
		return s;
	}
}
