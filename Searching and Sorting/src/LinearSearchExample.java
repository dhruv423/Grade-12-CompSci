import java.util.Random;
import java.util.Scanner;
public class LinearSearchExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Random ran = new Random();


		System.out.println("Enter the size of the list of ints");
		int size = sc.nextInt();
		int [] list = new int[size];
	

		for(int i = 0; i < list.length; i++){
			list[i] = ran.nextInt(1001);
		}

		for(int i = 0; i < 50; i++){
			int search = ran.nextInt(10000);
			long startTime = System.currentTimeMillis();
			int found = linearSearchTop(list, search);
			long endTime = System.currentTimeMillis();
			System.out.println("Searching for " + search);
			if(found == -1){
				System.out.println("Not in List");
			}
			else{
				System.out.println("Found at index " + found);
			}
			System.out.println("Runtime: " + (endTime - startTime));
			System.out.println("--------------------");
		}

		System.out.println("Enter the size of the list of ints");
		int size1 = sc.nextInt();
		int [] list1 = new int[size1];
		
		System.out.println("Enter numbers");
		for(int i = 0; i < list1.length; i++){
			list1[i] = sc.nextInt();
		}
		for(int i = 0; i < list1.length; i++){
			System.out.print(list1 [i] + " ");
		}
		System.out.println(" ");
		int key = sc.nextInt();
		while(key != 0){
			linearSearch2(list1, key);
			for(int i = 0; i < list1.length; i++){
				System.out.print(list1 [i] + " ");
			}
			System.out.println(" ");
			key = sc.nextInt();
		}
		


	}

	public static int linearSearch(int[] list, int key) {
		int index = -1;
		for(int i = 0; i < list.length; i++){
			if(list[i] == key){
				return i;
			}
		}
		return index;

	}

	public static int linearSearchTop(int[] list, int key){
		int index = -1;
		for(int i = list.length - 1; i >= 0; i--){
			if(list[i] == key){
				return i;
			}
		}
		return index;
	}

	public static void linearSearch2(int[] list, int key) {
		int temp = 0;
		int tempV = 0;
		for(int i = 0; i < list.length; i++){
			if(i != 0){
				if(list[i] == key){
					temp = i - 1;
					tempV = list[temp]; 
					list[temp] = key;
					list[i] = tempV;
				}
			}
		}
	}





}

