
public class Number3 extends Number2 {
	
	private int offset;
	public int finalresult;
	
	public Number3(int n, int n_1, int n_2, int _offset){
		super(n, n_1, n_2);
		offset = _offset;
	}
	
	public int justdoit(){
		super.execute(super.meth1());
		return super.result + super.num + offset;
	}
	
	
}
