# board-crud

CRUD 기능을 구현한 간단한 게시판 프로그램 구현

## 세부 사항

### 1단계

- `validatePostIdExists`
    - 입력받은 id가 존재하는 게시글인지 검사
    - validate 클래스에서 하고 싶지만 post 모델에 접근해야함
    - PostService를 validator가 접근?
        - **그냥 controller에서 validate하는 것으로 구현**

## 트러블 슈팅

### 1단계

- 정수가 아닌 id 값 입력 받은 경우, 예외 처리