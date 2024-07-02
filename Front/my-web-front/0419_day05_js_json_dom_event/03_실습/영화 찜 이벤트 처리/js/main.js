
// 버튼 클릭 이벤트 핸들러 함수
function handler(event) {
  // 클릭된 버튼의 부모 요소에서 영화 정보를 가져오기
  const movieElement = event.target.closest('li');
  const movieTitle = movieElement.querySelector('b').innerText;
  const movieGenre = movieElement.querySelectorAll('span')[0].innerText;
  const movieDirector = movieElement.querySelectorAll('span')[1].innerText;
  const movieDuration = movieElement.querySelectorAll('span')[2].innerText;

  // 영화 정보를 콘솔에 출력
  
  console.log("영화 제목:", movieTitle);
  console.log("장르:", movieGenre);
  console.log("감독:", movieDirector);
  console.log("상영 시간:", movieDuration);
  console.clear;
}

// 페이지가 로드되었을 때 실행될 함수
document.addEventListener("DOMContentLoaded", function() {
  // 모든 버튼을 선택합니다.
  const buttons = document.querySelectorAll('button');

  // 모든 버튼에 이벤트 리스너를 추가
  buttons.forEach(function(button) {
      button.addEventListener('click', handler);
  });
});
