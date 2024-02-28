
public class sequentialSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 10)
				index = i;
		}
		System.out.println(index);
		int result = searchByfor(arr, 4);
		System.out.println(result);
		int result_wh = searchBywhile(arr, 5);
		System.out.println(result_wh);
	}

	public static int searchByfor(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;
	}
	
	public static int searchBywhile(int[] arr, int key) {
		int i = 0;
		while(i < arr.length) {
			
			if (arr[i] == key)
				return i;
			i++;
		}
		return -1;
	}
}
