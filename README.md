# **API명세서(일정관리앱)**

### **[일정]**

| 기능 | Method | Url | request | response | 상태코드 |
| --- | --- | --- | --- | --- | --- |
| 일정등록 | POST | /scheduled | {
”title” : “제목”
”contents”: “내용”
”username”: “test”
} | {
”id”: 1
”title”:
”contents”:
} | 201
400: 오류 |
| 일정조회 | GET | /scheduled |  | {
”id”: 1
”title”:
”contents”:
} | 200: 정상조회 |
| 선택 일정 수정 | PUT | /scheduled/{id} | {
”title”:
”contents”:
} | {
”id”: 1
”title”:
”contents”:
} | 200: 정상수정
404: 존재하지 않는 경우 |
| 선택 일정 삭제 | DELETE | /scheduled/{id} |  |  | 200: 정상 삭제
404: 존재하지 않는 경우 |

### **[유저]**

| 기능 | Method | Url | request | response | 상태코드 |
| --- | --- | --- | --- | --- | --- |
| 유저 등록 | POST | /users | {
”username”: “test”
”email”: “test@gmail.com”
”password”: “1234”
} | {
”username”: “test”
”email”:  test@gmail.com”
} | 201
400: 오류 |
| 유저 조회 | GET | /users/{id} |  | {
”username”: “test”
”email”: “test@gmail.com”
} | 200:정상조회
404: 존재하지 않는 경우 |
| 선택 일정 삭제 | DELETE | /users/{id} |  |  | 200: 정상 삭제
404: 존재하지 않는 경우 |

### **[로그인]**

| 기능 | Method | Url | request | response | 상태코드 |
| --- | --- | --- | --- | --- | --- |
| 로그인 | POST | /users/login | {
”email”: “test@gmail.com”
”password”: “1234”
} |  | 200: 정상 로그인
 |

 ![image](https://github.com/user-attachments/assets/1b9ac0ee-bf51-4e9b-a8d5-017e8583c433)
