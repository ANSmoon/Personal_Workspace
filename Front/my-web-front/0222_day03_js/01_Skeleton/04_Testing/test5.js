// x();
// function x(){ // => 선언식이기 때문에 Hoisting 발생
//   console.log("x");
// }
// 
// y();
// let y = function(){ // => 표현식이기 때문에 error 발생
//   console.log("y");
// }

let plus = function (x, y) {
  let result = x + y
  return result; // 내부에 별도의 선언 없으면 return x + y로 명시 없이 출력 가능
}

let plus2 = (x, y) => {
  let result = x + y;
  return result;
}

let minus = function(x,y){
  let result = x - y;
  return result;
}

let plusminus = function(a,b,c,d,e){ // 함수를 다음과 같이 인자로 사용할 수 있음
                                     // 함수도 객체이기 때문에
  if(e === 1){
    return a(c, d);
  }else{
    return b(c,d);
  }
}

console.log(plus(1, 2));
console.log(plus2(1, 3));
console.log(minus(1,2));

console.log(plusminus(plus,minus,1,1,0));
console.log(plusminus(plus,minus,1,1,1));