<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 상세보기</title>
<link rel="stylesheet" href="./css/tae.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
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
        	<div>
	            <div style="text-align: center;">
	    		<h1 class="title">${video.title}</h1>
			</div>

            <hr>
        </div>
        <section class="img" style="text-align: center;">
	    <div>
	        <iframe width="1280" height="720" src="${video.videoLink }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
	    </div>
</section>

        <hr>

        <section>
<div style="display: flex; justify-content: space-between;">
    <div>
        <form action="#" class="registerFormRow">
            <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" style="margin-left: 50px;">글 작성</button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <form action="review" method="POST">
                    <input type="hidden" name="action" value="write">
                    <input type="hidden" name="videoId" value="${videoId}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">
                                    <div>제목</div>
                                    <input type="textarea" name="title" id="title" style="height: 25px; width: 400px;">
                                </h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <input type="text" name="writer" id="writer" style="width: 200px;" value="익명">
                            <input type="textarea" name="content" id="content" style="height: 300px;" placeholder="리뷰를 입력하세요">
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                <button type="submit" class="btn btn-primary">등록</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </form>
    </div>
    <div>
        <input type="search" name="search" id="search" placeholder="🔎제목, 내용으로 검색" style="background: transparent; margin-right : 50px">
    </div>
</div>
	
            <hr>
            
            <div>
                <div>
                    <ul>
                        <li class="d-flex justify-content-around row">
                            <span class="col-6 col-md-1">번호</span>
                            <span class="col-6 col-md-7">제목</span>
                            <span class="col-6 col-md-1">작성자</span>
                            <span class="col-6 col-md-1">조회수</span>
                            <span class="col-6 col-md-2">작성시간</span>
                        </li>
                        <hr>
                        <c:forEach items="${reviewList }" var="review">
                        <li class="d-flex justify-content-around row">
                            <span class="col-6 col-md-1">${review.id }</span>
                            <span class="col-6 col-md-7"><a href="review?action=reviewDetail&id=${review.id }">${review.title }</a></span>
                            <span class="col-6 col-md-1">${review.writer }</span>
                            <span class="col-6 col-md-1">${review.viewCnt }</span>
                            <span class="col-6 col-md-2">${review.regDate }</span>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
                <div>
                </div>
            </div>
        </section>
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
<!-- footer 영역 시작 -->
</body>
</html>