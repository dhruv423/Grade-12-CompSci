
public class InsertionSort {

	public static void main(String[] args) {
		int a[] = {8,6,1,3,4,9,15,2};
		
		for(int i = 1; i < a.length; i++){
			int value = a[i];
			int j = i-1;
			while(j>=0 && a[j] > value ){
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = value;
		}
	}

}
