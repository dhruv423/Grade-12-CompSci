
public class Main {

	public static void main(String args []){
		Owner s = new Owner("Dhruv", "125 dusk", 464865);
		Store st = new Store("125 asdf", "all in one");
		
		Owner.addBusiness(st);
		VideoGames vg = new VideoGames(10, 90, 65867, "GTA V", "PS4");
		Magazine mg = new Magazine(2, 10, 5645, "Mcleans", "7647", "Pub");
		st.addGame(vg);
		st.addMagazine(mg);
		
		System.out.println(st.getGame(65867));
		System.out.println(st.getMagazine(556645));


	}
}
