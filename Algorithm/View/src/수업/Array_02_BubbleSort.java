package 수업;

import java.util.Arrays;

public class Array_02_BubbleSort {
	public static void main(String[] args) {
		int[] arr = {32, 7, 83, 54, 49, 22};
		
		for(int j = 0; j < arr.length - 1; j++) {
			for(int i = 0; i < arr.length - 1 - j; i++) {
				if(arr[i] > arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}	
		}
		System.out.println(Arrays.toString(arr));
	}
}