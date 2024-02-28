import java.util.Arrays;

public class divide_Conquer_06_MergeSort {
	public static int[] arr = { 5, 22, 32, 45, 76, 21, 45, 7, 6, 2, 4, 84, 6, 9 };
	public static int[] sortedArr = new int[arr.length];

	public static void main(String[] args) {
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		mergeSort(0, arr.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

	// left 구간의 시작 위치 / right 구간의 끝 위치
	public static void mergeSort(int left, int right) {
//		if(left >= right) return;

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid); // 왼쪽부터 분리 시작
			mergeSort(mid + 1, right); // 순차적으로 오른쪽 분리 시작
			merge(left, mid, right);
		}
	}

	public static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽의 시작 점
		int R = mid + 1; // 오른쪽의 시작 점
		int idx = left; // 정렬된 원소를 저장할 위치
		
		// 서로 아직 비교할 수 있는 값들이 남아있을 때
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			}else {
				sortedArr[idx++] = arr[R++];
			}
			// 왼쪽 구간 남아있을 경우
			if(L <= mid) {
				for(int i = L; i <= mid; i++) {
					sortedArr[idx++] = arr[i];
				}
			}
			
			// 오른쪽 구간 남아있을 경우
			else {
				for(int i = R; i <= right; i++) {
					sortedArr[idx++] = arr[i];
				}
			}
			
			// 마지막 과정
			// 원본에 반영하기
			for(int i = left; i <= right; i++) {
				arr[i] = sortedArr[i];
			}
			
		}
		
	}
}


