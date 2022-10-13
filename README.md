# week04-Spring-Intermediate-

# 4 주차 개인 과제

## 유스케이스

![유스케이스04.drawio.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fe889901-73c7-4a76-98dd-1b76d23f4143/%EC%9C%A0%EC%8A%A4%EC%BC%80%EC%9D%B4%EC%8A%A404.drawio.png)

## API 설계

| API | METHOD | URL | Request  | Response |
| --- | --- | --- | --- | --- |
| 회원 가입
signup | POST | /user/signup | {
”nickName” : nickName,
”pw” : pw,
”pw2” : pw2
} |  |
| 로그인
login | POST | /user/login | {
”nickName” : nickName,
”pw” : pw,
} | {
”access_toeken” : access_toeken,
”refresh_token” : refresh_token
 |
| 게시물 생성
(인증 후)
createPost | POST | /auth/post | 
”title” : title,
”content” : content
} |  |
| 게시물 전체 조회
(작성 날짜 
기준 내림차순)
getPostList | GET | /post |  | {
”title” : title,
”nickName” : nickName,
”createdAt” : createdAt
} |
| 게시물 상세 조회
getPost | GET | /post/{id} |  | {
”title” : title,
”content” : content,
”createdAt” : createdAt
} |
| 게시물 수정
(인증 후)
updatePost | PUT | /auth/post/{id} | {
”title” : title,
”content” : content
} |  |
| 게시물 삭제
(인증 후)
deletePost | DELETE | /auth/post/{id} |  |  |
| 댓글 생성
(인증 후)
createComment | POST | /auth/comment | {
”postId” : postId,
”comment” : comment
} |  |
| 댓글 전체 조회
getComment | GET | /comment/{id} |  | {
”postId” : postId,
”comment” : comment
} |
| 댓글 수정
(인증 후)
updateComment | PUT | auth/comment/{id} | {
”postId” : postId,
”comment” : comment
} |  |
| 댓글 삭제
(인증 후)
deleteComment | DELETE | auth/comment/{id} |  |  |

## Refactoring 순서

- [x]  CRUD  → 인증 기능 없이 게시물 CRUD (U, D 접근 제한 X )
- [x]  디테일 → createdAT 변수 포함, 내림차순 …
- [x]  연관 관계 → 각 게시물에 댓글 CRUD  (단방향 / 양방향 고민)→ 다대일 단방향이 적합 [https://velog.io/@jyyoun1022/JPA-연관-관계-정리](https://velog.io/@jyyoun1022/JPA-%EC%97%B0%EA%B4%80-%EA%B4%80%EA%B3%84-%EC%A0%95%EB%A6%AC)
    - 해결 해야 할 이슈
        - [x]  게시물 삭제 시 댓글 모두 삭제
        - [x]  게시물 상세 조회 시 댓글 리턴
        - [x]  commentId 2부터 시작 [https://tecoble.techcourse.co.kr/post/2021-05-25-transactional/](https://tecoble.techcourse.co.kr/post/2021-05-25-transactional/)
        - [x]  에러 나면 id 값 하나 올라감  (1번 이슈와 유사한 문제였음)
        - [ ]  comment 반환 형식이 "text": "{"comment":"2"}”
        - [x]  url 로 PathVariable 받지 말고 thymeleaf 탬플릿으로 html 에서 받기
        
- [ ]  회원 가입, 로그인 (access 토큰 o , refresh 토큰 x)
- [ ]  User, Post, Comment 연관 관계 맺기
- [ ]  아이디, 비밀번호  →  `최소 4자 이상, 12자 이하 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`
- [ ]  로그인 체크 aop로 따로 빼서 어노테이션 만들기 ([https://tjdrnr05571.tistory.com/10](https://tjdrnr05571.tistory.com/10))
- [ ]  게시물 C, U, D 접근 제한
- [ ]  댓글 C, U, D (게시물 삭제 시 댓글 모두 삭제) 접근 제한
- [ ]  예외 처리
- [ ]  리턴 값 Entity에서 DTO 변경
