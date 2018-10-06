/**
 * Holds all of the jam jars
 * @author Dhruv
 *
 */
public class Pantry {
	static Jam jar1;
	static Jam jar2;
	static Jam jar3;
	/**
	 * Takes the Jam object made by the user and 
	 * copies it here 
	 * @param j1 Jam 1
	 * @param j2 Jam 2
	 * @param j3 Jam 3
	 */
	public Pantry(Jam j1, Jam j2, Jam j3){
		Pantry.jar1 = j1;
		Pantry.jar2 = j2;
		Pantry.jar3 = j3;
	}
	/**
	 * Calls the spread function from the Jam class 
	 * with the user input from pantryTester
	 * @param jamChoice Which jar of jam
	 * @param spreadNum Amount of jam that needs to be spread
	 */
	public void spread(Jam jamChoice, int spreadNum){
		jamChoice.remove(spreadNum);
	}
	/**
	 * Prints out all of the Jams
	 * @return String
	 */
	public String toString() {
		return "1:" + jar1 + " ml" + "\n2:" + jar2 + " ml" + "\n3:" + jar3 + " ml";
	}
	}

