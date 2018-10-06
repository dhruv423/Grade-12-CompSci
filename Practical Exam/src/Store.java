import java.util.ArrayList;

public class Store {
	private String address;
	private String name;

	ArrayList <Magazine> magazine;
	static ArrayList <VideoGames> videogame;

	public Store(String address, String name){
		this.address = address;
		this.name = name;
	}


	public static void addGame(double pPrice, double sPrice, long UPC, String titl, String cons){
		if(videogame == null){
			videogame = new ArrayList <VideoGames>();
		}
		videogame.add(new VideoGames(pPrice, sPrice, UPC, titl, cons));

	}

	public void addGame(VideoGames vg) {
		if(videogame == null){
			videogame = new ArrayList <VideoGames>();
		}
		videogame.add(vg);

	}

	public void addMagazine(double pPrice, double sPrice, long upc, String t, String d, String pub){
		if(magazine == null){
			magazine = new ArrayList <Magazine>();
		}
		magazine.add(new Magazine(pPrice, sPrice, upc, t, d, pub));

	}

	public boolean removeMagazine(long targetUPC){
		for(int i = 0; i < magazine.size(); i++){
			if(magazine.get(i).UPC == targetUPC){
				magazine.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeGame(long targetUPC){
		for(int i = 0; i < videogame.size(); i++){
			if(videogame.get(i).UPC == targetUPC){
				videogame.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Magazine getMagazine(long targetUPC){
		for(int i = 0; i < magazine.size(); i++){
			if(magazine.get(i).UPC == targetUPC){
				return magazine.get(i);
			}
		}
		return null;
	}

	public VideoGames getGame(long targetUPC){
		for(int i = 0; i < videogame.size(); i++){
			if(videogame.get(i).UPC == targetUPC){
				return videogame.get(i);
			}
		}
		return null;
	}


	public void addMagazine(Magazine mg) {
		if(magazine == null){
			magazine = new ArrayList <Magazine>();
		}
		magazine.add(mg);
		
	}

}
