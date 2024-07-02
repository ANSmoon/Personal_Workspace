package modifier06_singleton;

public class ScoreTest {
    public static void main(String[] args) {
    	ScoreManager sm = ScoreManager.getIntance();
    	
    	// ScoreManager sm2 = new ScoreManager(); // 객체를 새로 생성할 수 없고.
    	ScoreManager sm2 = ScoreManager.getIntance();
    	
    	System.out.println(sm == sm2);

    }
}
