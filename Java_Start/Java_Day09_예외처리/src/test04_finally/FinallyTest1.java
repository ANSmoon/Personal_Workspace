package test04_finally;

public class FinallyTest1 {
    public static void main(String[] args) {
    	
    	// 정상 실행 시 : 1 2 4 5
    	// 예외 발생 시 : 1 3 4 5
    	// 예외 미처리 시 : 1 4 (중단)
    	// catch 문에 return이 들어가면(예외 발생시) : 1 3 4
    	// try 문에 return이 들어갔다면(정상 실행시) : 1 2 4
    	
        int num = 1;
//        int[] nums = {10};
        
        try {
            System.out.println("1");
            int i = 1 / num;
//            nums[3] = 1;
            System.out.println("2");
            return;
        } catch (ArithmeticException e) {
            System.out.println("3");
//            return;	// 이 함수를 여기서 종료
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
    }

}
