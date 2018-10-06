
public class maind {

	public static void main(String[] args) {
		int y = 0;
		
		for(int x =0; x <5; x++){
			Number3 temp = new Number3(x,x,x,10);
			temp.finalresult = temp.justdoit();
			System.out.println(x + " " + temp.result + " " + temp.finalresult);
		}
		
	}

}
