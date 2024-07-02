// 페이지가 로드되었을 때 실행될 함수
document.addEventListener("DOMContentLoaded", function() {
  // 모든 버튼을 선택합니다.
  const buttons = document.querySelectorAll('button');

  // 모든 버튼에 이벤트 리스너를 추가
  buttons.forEach(function(button) {
      button.addEventListener('click', handler);
  });
});

// 버튼 클릭 이벤트 핸들러 함수
function handler(event) {
    // 찜 리스트가 저장될 배열
    const likedMovies = []

  // 클릭된 버튼의 부모 요소에서 영화 정보를 가져오기
  const movieElement = event.target.closest('li');
  const movieTitle = movieElement.querySelector('b').innerText;
  const movieGenre = movieElement.querySelectorAll('span')[0].innerText;
  const movieDirector = movieElement.querySelectorAll('span')[1].innerText;
  const movieDuration = movieElement.querySelectorAll('span')[2].innerText;

  const movie = {
    title : movieTitle,
    genre : movieGenre,
    director : movieDirector,
    duration : movieDuration
  };

  likedMovies.push(movie);

  // 영화 정보를 콘솔에 출력
  console.log("영화 제목:", movieTitle);
  console.log("장르:", movieGenre);
  console.log("감독:", movieDirector);
  console.log("상영 시간:", movieDuration);
  console.clear;

  // 찜 리스트가 비어있는 경우 메시지를 표시합니다.
  if (!likedMovies || likedMovies.length === 0) {
    const aside = document.querySelector("aside");
    aside.innerHTML = "<h3>찜리스트</h3>아직 찜한 영화가 없습니다....";
    return;
  }

    // 찜 리스트가 비어있지 않은 경우 각 영화 정보를 출력합니다.
    const aside = document.querySelector("aside");
    const ul = document.createElement("ul");
  
    likedMovies.forEach(function(movie) {
        const li = document.createElement("li");
        li.textContent = `${movie.title} - ${movie.genre} - ${movie.director} - ${movie.duration}`;
        ul.appendChild(li);
    });
    aside.appendChild(ul);
}