<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
<link rel="stylesheet" href="./css/tae.css">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Hahmlet:wght@100..900&display=swap" rel="stylesheet">
</head>
<body class="body">
<!-- header영역 시작 -->
        <header class="header">
            <nav class="header-nav">
                <a href="./">SSAFIT</a>
                <div>
                    <a href="./login/login.jsp">로그인</a>
                    <a href="./">회원가입</a>
                </div>
            </nav>
        </header>
    <h1 class="title">📢운동영상 리뷰</h1>
  <hr>
  <section>
      <div style="display: flex; justify-content: flex-end; gap: 20px;">
    <div>
        <a href="review?action=reviewList&videoId=${review.getVideoId()}">
            <button type="submit" action="reviewList" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">목록</button>
        </a>
    </div>
    <div>
        <button type="submit" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">글 수정</button>
        <!-- Modal -->
        <form action="review" method="POST">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${review.id}">
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">
                                <div>제목</div>
                                <input type="textarea" name="title" id="title" style="height: 35px; width: 400px;" value="${review.title}">
                            </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <input type="text" name="writer" id="writer" style="width: 200px;" value="${review.writer}" readonly>
                        <input type="textarea" name="content" id="content" style="height: 300px;" value="${review.content}">
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            <button type="submit" class="btn btn-primary">수정</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div>
        <a href="review?action=delete&id=${review.id}">
            <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" style = margin-right:50px>글 삭제</button>
        </a>
    </div>
</div>

      <hr>
    <div>
      <ul>
        <li class="d-flex justify-content-around row">
          <span class="col-6 col-md-2">제목</span>
          <span class="col-6 col-md-6">${review.title }</span>
          <span class="col-6 col-md-2">${review.writer }</span>
          <span class="col-6 col-md-2">${review.regDate }</span>
        </li>
      </ul>
    </div>
    <hr>
    <div>
      <ul>
        <li class="d-flex justify-content-around row">
          <span class="col-6 col-md-2">내용</span>
          <span class="col-6 col-md-10">${review.content }</span>
        </li>
      </ul>
    </div>
  </section>
  <!-- footer 영역 시작 -->
           <footer>
                <div>
                    <ul>
                        <li><a href="#">개인정보처리방침</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li>&copy;SSAFY 대전_4반_홍선주_문범수</li>
                </ul>
            </div>
        </footer>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <!-- <script>
    // "목록" 버튼 클릭 시 이벤트 핸들러
    document.getElementById("goToList").addEventListener("click", function() {
      // 페이지를 옮길 경로를 여기에 입력
      window.location.href = "review.html";
    });
  </script> -->
</body>
</html>