window.onload = function () {
  if (!document.querySelector(".content-user-list-ul")) return;
  
  // 비동기 통신을 위해 새로운 XMLHttpRequest 요청 생성
  const xhr = new XMLHttpRequest();
  const method = "GET"; // 요청 method
  const url = "data/movie.json"; 

  xhr.open(method, url);
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = function () {
    if (xhr.readyState === xhr.DONE) {
      if (xhr.status === 200) {
        const resJson = JSON.parse(xhr.responseText);
        const movieData = resJson.movies;

        localStorage.setItem("movieData", JSON.stringify(resJson));

        // 사용자 목록을 가져와서 각 사용자에 대한 HTML 요소 생성
        let movieList = document.querySelector(".content-user-list-ul");
        for (let i = 0; i < movieData.length; i++) {
          let movieItem = `
            <li>
              <div class="list-item">
                <div>
                  <img src="${movieData[i]["img"]}" alt="" />
                </div>
                <div class="movie-info">
                  <div>
                    <div class = "title">${movieData[i]["title"]}</div>
                    <div>${movieData[i]["genre"]}</div>
                    <div>${movieData[i]["director"]}</div>
                    <div>${movieData[i]["runningTime"]} 분</div>
                  </div>
                  <button class = "btn" onclick="addToWishlist(${i})">★</button>
                </div>
              </div>
            </li>
          `;
          movieList.innerHTML += movieItem;
        }
      }
    }
  };
  xhr.send();
  displayWishlist()
};

function addToWishlist(index) {
  // localStorage에 저장된 영화 데이터 가져오기
  let movieData = JSON.parse(localStorage.getItem("movieData"));
  if (!movieData) {
    console.error("영화 데이터를 찾을 수 없습니다.");
    return;
  }

  // 선택된 영화 가져오기
  let selectedMovie = movieData.movies[index];

  // 찜 리스트에 영화 정보 추가
  let wishlist = JSON.parse(localStorage.getItem("wishlist")) || [];

  // 중복된 영화인지 확인
  if (wishlist.findIndex(movie => movie.title === selectedMovie.title) === -1) {
    wishlist.push(selectedMovie);
    localStorage.setItem("wishlist", JSON.stringify(wishlist));
    // 화면에 찜 리스트 출력
    displayWishlist();
  } else {
    console.log("이미 찜한 영화입니다.");
  }
}


// 찜 리스트를 화면에 출력하는 함수
function displayWishlist() {
  const wishlist = JSON.parse(localStorage.getItem("wishlist")) || [];
  const wishlistContainer = document.querySelector(".wishlist-container");

  // 이전에 추가된 영화 목록을 제거
  wishlistContainer.innerHTML = "";

  // 찜 리스트에 있는 영화들을 화면에 추가
  wishlist.forEach(function(movie) {
    let wishlistItem = `
      <li>
        <div>${movie.title}</div>
        <div>${movie.genre}</div>
        <div>${movie.director}</div>
        <div>${movie.runningTime} 분</div>
      </li>
    `;

    // 찜 리스트에 영화 정보를 추가하고 한 줄씩 내려가면서 출력
    wishlistContainer.innerHTML += wishlistItem;
  });
}
