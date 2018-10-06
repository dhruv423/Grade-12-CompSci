import java.util.Scanner;
public class BinarySearch {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		int [] list1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
				41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		System.out.println("What number do you want to search for?");
		int key1 = sc.nextInt();
		int found = binarySearchR(list1, 0, 24, key1);
			if(found == -1){
				System.out.println("Not in List");
			}
			else{
				System.out.println(key1 + " found at index " + found);
			}

	}
	
	public static int binarySearch(int [] list, int key){
		int min = 0;
		int max = list.length-1;
		int middle;
		middle = (max + min) / 2;
		while (min <= max){
			
			if(key > list[middle]){
				min = middle + 1;
			}
			else if(key < list[middle]){
				max = middle - 1;
			}
			else if ( list[middle] == key )
	         {
	           return middle;
	         }
			middle = (max + min) / 2;
		}
		return -1;
	}

	public static int binarySearchR(int [] list, int start, int end, int searchFor){
		int middle = (start + end)/2;
		
		if(end < start){
			return -1;
		}
		if(searchFor == list[middle])
			return middle;
		else if(searchFor > list[middle])
			return binarySearchR(list, middle + 1, end, searchFor);
		else
			return binarySearchR(list, start, middle - 1, searchFor);
		
		
	}
}
	