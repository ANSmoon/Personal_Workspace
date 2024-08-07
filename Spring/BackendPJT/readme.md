README.md

# Ssafit_BakeEnd 관통 프로젝트 - 2024 - 03 - 15

## 프로젝트 계획 이유

> Java Back_End의 핵심 기술인 Servlet/JSP의 개념을 이해하고, Web Server를 구축하기 위한 프로젝트 진행. Model, View, Controller의 MVC 모델을 적용하여 동적인 Page를 구현한다.
>
> 2주간의 백엔드 수업 내용과 이전의 Front_End project의 결과물을 접목해 Front-Back_End 의 완성형 Web Server를 만들고자 한다.
>
> 크게 2가지의 기본 기능을 구현한다. 전체적인 틀은 다양한 운동영상정보와 리뷰를 위한 백엔드 기능이고, 첫번째 기능은 메인페이지에서 조회수 기준 영상 목록이나 운동 부위별 영상같은 범위형 리스트 출력을 위한 메인 페이지 Back_End 기능 구현이다. 두번째 기능은 운동영상에 대한 리뷰 목록 조회, 등록, 수정, 상세 내용 조회, 삭제 기능이다.
>
> 처음 계획에서는 위 기본기능을 구현하는 것을 목표로 하였으며, 좀 더 시간이 필요한 기능들에 대해서는 추가 학습을 통해 완성하고자 합니다.

---

1. 팀원

- 홍선주[Main], 문범수[sub]

---

2. Stack Technology

> 가. Review 관리 기능 Servlet
>
> 1) ReviewController
>    ----------------
>
>
>    1) **HTTP 메서드**
>
>    * 모든 HTTP 요청을 처리하기 위해 service() 메서드를 재정의
>
>    2. **요청 처리**
>
>    * 요청의 "action" 매개변수 값에 따라 요청을 다른 메서드(doList, doWrite, doDetail, doUpdate, doRemove)로 전달
>
>    3. **CRUD 작업**
>
>    * doList: 리뷰 목록을 검색하고 JSP 페이지로 전달하여 표시
>    * doWrite: 새 리뷰를 작성
>    * doDetail: ID에 해당하는 특정 리뷰의 세부 정보를 검색하여 JSP 페이지로 전달
>    * doUpdate: 제공된 매개변수를 기반으로 기존 리뷰를 업데이트
>    * doRemove: ID에 해당하는 리뷰를 삭제
>
>    4. **요청 전달 및 리디렉션**
>
>    * 요청을 렌더링을 위해 적절한 JSP 페이지로 전달하거나 처리 후 다른 URL로 리디렉션 시행
>
>    이 서블릿은 웹 애플리케이션에서 리뷰 관련 작업을 처리하기 위한 기본적인 컨트롤러 기능을 제공
> 2) ReviewRepositoryImpl
>    --------------------
>
>
>    1. **싱글톤 패턴 사용**
>
>    * private 생성자를 통해 외부에서 인스턴스화되지 않도록 설정
>    * getInstance() 메서드를 통해 외부에서 유일한 인스턴스에 접근할 수 있도록 설정
>
>    2. **리뷰 데이터 관리**
>
>    * HashMap을 사용하여 리뷰 데이터를 관리. 각 리뷰는 고유한 ID를 key로 가짐
>    * 초기 데이터로 몇 개의 리뷰를 미리 추가하여 초기화합니다.
>
>    3. **리뷰 작업 메서드 구현**
>
>    * selectAll(): 모든 리뷰를 가져오는 메서드입니다.
>    * selectOne(int id): 특정 ID에 해당하는 리뷰를 가져오는 메서드
>    * insertReview(Review review): 새로운 리뷰를 추가하는 메서드
>    * updateReview(Review review): 기존 리뷰를 수정하는 메서드
>    * deleteReview(int id): 특정 ID에 해당하는 리뷰를 삭제하는 메서드
>    * updateViewCnt(int id): 특정 ID에 해당하는 리뷰의 조회수를 증가시키는 메서드
> 3) ReviewServiceImpl
>    -----------------
>
>
>    1. **싱글톤 패턴 사용**
>
>    * private 생성자를 통해 외부에서 인스턴스화되지 않도록 설정
>    * getInstance() 메서드를 통해 외부에서 유일한 인스턴스에 접근할 수 있도록 설정
>
>    2. **의존성 주입**
>
>    * ReviewRepository를 사용하여 데이터 액세스를 수행
>    * ReviewRepositoryImpl 클래스의 인스턴스를 가져와 repository 필드에 할당
>
>    3. **리뷰 작업 메서드 구현**
>
>    * getList(): 모든 리뷰를 가져오는 메서드
>    * getReview(int id): 특정 ID에 해당하는 리뷰를 가져오는 메서드. 동시에 해당 리뷰의 조회수를 증가
>    * writeReview(Review review): 새로운 리뷰를 작성하는 메서드
>    * modifyReview(Review review): 기존 리뷰를 수정하는 메서드
>    * removeReview(int id): 특정 ID에 해당하는 리뷰를 삭제하는 메서드
>
>    4. **싱글톤 인스턴스 반환** :
>
>    * getInstance() 메서드를 통해 ReviewServiceImpl의 유일한 인스턴스를 반환
>
>    이 클래스는 ReviewService 인터페이스를 구현하여 리뷰 관련 비즈니스 로직을 처리
>
> 나. Reveiw 관리 Interface
>
> - ReviewRepository, ReviewService Servlet의 interface
>
> 다. 영상 관리 Servlet
>
> 라. 기능 구현에 필요한 다양한 메소드 구현

