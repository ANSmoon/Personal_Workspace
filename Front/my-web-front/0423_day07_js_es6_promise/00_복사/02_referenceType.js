// Reference Type - Shallow Copy // 참조형 - 얕은 복사
console.log("# Reference Type - Shallow Copy")
let c = { myKey: 'original value' }
let d = c

c.myKey = 'edited value'

console.log(c) // { myKey: 'edited value' }
console.log(d) // { myKey: 'edited value' }