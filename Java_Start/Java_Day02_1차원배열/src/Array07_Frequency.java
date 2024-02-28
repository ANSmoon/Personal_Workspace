import java.util.Arrays;

public class Array07_Frequency {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,1,2,3,4,5,2,3,8,1,5,5,7,8,3,6,8,4,4,7,5,4,5,7,9,3,3,1};
		
		int[] count = new int[10];
		int select = 0;
		for(int i = 0; i < arr.length; i++)
			count[arr[i]]++;
		
		System.out.println(Arrays.toString(count));
		
		int max = 0;
		
		for(int i = 0; i < count.length; i++)
		{
			if(max < count[i])
			{
				max = count[i];
				select = i;
			}
				
		}
		
		System.out.printf("%d번째가 %d번으로 가장 많습니다.",select, max);
		
		
		
	}
}
