window.onload = function () {
  if (!document.querySelector(".content-user-list-ul")) return;
  
  // 비동기 통신을 위해 새로운 XMLHttpRequest 요청 생성
  const xhr = new XMLHttpRequest();
  const method = "GET"; // 요청 method
  const url = "data/user.json"; 

  xhr.open(method, url);
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = function () {
    if (xhr.readyState === xhr.DONE) {
      if (xhr.status === 200) {
        const resJson = JSON.parse(xhr.responseText);
        const userData = resJson.users;

        // 사용자 목록을 가져와서 각 사용자에 대한 HTML 요소 생성
        let userList = document.querySelector(".content-user-list-ul");
        for (let i = 0; i < userData.length; i++) {
          let userItem = `
            <li>
              <div class="list-item">
                <div>
                  <img src="${userData[i]["img"]}" alt="" />
                </div>
                <div class="user-info">
                  <div>
                    <div>${userData[i]["id"]}</div>
                    <div>${userData[i]["name"]}</div>
                    <div>${userData[i]["email"]}</div>
                    <div>${userData[i]["age"]} 세</div>
                  </div>
                </div>
              </div>
            </li>
          `;
          userList.innerHTML += userItem;
        }
      }
    }
  };
  xhr.send();
};


function regist() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let age = document.getElementById("age").value;

  if (!id || !password || !name || !email || !age) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      age: age,
    };

    localStorage.setItem("user", JSON.stringify(user));
    alert("사용자 등록 성공!");
    window.location.replace("login.html");
  }
}

function login() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;

  const user = JSON.parse(localStorage.getItem("user"));

  if (
    user.id &&
    user.password &&
    user.id === id &&
    user.password === password
  ) {
    alert("로그인 성공 !");
    window.location.replace("index.html");
  } else {
    alert("로그인 실패 !");
  }
}
