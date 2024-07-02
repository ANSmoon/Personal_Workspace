package java04_control;

public class Ctrl03_If_Else_If_Else {
	

    public static void main(String[] args) {
        
        int score = 97;
        
        // 90점 이상 A
        // 80점 이상 90점 미만 B
        // 70점 이상 80점 미만 C
        // 그 외 F
        
        if(score >= 90) {
            System.out.println("A");
        } else {
            if(score >= 80) {
                System.out.println("B");
            } else {
                if(score >= 70) {
                    System.out.println("C");
                } else {
                    System.out.println("F");
                }
            }
        }
        
        
    }
}
