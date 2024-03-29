<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/login.css" />
  <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Hahmlet:wght@100..900&display=swap" rel="stylesheet">        
  
  <title>SSAFIT 로그인</title>
</head>
<!-- body 영역 시작 -->
<body class="noto-serif">
  <!-- header영역 시작 -->
  <header class="header">
      <nav class="header-nav">
          <a href="./main.html">SSAFIT</a>
          <div>
              <a href="#">로그인</a>
              <a href="#">회원가입</a>
          </div>
      </nav>
  </header>

  <!-- main 영역 시작 -->
  <main>
      <section class="login-box">
        <form>
          <div class="login-text">로그인</div>
          <div>
            <input type="text" placeholder="아이디" class="noto-serif">
        </div>
        <div>
          <input type="password" placeholder="비밀번호" class="noto-serif">
      </div>
      <div>
        <button type="button">로그인</button>
    </div>
        </form>
      </section>
  </main>
      
      <!-- footer 영역 시작 -->
      <footer>
          <div>
              <ul>
                  <li><a href="#">개인정보처리방침</a></li>
                  <li><a href="#">이용약관</a></li>
                  <li>&copy;SSAFY 대전_4반</li>
          </ul>
      </div>
  </footer>

  <!-- js연결 -->
  <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</body>
</html>