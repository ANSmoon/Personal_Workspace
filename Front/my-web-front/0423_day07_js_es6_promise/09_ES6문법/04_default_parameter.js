function myInfo(name, age = 20, hobby = "golf") {
  console.log(
    `name : ${name}, age : ${age}, hobby : ${hobby}`
  )
}
myInfo()
myInfo("haley", 20)
myInfo("haley")
myInfo("haley", 20, "tennis")
myInfo("IU", "29","Sing","Rap") // 맨뒤의 변수는 무시된다.
