
public class Magazine extends Item {
	private String title;
	private String date;
	private String publisher;
	

	public Magazine(double pPrice, double sPrice, long UPC, String t, String date, String pub) {
		super(pPrice, sPrice, UPC);
		this.title = t;
		this.date = date;
		this.publisher = pub;
		
	}
	public String getTitle() {
		return title;
	}

	@Override
	public void sale(double percent_discount) {
		// TODO Auto-generated method stub
		
	}
	public String toString(){
		String s = this.title + " " + this.date + " " + this.publisher;
		return s;
	}




}
