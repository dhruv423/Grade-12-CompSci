
public class VideoGames extends Item {
	private String title;
	private String console;
	private char rating;
	
	
	public VideoGames(double pPrice, double sPrice, long UPC, String tit, String cons) {
		super(pPrice, sPrice, UPC);
		this.title = tit;
		this.console = cons;	
	}

	public char getRating() {
		return rating;
	}

	public void setRating(char rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void sale(double percent_discount) {
		
	}
	
	public String toString(){
		String s = this.title + " " + this.console;
		return s;
		
	}

}
