package java04_control;

public class Ctrl04_Switch {
    public static void main(String[] args) {
    	
    	// 월이 주어질 때 각 월의 일수를 출력하시오.
        int month = 12;
        
        switch(month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            System.out.println("31일 ");
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            System.out.println("30일 ");
            break;
        case 2:
            // 4로 나누어 떨어지는 해는 윤년이다.
            // 4, 100으로 나누어 떨어지는 해는 평년이다.
            // 4, 100, 400으로 나누어 떨어지는 해는 윤년이다.
            System.out.println("28일. 윤년 고려해봐야함.");
            break;
        default:
             System.out.println("그런 월은 존재하지 않음.");
        }
    }
    
}
