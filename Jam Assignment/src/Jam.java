/**
 * This program imitates a pantry containing three jars of jam
 * It allows you to fill it with your flavors of jam and remove
 * a certain amount of jam. It also checks for empty jam jars.
 * @author Dhruv
 *
 */
public class Jam {
	private String con;
	private String date;
	private int size;
	
	/**
	 * Takes in user input for the content, date and size
	 * of the jam
	 * @param con What type of jam it is
	 * @param date Date of entry in pantry
	 * @param size Amount of jam
	 */
	public Jam(String con, String date, int size){
		this.con = con;
		this.date = date;
		this.size = size;
	}
	/**
	 * Getter for Content
	 * @return con
	 */
	public String getCon() {
		return con;
	}
	/**
	 * Setter for content
	 * @param con the content to set it to
	 */
	public void setCon(String con) {
		this.con = con;
	}
	/**
	 * getter for date
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * setter for date
	 * @param date String date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * getter for size
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * setter for size
	 * @param size integer size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * Checks if the jam is at zero or not
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty(){
		if(this.size == 0)
			return true;
		else
			return false;
	}
	/**
	 * Takes in an integer which is the removing amount
	 * and takes only the amount left if the removing 
	 * amount is greater than amount left
	 * Prints out how many ml its removing
	 * @param remove amount to remove
	 */
	public void remove(int remove){
		int placeholder = this.size;
		this.size -= remove;
		if(this.size < 0){
			this.size = 0;
			remove = placeholder;
		}
		System.out.println("Spreading " + remove + " millitres of " + this.con);
	}
	/**
	 * Allows the capability to print info about the jar
	 * @return String
	 */
	public String toString(){
		return (this.con + "\t" + this.date + "\t" + this.size);
	}
	
	
	
	
	
	
	

}
