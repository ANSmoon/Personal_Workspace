<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT : 운동하는 사람들</title>
        <link rel="stylesheet" href="./css/main.css" />
        <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Hahmlet:wght@100..900&display=swap" rel="stylesheet">        <title>SSAFIT</title>
        
</head>
<!-- body 영역 시작 -->
    <body class="noto-serif">
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

        <!-- main 영역 시작 -->
        <main>
            <div id = "imggg">

                <div id="main-img">
                    <img src="./img/title.jpg" alt="메인화면 이미지"/>
                </div>
            </div> 
       

            <div class="search">
                <i class="fas fa-search"></i>
                <input type="search" placeholder="운동 제목 검색" class="noto-serif" style="font-size: 20px;">
            </div>

            <div class="sectionnn">
                <section class="video-list-box">
                    <div>
                        <p>최근 가장 많이 본 영상
                        </p>
                        <div class="video-list">
                        <ul>
		                    <!-- videoList를 사용하여 비디오 리스트를 출력. -->
		                    <c:forEach items="${videoList}" var="video" begin="0" end="2">
		                        <li class="video">
		                            <div class="video-img">
		                                    <iframe width="360" height="205" src="${video.videoLink }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		                            </div>
		                            <div class="video-info">
		                                <a href="review?action=reviewList&videoId=${video.id}">
		                                <div class="video-title">${video.title}</div>
		                                </a>
		                                <%-- <div class="video-cnt">
		                                    <i class="far fa-eye"></i>
		                                    <span>${video.viewCnt}</span>
		                                </div> --%>
		                            </div>
		                            <div class="video-info">
		                                <div class="video-btn">${video.exInfo}</div>
		                                <div class="video-channel">${video.channel}</div>
		                            </div>
		                        </li>
		                    </c:forEach>
		                </ul>
                            
                        </div>
                </div>
                </section>
            </div>


            <div class="sectionnn">
                <section class="video-list-box">
                    <div>
                        <p>부위별 운동 영상</p>
                        <div class="buttons">
                            <button type="button" class="noto-serif">전체</button>
                            <button type="button" class="noto-serif">전신</button>
                            <button type="button" class="noto-serif">상체</button>
                            <button type="button" class="noto-serif">하체</button>
                            <button type="button" class="noto-serif">복부</button>
                        </div>
                        <div class="video-list">
                            <ul>
                                <!-- videoList를 사용하여 비디오 리스트를 출력. -->
		                    <c:forEach items="${videoList}" var="video">
		                        <li class="video">
		                            <div class="video-img">
		                                    <iframe width="360" height="205" src="${video.videoLink }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		                            </div>
		                            <div class="video-info">
		                                <a href="review?action=reviewList&videoId=${video.id}">
		                                <div class="video-title">${video.title}</div>
		                                </a>
		                                <%-- <div class="video-cnt">
		                                    <i class="far fa-eye"></i>
		                                    <span>${video.viewCnt}</span>
		                                </div> --%>
		                            </div>
		                            <div class="video-info">
		                                <div class="video-btn">${video.exInfo}</div>
		                                <div class="video-channel">${video.channel}</div>
		                            </div>
		                        </li>
		                    </c:forEach>
                            </ul>
                        </div>
                </div>
                </section>
            </div>
            </main>
            
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

        <!-- js연결 -->
        <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    </body>
</html>