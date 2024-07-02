// 0, null, NaN, undefined, ' ' => false

console.log(1+0);
console.log(1+null);
console.log(1+undefined);
console.log(1+false);
console.log(1+' ');
console.log(1+ NaN);

console.log(typeof NaN);
console.log(typeof undefined);
console.log(typeof false);
console.log(typeof ' ');
console.log(typeof null);


console.log(1===1);
console.log(+1===-1);
console.log(+0===-0);
console.log(1=="1");
console.log(NaN === NaN); // javaScript Error
console.log(Object.is(NaN, NaN)); // 값과 type의 일치 여부 확인
console.log(Object.is(+0, -0)); // javaScript Error
