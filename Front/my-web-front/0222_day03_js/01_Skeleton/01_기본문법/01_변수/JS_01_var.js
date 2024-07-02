// var
// 함수 스코프 //
// - 재 선언 가능, 재 할당 가능
// - 호이스팅(Hoisting) 특성이 있음

/* 코드를 작성해보세요. */


console.log(name)
var name = "진우"

// 위와 같은 코드 해석

var name; // undefined로 초기화는 시켰고,
console.log(name); // 출력
var name = "진우";