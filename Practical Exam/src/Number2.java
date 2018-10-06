
public class Number2 extends Number1 {
	private int n1;
	private int n2;
	public int result;
	
	
	public Number2(int n, int n_1, int n_2){
		super(n);
		n1 = n_1+10;
		n2 = n_2 - n1;
		result = 0;
	}
	
	public void execute(int num){
		result = (n1+n2) * num;
	}
}
