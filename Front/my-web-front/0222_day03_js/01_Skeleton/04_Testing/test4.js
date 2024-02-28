console.log(typeof(1 + "2"));

console.log(typeof(true + "2"));
console.log((true + "2"));
console.log(undefined + "2");

console.log('Cat' && 'Dog'); // => Dog
console.log('Cat' && ''); // => False 여서 출력 X
console.log('Cat' || 'Dog'); // => Cat
console.log('' || 'Dog'); // => Dog
