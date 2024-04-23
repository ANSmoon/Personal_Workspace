function myInfo(name, age=20, ...hobbies) {
  console.log(
    `이름: ${name}, 나이: ${age}\n취미:${hobbies}`
  )
}

myInfo()
myInfo("haley") // 나머지 변수들은 undefined로 나타난다.
myInfo("hugh", 35, "working", "running", "studying")
myInfo("haley", 35, "research", "working")