---

3. 기능 구현 및 서비스

> 1) 기본 기능
>
> - 메인페이지에서 조회 가능한 운동영상들을 보여주고, 화면 사이즈에 맞게 적절히 배치가 조정되도록 구현함
> - 메인페이지의 영상들을 조회수 별로 나열하고, 운동부위별로 항목화하여 나타내도록 함
> - 각 영상별로 연결되는 리뷰페이지가 상이하고, 각 리뷰 페이지에서는 리뷰 내용에 대한 조회, 삭제, 수정, 상세 내용 조회, 등록이 가능하도록 설계
> - 로그인, 로그아웃 및 회원가입 기능 [추가]
> - 관심있는 영상에 대한 찜기능 [심화]
>
>   2) 결과
> - 리뷰 기능에 대해서는 전부 구현 완료
> - 각 영상별로 링크 연결 및 항목별 출력 기능은 미구현
> - 대신 특정 영상에 대한 리뷰페이지 연결기능 구현 완료
> - 추가 및 심화기능에 대해서는 시간 및 난이도 측면에서 어렵다고 판단하여 미구현

---

4. 겪은 어려움

> - 상황에 따라서 웹 페이지가 열릴때도 있고, 그렇지 않을때도 있어서 기능을 구현하는데 있어 코드 작성 시간에 못지않은 설정하는 시간이 소요됨.
> - 리뷰 관리 기능을 먼저 구현하고 페이지 기능을 나중에 하다 보니 시간적으로 부족했고, 모든 영상에 대해 링크를 연결하는 과정이 디버깅이 많이 필요한데 해당 과정에 투자할 수 있는 여력이 부족했음.
> - 결국 리팩토링 시간이 늦춰져 시간에 쫓기어 기능을 구현하다 보니 순간적으로 번아웃이 왔고, 간단한 문제에 시간소비가 길어져 효율적인 코딩과 거리가 멀어짐
> - 인터페이스에서 구현하고자 하는 메소드가 많아지다 보니 일부 누락된 메소드로 인해 전체적인 기능이 저하되는 실수도 하게 됨.
> - ___기능적인 측면에서 전체적으로 같이 구현해보며  어려운 부분을 도와가며 작업했고, 결과적으로 옳은 선택이었다고 생각됨. 다만, 중간에 일부 기능에 대해서는 분업을 통해 작업을 이어나갔고, 유동적으로 작업 방식을 바꾸는 방법이 유효했음.___

---

5. 어려움 극복 방법

> - 기존의 코드에서 메소드로 파일내 데이터를 읽어오고 저장하는 기능을 구현하지 않고, 메인에서 구현하려다 보니 구조적으로 비효율 적이었고, 읽어들인 List가 Null값을 참조하는 문제 발생
> - 해당 문제에 대해 굳이 메인클래스에서 데이터를 읽고, 저장하는 것보단 메소드로 구현해서 코드 안정성을 올리는 것이 낫다고 판단하여 Load와 Save 기능 메소드 작성
> - 또한 파일 입출력과 관련해서 예외 처리가 까다로웠는데 해당 부분은 인터페이스를 작성해 처리함
> - 각자의 코드에서 발생한 문제점은 기능적으로 어떤 부분인지 먼저 파악한 후 서로에게 공통적으로 해당하는 사항이면 집중적으로 문제해결에 초점을 둠.

---

6. 이후의 포부

> - 이전 프론트엔드 프로젝트를 참여하지 않다 보니 JSP를 다루는 작업이 서툴렀고, 선주님에게 계속 확인해가며 작업을 하다 보니 작업효율이 그리 좋지 않았음. 백엔드만 한다고 웹 페이지를 구현할 수 있는게 아니라는걸 다시한번 크게 체감했고, 양쪽에 대한 이해가 필수적이라는 것을 깨달음
> - 따라서 쉬운 부분일지라도 작성된 코드를 참고하지 않으면서 자력으로 처음부터 끝까지 작성할 수 있는 힘을 기를 필요가 있다고 생각됨
> - 아직 Servlet에 대한 이해가 많이 부족하다고 생각되었으며, 이후 Spring과 DB에서 원활한 작업을 위해선 더욱더 깊은 이해가 필요하다고 생각됨.

---

7. 기타 소감

> - 하루만에 작업을 끝마쳐야 하기에 쉬는시간도 없이 열심히 달렸지만 시간부족을 겪었고, 오류가 났을때 생각보다 기초적인 실수에서 비롯된 상황이 많았기에 좀 더 침착하게 코딩하는 습관을 들여야 겠다는 생각이 들었음.
> - 여러번 프로젝트를 거치다 보니 구현할 수 있는 기능이 많아지고, 향후에 어떤 점을 향상시키고, 추가하고 싶은지에 대한 내용도 좀 더 구체화된 느낌이 들었고, 자력으로 효율적인 개발을 위해선 기초적인 역량을 하루빨리 끌어올려야 겠다는 목표의식을 갖게 됨.

---
