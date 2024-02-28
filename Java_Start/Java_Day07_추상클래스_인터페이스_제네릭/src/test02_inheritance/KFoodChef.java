package test02_inheritance;

// 두 클래스 사이에 유사점(공통부분)은 있다.
// 그러나 상속 관계는 아니다.
// => 공통부분을 따로 클래스를 만들어서 관리.
//   - 나중에 변경사항이 생기거나, 업그레이드할 때 해당 클래스만 고치면 
//   연관된 모든 클래스에 적용할 수 있고, 그게 더 효율적이다.
//   - 상속에 따른 계층적 관리 => 코드의 조직화에 도움.
//   - 상속관계에 있다면 => 다형성 이용 가능.
//   - 전혀 다른 설계도 사이에, 연관성이 생긴다.
public class KFoodChef extends Chef {
    @Override
    public void cook() {
        System.out.println("한식을 조리한다.");
    }
}
