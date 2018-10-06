import java.util.Random;
public class SortingMethods {

	public static void main(String[] args) {
		Random ran = new Random();
		int [] list = new int[20];
		
		for(int i = 0; i < list.length; i++){
			list[i] = ran.nextInt(1001);
		}
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + " ");
		}
		System.out.println(" ");
		sort_method1(list);
		//sort_method2(list);
		
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + " ");
		}

	}
	
	public static void sort_method1(int [] list){
		for(int i = 0; i < list.length - 1; i++){
			for(int j = 0; j < i; j++){
				if(list[j] > list[j+1]){
					int temp = list[j+1];
					list[j+1] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	public static void sort_method2(int [] list){
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list.length - 1 - i; j++){
				if(list[i] < list[j]){
					int temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}
	

}
