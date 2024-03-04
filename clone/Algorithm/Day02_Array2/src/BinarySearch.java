
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {12, 52, 23, 64, 75, 86};
		int result = binarySearch(arr, 0);
		System.out.println(result);
	}
	
	public static int binarySearch(int[] a, int key) {
		int left = 0;
		int right = a.length - 1;
		
		while(left <= right) {
			int middle = (left + right) / 2;
			
			if(key == a[middle]) {
				return middle;
			}
			
			else if(key > a[middle]) {
				left = middle + 1;
			}
			
			else {
				right = middle - 1;
			}
		}
		return -1;
	}
}
